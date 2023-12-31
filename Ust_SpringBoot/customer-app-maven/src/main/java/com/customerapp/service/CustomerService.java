package com.customerapp.service;

import java.util.List;
 
import com.customerapp.model.Customer;
 
public interface CustomerService {
    public Customer addCustomer(Customer c);
    public Customer getCustomerById(int id);
    public Customer getCustomerByName(String name);
    public void deleteCustomerById(int id);
    public List<Customer> getAllCustomer();
    List<Customer> getAllCustomers();
}

