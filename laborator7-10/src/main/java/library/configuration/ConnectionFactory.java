package library.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USER = "sa";
    public static final String PASS = "";
    public static final String DRIVER_NAME = "org.h2.Driver";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

}