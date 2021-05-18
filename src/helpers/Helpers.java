package helpers;


import character.Character;
import character.Warrior;
import character.Wizard;
import menu.Navigation;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Helpers {

    // Attributes
    private Properties props;

    // Constructors
    public Helpers() {
        this.props = new Properties();
    }

    // Methods
    public void saveCharacter(String type, String name, int life, int attack, String attackEquipment, int attackEquipmentDamage) throws Exception {
        try (FileInputStream file = new FileInputStream("src/helpers/conf.properties"))
        {
            props.load(file);
        }

        Class.forName(props.getProperty("jdbc.driver.class"));
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        String url = props.getProperty("jdbc.url");

        // Case where character hasn't weapon
        if (attackEquipment.equals("")) {
            attackEquipment = "Aucun";
        }


        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            String requestSql = "INSERT INTO Hero (type, name, life, attack, attackEquipment, attackEquipmentDamage) " +
            "Values('"+type+"', '"+name+"', '"+life+"', '"+attack+"', '"+attackEquipment+"', '"+attackEquipmentDamage+"')";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(requestSql);
            }
        }
    }

    public Character restoreCharacter (Character player) throws Exception {
        try (FileInputStream file = new FileInputStream("src/helpers/conf.properties"))
        {
            props.load(file);
        }

        Class.forName(props.getProperty("jdbc.driver.class"));
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");
        String url = props.getProperty("jdbc.url");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {

            String requestSql = "SELECT type, name, life, attack, attackEquipment, attackEquipmentDamage FROM Hero";
            try (Statement statement = connection.createStatement()) {
                ResultSet rs =  statement.executeQuery(requestSql);
                int i = 1;
                rs.next();
                ArrayList<String> questions = new ArrayList<String>();
                questions.add("Veuillez sélectionné un personnage svp");
                while (!rs.isAfterLast()) {
                    System.out.println("");
                    System.out.println(i + " - Personnage sauvegardé");
                    System.out.println("Nom du personnage : " + rs.getNString("name"));
                    System.out.println("Vie : " + rs.getInt("life"));
                    System.out.println("Attaque : " + rs.getInt("attack"));
                    System.out.println("Arme équipé : " + rs.getString("attackEquipment"));
                    System.out.println("Points d'attaque de l'arme : " + rs.getInt("attackEquipmentDamage"));

                    questions.add(i + " - Pour choisir le premier joueur" + "("+rs.getString("name")+")");
                    rs.next();

                    i++;
                }

                Navigation nav = new Navigation();

                if (rs.absolute(nav.askQuestion(questions))) {
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
                }
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        return player;
    }



}
