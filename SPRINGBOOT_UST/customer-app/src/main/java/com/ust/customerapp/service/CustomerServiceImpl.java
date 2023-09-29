package com.ust.customerapp.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.customerapp.exception.CustomerNotFoundException;
import com.ust.customerapp.exception.DuplicateCustomerException;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.repository.CustomerRepo;
//import com.ust.customerapp.repository.CustomerRepoImpl;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	
	private CustomerRepo rp;
	public Customer addCustomer(Customer customer) {
		//return rp.save(customer);//addCustomer(customer);
		int id=customer.getId();
		if(rp.existsById(id)) {
			throw new DuplicateCustomerException ("customer with id: "+id +" is already there"); }
		return rp.save(customer);
		}
	

	public Customer getCustomer(int id) {
		//return rp.findById(id).get();//getCustomer(id);
		return rp.findById(id).orElseThrow(()->new CustomerNotFoundException("customer with id:"+id+"not present"));
	}
////	if(!rp.existsById(id)) {
////		throw new CustomerNotFoundException ("customer with id: "+id +" not present"); }
////	return rp.findById(id).get();
////	}
////	
//	
	public Customer getCustomerbyName(String name) {
		return rp.findByName(name).orElseThrow(()->new CustomerNotFoundException("customer with name: "+name+" not present"));//getCustomerbyName(name);
		//return rp.findByName(name).get();
	}
	


	public Customer updateCustomer(Customer customer) {
		
		//return rp.save(customer);//updateCustomer(customer);
		if(!rp.existsById(customer.getId())) {
			throw new CustomerNotFoundException ("customer with id: "+customer.getId() +" not present"); }
			
		return rp.save(customer);
		}
		
	

	public void deleteCustomer(int id) {
		//rp.deleteById(id);//deleteCustomer(id);
		if(!rp.existsById(id)) {
			throw new CustomerNotFoundException ("customer with id: "+id +" not present"); }
		rp.deleteById(id);
		}
		
	
	
	public List<Customer> getAllCustomers() {
		return rp.findAll();//getAllCustomers();
	}
	
	public List<Customer>findCustomerByDobRange(LocalDate from,LocalDate to){
        return rp.findByDobRange(from, to);
    }


    public List<Customer> getCustomerInIdRange(int start,int end) {
        return rp.findIdInRange(start, end);
    }

	

}
