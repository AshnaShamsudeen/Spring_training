
package com.ust.customerapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.customerapp.model.Customer;
import com.ust.customerapp.service.CustomerService;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping//("/{customers}")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping//("/customers")
	public List<Customer>getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id){
		return service.getCustomer(id);
	}
	
	@PutMapping
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	 public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@GetMapping("/name/{name}")
	@ResponseStatus(code=HttpStatus.OK)
	public Customer getCustomerbyName(@PathVariable String name){
		return service.getCustomerbyName(name);
	}
	
	
	@GetMapping("/dob/from/{from}/to/{to}")
	public List<Customer> searchCustomerByDob(@PathVariable
			@DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate from,
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd")
			LocalDate to){
		return service.findCustomerByDobRange(from,to);
	}
	
	
	@GetMapping("/id/start/{start}/end/{end}")
    public List<Customer> searchCustomerByIdInRange(@PathVariable int start, @PathVariable int end){
        return service.getCustomerInIdRange(start, end);
    }
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	 public void deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
		
	}
	

}
