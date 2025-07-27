package dao.impl;

import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.PreparedStatement;
import dao.CustomerDaoInterface;
import model.Customer;

public class CustomerDaoImpl implements CustomerDaoInterface {

     private DatabaseConnection dbConnector;

    public CustomerDaoImpl() {
        try {
            this.dbConnector = new DatabaseConnection();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnection", e);
        }
    }

    public CustomerDaoImpl(DatabaseConnection dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        String sql = "SELECT id, name, gender, age FROM nasabah WHERE id = ?";
        Customer customer = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = dbConnector.connect();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setGender(rs.getString("gender"));
                customer.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving customer by ID: " + e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerDataList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.connect();
            if (connection == null) {
                System.out.println("Failed to connect to the database.");
                return customerDataList; // Return empty list
            }

            String sql = "SELECT id, nama, gender, umur FROM nasabah ORDER BY id;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nama");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("umur");
                Customer customer = new Customer(id, name, gender, age);
                customerDataList.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching customer data: " + e.getMessage());
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
        return customerDataList;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO nasabah (nama, gender, umur) VALUES (?, ?, ?)";

        Connection connection = dbConnector.connect();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getGender());
            pstmt.setInt(3, customer.getAge());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void updateCustomer(Customer clothing) throws SQLException {
        String sql = "UPDATE nasabah SET nama = ?, gender = ?, umur = ? WHERE id = ?";

        Connection connection = dbConnector.connect();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, clothing.getName());
            pstmt.setString(2, clothing.getGender());
            pstmt.setInt(3, clothing.getAge());
            pstmt.setInt(4, clothing.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM nasabah WHERE id = ?";

        Connection connection = dbConnector.connect();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
