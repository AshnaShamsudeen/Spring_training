package com.customerapp.service;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.customerapp.model.Customer;
import com.customerapp.repository.CustomerRepo;
@Component
public class CustomerServiceImpl implements CustomerService{
 
//    CustomerRepo repo = new CustomerRepoImpl();

    @Autowired
    CustomerRepo repo ;

    @Override
    public Customer addCustomer(Customer c) {
        // logic to validate customer data
        Customer customer = repo.addCustomer(c);
        return c;
    }
 
    @Override
    public Customer getCustomerById(int id) {
        Customer c = repo.getCustomerById(id);
        return c;
    }
 
    @Override
    public Customer getCustomerByName(String name) {
        Customer c = repo.getCustomerByName(name);
        return c;
    }
 
    @Override
    public void deleteCustomerById(int id) {
        repo.deleteCustomerById(id);

    }
 
    @Override
    public List<Customer> getAllCustomer() {
        // TODO Auto-generated method stub
        return repo.getAllCustomer();
    }
 
    @Override
    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub
        return repo.getAllCustomer();
    }
 

}
