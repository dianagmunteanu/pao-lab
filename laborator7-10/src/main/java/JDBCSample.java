import java.sql.*;

public class JDBCSample {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            System.out.println("Connection was created");

            Statement statement = conn.createStatement();
            statement.execute("drop table test if exists");
            statement.execute("create table test (id number(2), name varchar2(200))");

            statement.execute("drop table test2 if exists");
            statement.execute("create table test2 (id number(2), name varchar2(200))");
            statement.execute("insert into test2 values(2, 'test1')");


            statement.execute("insert into test values(1, 'test1')");
            statement.execute("update test set name = 'test2' where id =1");
            statement.execute("insert into test values(2, 'test1')");
            statement.execute("delete from test where id = 1");

            insertIntoTest(conn, 5, "test5");

            ResultSet resultSet = statement.executeQuery("select * from test");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }

            ResultSet resultSet2 = statement.executeQuery(
                    "select " +
                            "t1.id as id_t1, " +
                            "t1.name as name_t1, " +
                            "t2.name as name_t2 " +
                            "from test t1 " +
                            "left join test2 t2 on t1.id = t2.id");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt("id_t1") + " " +
                        resultSet2.getString("name_t1") + " " + resultSet2.getString(3));
            }


            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertIntoTest(Connection conn, int id, String name) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("insert into test values(?,?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
