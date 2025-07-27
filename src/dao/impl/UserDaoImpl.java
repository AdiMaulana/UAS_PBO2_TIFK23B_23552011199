package dao.impl;

import util.DatabaseConnection;
import dao.UserDaoInterface;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDaoImpl implements UserDaoInterface {

    private DatabaseConnection dbConnector;

    public UserDaoImpl() throws IOException, ClassNotFoundException {
        this.dbConnector = new DatabaseConnection();
    }

    public UserDaoImpl(DatabaseConnection dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<User> getAllMembers() throws SQLException {
        List<User> members = new ArrayList<>();
        String sql = "SELECT u.id, u.username, u.name, u.email, r.name as role_name "
                + "FROM users u JOIN roles r on r.id = u.role_id;";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.connect();
            if (connection == null) {
                System.out.println("Failed to connect to the database.");
                return members; // Return empty list
            }

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String role = resultSet.getString("role_name");
                String namaMember = resultSet.getString("name");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                members.add(new User(id, role,  namaMember, email, username));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching clothes data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return members;
    }
}
