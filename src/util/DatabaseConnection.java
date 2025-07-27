package util;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/kasir_asuransi"; ;
    private static String user = "root";
    private static String password;

    public DatabaseConnection() throws IOException, ClassNotFoundException {
        // Load properties file
        Properties props = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("resources/db.properties")) {
            if (input == null) {
                throw new IOException("Sorry, unable to find db.properties");
            }
            props.load(input);
        }

        // Get properties
        this.url = props.getProperty("db.url");
        this.user = props.getProperty("db.username");
        this.password = props.getProperty("db.password");

        // Load JDBC Driver manually (ubah sesuai driver DB Anda)
        // Jika MySQL:
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Jika PostgreSQL, ganti dengan:
        // Class.forName("org.postgresql.Driver");

        System.out.println("DatabaseConnection initialized with URL: " + this.url);
    }

    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully.");
        }
        return connection;
    }
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver tidak ditemukan", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    // Optional: method close connection jika ingin menutup connection
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }

    // Getter
    public String getUrl() {
        return url;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
}
