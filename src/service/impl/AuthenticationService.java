package service.impl; 

import constant.SessionManager;
import util.DatabaseConnection;  
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.Authentication;

public class AuthenticationService extends Authentication{
    @Override
    public boolean authenticateUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isAuthenticated = false;
        try {
            // 1. Get database connection
            DatabaseConnection dbConnector = new DatabaseConnection();
            connection = dbConnector.connect();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return false;  
            }
            // 2. Construct the SQL query to retrieve the salt and hashed password
            String sql = "SELECT id, role_id, name, username, password, salt FROM users WHERE username = ?"; // Get password and salt
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // User found, retrieve stored hash and salt
                int userId = resultSet.getInt("id");
                int roleId = resultSet.getInt("role_id");
                String usernameDb = resultSet.getString("username");
                String customerName = resultSet.getString("name");
                String storedHash = resultSet.getString("password");
                String salt = resultSet.getString("salt");
                // Hash the entered password with the retrieved salt
                String hashedPassword = hashPassword(password, salt);
                // Compare the entered password's hash with the stored hash
                if (storedHash.equals(hashedPassword)) {
                    isAuthenticated = true;
                    
                    SessionManager.setUserId(userId);
                    SessionManager.setRoleId(roleId);
                    SessionManager.setUserName(usernameDb);
                    SessionManager.setName(customerName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during authentication: " + e.getMessage());
            e.printStackTrace();
            
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isAuthenticated;
    }
}
