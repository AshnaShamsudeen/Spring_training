package com.customerapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import com.customerapp.model.Customer;
 
public class CustomerRepoJdbcImpl implements CustomerRepo {
 
    Connection connection;
    String url;
    String username;
    String password;
 
    @Override
    public Customer addCustomer(Customer c) {
        url = "";
        username = "";
        password = "";
        try {
            connection = DriverManager.getConnection(url, username, password);
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    @Override
    public Customer getCustomerById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public Customer getCustomerByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public void deleteCustomerById(int id) {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public List<Customer> getAllCustomer() {
        // TODO Auto-generated method stub
        return null;
    }
 
}


