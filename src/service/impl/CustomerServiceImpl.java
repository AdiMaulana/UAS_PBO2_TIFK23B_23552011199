package service.impl;

import dao.impl.CustomerDaoImpl;
import java.util.List;
import model.Customer;
import java.sql.SQLException;
import service.CustomerServiceInterface;
import dao.CustomerDaoInterface;

public class CustomerServiceImpl implements CustomerServiceInterface {

    private CustomerDaoInterface customerDao;

    public CustomerServiceImpl() {
        this.customerDao = new CustomerDaoImpl();
    }
    
    @Override
    public List<Customer> getAllCustomer() throws SQLException {
        return customerDao.getAllCustomer();
    }

    @Override
    public void addCustomer(String name, String gender, int age) throws SQLException {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setGender(gender);
        customer.setAge(age);
        customerDao.insertCustomer(customer);
    }

    @Override
    public void updateCustomer(int id, String name, String gender, int age) throws SQLException {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setGender(gender);
        customer.setAge(age);
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        customerDao.deleteCustomer(id);
    }
}
