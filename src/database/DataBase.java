package database;


import character.Character;
import character.Warrior;
import character.Wizard;
import game.boardGame.cell.attackEquipment.AttackEquipment;
import game.boardGame.cell.attackEquipment.spell.Spell;
import game.boardGame.cell.attackEquipment.weapon.Weapon;
import menu.Navigation;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

/**
 * This object deals with all interaction with DB
 * Features implemented : save / restore / update / delete Character
 *
 * @author Tarik
 *
 * @see game.Game
 * @see Navigation
 */
public class DataBase {

    // Attributes
    private int characterId;

    // Constructors
    public DataBase() {

    }

    // Methods
    /**
     * This method load the file configuration and set the connexion with the DB
     *
     * @return Object Connexion
     * Return the object which permit to established the connexion with DB
     * @throws Exception Load file fail
     *                   OR
     *                   Connexion to DB failed
     */
    public Connection loadDBConfigurationAndSetConnection() throws Exception {

        // Import the configuration file for DB
        Properties props = new Properties();

        try (FileInputStream file = new FileInputStream("src/database/conf.properties")) {
            props.load(file);
        }

        // Get the information to set the connexion with the DB
        Class.forName(props.getProperty("jdbc.driver.class"));
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        String url = props.getProperty("jdbc.url");
        try  {
            Connection connection = DriverManager.getConnection(url, login, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to save the information of a character in DB
     *
     * @param type                  String (Guerrier ou Magicien)
     * @param name                  String
     * @param life                  int
     * @param attack                int
     * @param attackEquipment       String
     * @param attackEquipmentDamage int
     * @param characterPosition     int
     * @throws Exception Failed INSERT INTO in DB
     */
    public void saveCharacter(String type, String name, int life, int attack, String attackEquipment, int attackEquipmentDamage, int characterPosition, String difficultLevel) throws Exception {
        Connection connection = loadDBConfigurationAndSetConnection();

        if (characterPosition != 64) {
            // Insert into DB all information of the player (method without a prepared statement)
            String requestSql = "INSERT INTO Hero (type, name, life, attack, attackEquipment, attackEquipmentDamage, characterPosition, difficultLevel) " +
                    "Values('" + type + "', '" + name + "', '" + life + "', '" + attack + "', '" + attackEquipment + "', '" + attackEquipmentDamage + "', '" + characterPosition + "','"+difficultLevel+"')";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(requestSql);
            }
        } else {
            System.out.println("Vous avez déjà fini le jeu, vous ne pouvez sauvegarder le personnage :)");
        }
    }

    /**
     * Method to restore a Character with his information and his last Position in the game
     *
     * @param navInstance Navigation
     * @return Return an instance of the character selected (Wizard or warrior)
     * @throws Exception Failed Query to DB
     *                   <p>
     *                   {@link Navigation#askQuestion(ArrayList)}
     */
    public ArrayList<Object> restoreCharacter(Navigation navInstance) throws Exception {

        Character player = null;
        ArrayList<Object> test = new ArrayList<>();

        Connection connection = loadDBConfigurationAndSetConnection();

        // request to send to DB
        String requestSql = "SELECT id, type, name, life, attack, attackEquipment, attackEquipmentDamage, characterPosition, difficultLevel FROM Hero";

        // Try to execute the query
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(requestSql);

            // i permit to give a number for each row looped
            int i = 1;

            // Step to next row
            rs.next();

            // add in the this list all the questions that i need to ask to the user
            ArrayList<String> questions = new ArrayList<String>();
            questions.add("Veuillez sélectionner un personnage :)");

            // while i have characters i display their information
            while (!rs.isAfterLast()) {
                questions.add(i + " - Nom: " + rs.getString("name") + " || Vie: " + rs.getInt("life") + " || Attaque: " + rs.getInt("attack") + " || Arme équipé: " + rs.getString("attackEquipment") + " || Points d'attaques de l'arme: " + rs.getInt("attackEquipmentDamage") + " Position du joueur : " + rs.getInt("characterPosition"));
                rs.next();
                i++;
            }

            // navInstance.askQuestion method in package Menu permit to return the user choice (an int)
            // rs.absolute : moves the cursor to the related index
            if (rs.absolute(navInstance.askQuestion(questions))) {

                String attackEquipmentName = rs.getString("attackEquipment");
                int attackEquipmentDamage = rs.getInt("attackEquipmentDamage");


                if (rs.getString("type").equals("Warrior")) {
                    player = new Warrior(rs.getString("name"), "", 5, 5, 10, 10  );
                    player.setAttackEquipment(new Weapon(attackEquipmentName, attackEquipmentDamage));

                } else if (rs.getString("type").equals("Wizard")) {
                    player = new Wizard(rs.getString("name"), "", 8, 3, 6, 15);
                    player.setAttackEquipment(new Spell(attackEquipmentName, attackEquipmentDamage));
                }

                // Now we have either a Warrior or Wizard we can set him all data
                player.setLife(rs.getInt("life"));
                player.setAttack(rs.getInt("attack"));
                player.setCharacterPosition(rs.getInt("characterPosition"));
                this.characterId = rs.getInt("id");

                test.add(player);
                test.add(rs.getString("difficultLevel"));

            }
        }
        return test;
    }

    /**
     * Method to update an existing character in DB
     * Also it will be deleted after the update if he end the game
     *
     * @param name                  String
     * @param life                  int
     * @param attack                int
     * @param attackEquipment       String
     * @param attackEquipmentDamage int
     * @param characterPosition     int
     * @throws Exception Fail during the preparation of the request
     */
    public void updatePlayerInDB(String name, int life, int attack, String attackEquipment, int attackEquipmentDamage, int characterPosition) throws Exception {
        Connection connection = loadDBConfigurationAndSetConnection();

        // request which is send to DB (with prepared method, "?" will replaced by variables)
        String updateString = "UPDATE Hero SET name = ?, life = ?, attack = ?, attackEquipment = ?, attackEquipmentDamage = ?, characterPosition = ? WHERE id = ?";

        // Each "?" is replaced by the correct value
        connection.setAutoCommit(false);
        try (PreparedStatement updateHero = connection.prepareStatement(updateString)) {
            updateHero.setString(1, name);
            updateHero.setInt(2, life);
            updateHero.setInt(3, attack);
            updateHero.setString(4, attackEquipment);
            updateHero.setInt(5, attackEquipmentDamage);
            updateHero.setInt(6, characterPosition);
            updateHero.setInt(7, this.characterId);

            // Execute the request
            updateHero.executeUpdate();
            connection.commit();
        }

        // After the update if character end the game it will be deleted
        if (characterPosition == 64) {
            deleteCharacterInDB(this.characterId);
        }
    }

    /**
     * Delete a character which is exist in DB
     *
     * @param id int
     * @throws Exception
     *      if a database access error occurs
     */
    public void deleteCharacterInDB(int id) throws Exception {
        Connection connection = loadDBConfigurationAndSetConnection();

        String updateString = "DELETE FROM Hero WHERE Hero.id = ?";

        // Delete the character with the correspondent id
        connection.setAutoCommit(false);
        try (PreparedStatement updateHero = connection.prepareStatement(updateString)) {
            updateHero.setInt(1, id);

            updateHero.executeUpdate();
            connection.commit();
        }

        System.out.println("Votre personnage n'a pas été supprimé car vous avez fini le jeu !");
    }
}
