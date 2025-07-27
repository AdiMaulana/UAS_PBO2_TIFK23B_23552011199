package dao;

import java.sql.SQLException;
import java.util.List;
import model.Customer;

public interface CustomerDaoInterface { 
    
    Customer getCustomerById(int id) throws SQLException;
    
    List<Customer> getAllCustomer();
    
    void insertCustomer(Customer customer) throws SQLException;
    
    void updateCustomer(Customer customer) throws SQLException;
    
    void deleteCustomer(int id) throws SQLException;
}
