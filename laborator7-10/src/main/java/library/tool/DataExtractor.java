package library.tool;

import library.domain.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DataExtractor {

    public static User extractSingleUserFrom(ResultSet rs) throws SQLException {
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            return user;
        } else {
            return null;
        }
    }

    public static Set<User> extractUserSetFrom(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            users.add(user);
        }
        return users;
    }
}
