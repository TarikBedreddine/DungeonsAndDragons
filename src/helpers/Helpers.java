package helpers;


import character.Character;
import character.Warrior;
import character.Wizard;
import menu.Navigation;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Helpers {

    // Attributes
    private Properties props;

    // Constructors
    public Helpers() {
        this.props = new Properties();
    }

    // Methods
    public void loadDataBaseConfiguration() throws Exception{
        try (FileInputStream file = new FileInputStream("src/helpers/conf.properties"))
        {
            props.load(file);
        }
    }


    public void saveCharacter(String type, String name, int life, int attack, String attackEquipment, int attackEquipmentDamage, int characterPosition) throws Exception {
        loadDataBaseConfiguration();

        Class.forName(props.getProperty("jdbc.driver.class"));
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        String url = props.getProperty("jdbc.url");

        // Case where character hasn't weapon
        if (attackEquipment.equals("")) {
            attackEquipment = "Aucun";
        }


        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            String requestSql = "INSERT INTO Hero (type, name, life, attack, attackEquipment, attackEquipmentDamage, characterPosition) " +
            "Values('"+type+"', '"+name+"', '"+life+"', '"+attack+"', '"+attackEquipment+"', '"+attackEquipmentDamage+"', '"+characterPosition+"')";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(requestSql);
            }
        }
    }

    public HashMap<String, Character> restoreCharacter (Character player, Navigation navInstance) throws Exception {
        HashMap<String, Character> isPlayerLoaded = new HashMap<String, Character>();
        loadDataBaseConfiguration();


        Class.forName(props.getProperty("jdbc.driver.class"));
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        String url = props.getProperty("jdbc.url");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            String requestSql = "SELECT type, name, life, attack, attackEquipment, attackEquipmentDamage, characterPosition FROM Hero";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs =  statement.executeQuery(requestSql);

                // i permit the index of the row looped
                int i = 1;
                rs.next();

                // add in the this list all the questions that i need to ask
                ArrayList<String> questions = new ArrayList<String>();
                questions.add("Veuillez sélectionner un personnage :)");
                while (!rs.isAfterLast()) {
                    questions.add(i + " - Nom: " +rs.getString("name")+ " || Vie: " +rs.getInt("life")+ " || Attaque: "+rs.getInt("attack")+" || Arme équipé: "+rs.getString("attackEquipment")+ " || Points d'attaques de l'arme: " +rs.getInt("attackEquipmentDamage")+ " Position du joueur : " +rs.getInt("characterPosition") );
                    rs.next();

                    i++;
                }

                if (rs.absolute(navInstance.askQuestion(questions))) {
                    if (rs.getString("type").equals("Warrior")) {
                        player = new Warrior();
                    } else if (rs.getString("type").equals("Wizard")) {
                        player = new Wizard();
                    }

                    player.setName(rs.getString("name"));
                    player.setLife(rs.getInt("life"));
                    player.setAttack(rs.getInt("attack"));
                    player.getAttackEquipment().setEquipmentName(rs.getString("attackEquipment"));
                    player.getAttackEquipment().setEquipmentDamage(rs.getInt("attackEquipmentDamage"));
                    player.setCharacterPosition(rs.getInt("characterPosition"));
                }
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        isPlayerLoaded.put("player1", player);
        return isPlayerLoaded;
    }

    public void updatePlayerInDB (String name, int life, int attack, String attackEquipment, int attackEquipmentDamage, String shield, int characterPosition) throws Exception {
        loadDataBaseConfiguration();

        Class.forName(props.getProperty("jdbc.driver.class"));
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        String url = props.getProperty("jdbc.url");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            String requestSql = "UPDATE Hero SET \"name\" = '"+name+"', \"life\" = '"+life+'", \"attack\" =  ";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(requestSql);
            }
        }

    }

}
