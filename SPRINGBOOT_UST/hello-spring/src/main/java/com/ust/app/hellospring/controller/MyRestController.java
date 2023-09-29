package com.ust.app.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.app.hellospring.model.Customer;

@RestController//returns a resource/rest API
public class MyRestController {

	@GetMapping//
	public String sayHello(){
		return "Hello World";		}
	
	@GetMapping("/hello/{username}")
	public String greet(@PathVariable String username) {
		return "Good afternoon "+username;
}
	@GetMapping("/customer")
	public Customer getCustomer() {
		Customer c=new Customer(1001,"Ashna","ashna@gmail.com");
		return c;
	}
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return customer;
	}
	
	@GetMapping("/customer/{id}/{name}/{email}")
	public Customer getCustomerDetails() {{
		Customer c=new Customer(1001,"Ashna","ashna@gmail.com");
		return c;
	}
	
		
	}
}
