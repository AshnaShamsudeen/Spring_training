package com.ust.customerapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ust.customerapp.model.Customer;
 
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	
	
	//JPQL
    @Query(value="from Customer where name=:customerName")
    public Optional<Customer> findByName(@Param("customerName")String name);
    @Query(value="from  Customer where dob between :from and :to")
    public List<Customer>findByDobRange(LocalDate from,LocalDate to);

	
	//Native SQL
    @Query(value="select * from customer_data where id between :start and :end",nativeQuery=true)
    public List<Customer>findIdInRange(int start,int end);

	
//	public Customer addCustomer(Customer customer);
//	
//	public Customer getCustomer(int id);
//	
//	public Customer updateCustomer(Customer customer);
//	
//	public Customer getCustomerbyName(String name);
//	
//	
//	public void deleteCustomer(int id);
//	
//	public List<Customer> getAllCustomers();
	
	

}
