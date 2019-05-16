package library;

import library.configuration.ConnectionFactory;
import library.services.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {
        UserService userService = new UserService();
        initDatabase(userService);
        userService.printAllUsers();
    }


    private static void initDatabase(UserService userService) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("drop table if exists user");
            stmt.execute(
                    "create table " +
                            "user (" +
                            "id number(4)," +
                            "name varchar2(200)," +
                            "email  varchar2(200)," +
                            "address varchar2(200)" +
                            ")");
            stmt.execute("drop sequence if exists user_id_seq");
            stmt.execute("create sequence user_id_seq");
            for (int counter = 0; counter < 5; counter++) {
                userService.createNewUser("test" + counter, "test-address", "test" + counter + "@test.com");
            }

        } catch (SQLException ex) {
            System.out.println("Could not finish database setup!");
            ex.printStackTrace();
        }
    }
}
