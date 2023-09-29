//package com.ust.customerapp.repository;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.stereotype.Repository;
//
//import com.ust.customerapp.exception.CustomerNotFoundException;
//import com.ust.customerapp.exception.DuplicateCustomerException;
//import com.ust.customerapp.model.Customer;
//@Repository
//public class CustomerRepoImpl implements CustomerRepo {
//	
//	List<Customer> cust =new ArrayList<>();
//	@PostConstruct
//	public void initSomeCustomer() {
//		Customer c1=new Customer (1001,"Karan","karu@gmail.com",LocalDate.of(1994,10,10));
//		Customer c2=new Customer (1002,"Rohit","rohi@gmail.com",LocalDate.of(1996,11,10));
//		Customer c3=new Customer (1003,"Arun","aru@gmail.com",LocalDate.of(1994,06,10));
//		cust.add(c1);
//		cust.add(c2);
//		cust.add(c3);
//	}
//
//	@Override
//	public Customer addCustomer(Customer customer) { 
//		Customer ex=getCustomer(customer.getId());
//		if(ex!=null) {
//			throw new  DuplicateCustomerException("Customer Already Exist");
//		}
//		else {
//			cust.add(customer);
//		}
//		
//		return customer;
//	}
//
//	@Override
//	public Customer getCustomer(int id) {
//		Customer cus=null;
//		for(Customer c:cust) {
//			if(c.getId()==id) {
//				cus= c;
//			}}
//			if(cus==null) {
//				throw new CustomerNotFoundException("customer not found");
//			
//		}
//		return cus;
//	}
//	
//	public Customer getCustomerbyName(String name) {
//		for(Customer c: cust) {
//			if(c.getName().equalsIgnoreCase(name)) {
//				return c;
//			}
//			
//		}
//		return null;
//	}
//
//	
//	
//
//	@Override
//	public Customer updateCustomer(Customer customer) {
//        int id=customer.getId();
//        Customer c=getCustomer(id);
//        cust.remove(c);
//        c.setName(customer.getName());
//        c.setEmail(customer.getEmail());
//        c.setDob(customer.getDob());
//        cust.add(c);
//        return c;        
//    }
//
//
//	@Override
//	public void deleteCustomer(int id) {
//		Customer a=getCustomer(id);
//		cust.remove(a);
//	}
//
//	@Override
//	public List<Customer> getAllCustomers() {
//		return cust;
//	}
//	
//
//}
