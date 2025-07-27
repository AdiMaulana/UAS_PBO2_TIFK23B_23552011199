package service;

import java.sql.SQLException;
import java.util.List;
import model.Customer;

public interface CustomerServiceInterface {

    List<Customer> getAllCustomer() throws SQLException;

    public void addCustomer(String name, String gender, int age) throws SQLException;

    public void updateCustomer(int id, String name, String gender, int age) throws SQLException;

    public void deleteCustomer(int id) throws SQLException;
}
