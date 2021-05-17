package helpers;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
    public void saveCharacter(String type, String name, int life, int attack, String attackEquipment) throws Exception {
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
            String requestSql = "INSERT INTO Hero (type, name, life, attack, attackEquipment) " +
            "Values('"+type+"', '"+name+"', '"+life+"', '"+attack+"', '"+attackEquipment+"')";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(requestSql);
            }
        }
    }

}
