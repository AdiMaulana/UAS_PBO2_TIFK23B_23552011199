package service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Authentication {
    // abstract method
    public abstract boolean authenticateUser(String username, String password);
    
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
}
