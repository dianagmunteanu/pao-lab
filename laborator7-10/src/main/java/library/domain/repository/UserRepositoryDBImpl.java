package library.domain.repository;

import library.configuration.ConnectionFactory;
import library.domain.entity.User;
import library.tool.DataExtractor;

import java.sql.*;
import java.util.Set;

public class UserRepositoryDBImpl implements UserRepository {

    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String GET_ALL_USERS = "SELECT * FROM user";
    private static final String CREATE_NEW_USER = "INSERT INTO user (id, name, email, address) VALUES (?,?,?,?)";


    @Override
    public Set<User> getUsers() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_USERS);
            return DataExtractor.extractUserSetFrom(rs);
        } catch (SQLException ex) {
            //TODO
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserBy(int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_USER_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return DataExtractor.extractSingleUserFrom(rs);
        } catch (SQLException ex) {
            //TODO
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean insertUser(User user) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_USER);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //TODO
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int getNextId() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select user_id_seq.nextval as nexid from dual");
            resultSet.next();
            return resultSet.getInt("nexid");
        } catch (SQLException ex) {
            System.out.println("ERROR: Could not generate id.");
        }
        return -1;
    }

    @Override
    public boolean saveUpdatedUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public void updateUser(String text, String newAddress) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update user set address = ? where id = ?");
            statement.setInt(2,Integer.parseInt(text));
            statement.setString(1,newAddress);
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("ERROR: Could not generate id.");
        }
    }
}
