package com.clothing.merch;

import util.DatabaseConnection;
import form.LoginFrame;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

public class InsuranceApp {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Inisialisasi koneksi database
            DatabaseConnection dbConnector = new DatabaseConnection();
            connection = dbConnector.connect();

            if (connection == null) {
                System.out.println("Failed to connect to database.");
                System.exit(1);
            }
            
            // Jika koneksi berhasil, tampilkan login frame
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(null);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Error saat koneksi database : " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
