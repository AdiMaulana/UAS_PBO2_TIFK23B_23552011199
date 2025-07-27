package service.impl;

import util.DatabaseConnection;
import dao.UserDaoInterface;
import dao.impl.UserDaoImpl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.util.Arrays;
import java.security.SecureRandom;
import java.util.List;
import model.User;
import service.UserServiceInterface;

public class UserServiceImpl implements UserServiceInterface{

    private UserDaoInterface userDaoInterface;

    public UserServiceImpl() throws IOException, ClassNotFoundException {
         this.userDaoInterface = new UserDaoImpl();
    }
    
    @Override
    public List<User> getAllMembers() throws SQLException {
        return userDaoInterface.getAllMembers();
    }
    
    public boolean createUser(String name, String email, String username, String password) throws IOException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCreated = false;

        try {
            // 1. Hash the password
            String salt = getSalt();
            String hashedPassword = hashPassword(password, salt);

            // 2. Establish database connection
            DatabaseConnection dbConnector = new DatabaseConnection();
            connection = dbConnector.connect();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return false;  
            }

            // 3. Construct the SQL query
            String sql = "INSERT INTO users (role_id, name, email, username, password, salt) VALUES (?, ?, ?, ?, ?, ?)"; 
            preparedStatement = connection.prepareStatement(sql);

            // 4. Set the parameters
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, hashedPassword); // Store the hashed password
            preparedStatement.setString(6, salt); //Store the salt value

            // 5. Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                isCreated = true;
            }

        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println("Error creating user: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isCreated;
    }

    //MD5 hashing
    public static String hashPassword(String password, String salt) {
        try {
            // Using MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add salt to password
            String saltedPassword = salt + password;

            // Get the hash's bytes
            byte[] bytes = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));

            // Convert byte array into signum representation
            BigInteger number = new BigInteger(1, bytes);

            // Convert message digest into hex value
            StringBuilder hexString = new StringBuilder(number.toString(16));

            // Pad with leading zeros
            while (hexString.length() < 32)
            {
                hexString.insert(0, '0');
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return null;
        }
    }

    //Get the salt
    public static String getSalt() throws NoSuchAlgorithmException {
        //Using SHA1PRNG secure random generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

        //Create array for salt
        byte[] salt = new byte[16];

        //Get a different salt for every user
        sr.nextBytes(salt);

        //return salt
        return Arrays.toString(salt);
    }
}