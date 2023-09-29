package com.ust.customerapp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Matches;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.model.UserType;
import com.ust.customerapp.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value=CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CustomerService service;
	
	//@InjectMocks

	@Test
	void testGetCustomer() throws Exception {
	//given
		Customer c1 = new Customer(103, "shyma", "shyma@123.com",
				LocalDate.of(2000, 01, 15), UserType.GENERAL);
		int id=c1.getId();
		//when
		when(service.getCustomer(id)).thenReturn(c1);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/"+id))
		.andExpect(status().isOk())
		//.contentType(MediaType.APPLICATION_JSON)
		.andExpect(jsonPath("$.id",Matchers.is(103)))
		.andExpect(jsonPath("$.name",Matchers.is("shyma")))
		.andExpect(jsonPath("$.email",Matchers.is("shyma@123.com")))
		.andExpect(jsonPath("$.dob",Matchers.is("2000-01-15")))
		.andExpect(jsonPath("$.type",Matchers.is("GENERAL")))
		;
	}

//	@Test
//	void testGetAllCustomers() {
//
//	}

	@Test
	void testAddCustomer()  throws Exception {
	//given
		Customer c1 = new Customer(103, "shyma", "shyma@123.com",
				LocalDate.of(2000, 01, 15), UserType.GENERAL);
		int id=c1.getId();
		//when
		when(service.addCustomer(c1)).thenReturn(c1);
		// Then
				
		mockMvc.perform(post("/api/customers")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(c1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.id",Matchers.is(103)))
		.andExpect(jsonPath("$.name",Matchers.is("shyma")))
		.andExpect(jsonPath("$.email",Matchers.is("shyma@123.com")))
		.andExpect(jsonPath("$.dob",Matchers.is("2000-01-15")))
		.andExpect(jsonPath("$.type",Matchers.is("GENERAL")))
		;
	}
//	@Test
//	void testUpdateCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerbyName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchCustomerByDob() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchCustomerByIdInRange() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteCustomer() {
//		fail("Not yet implemented");
//	}
//
	
	// Helper Method for converting a Java Object to JSON String
		private String asJsonString(Object object) throws Exception {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.registerModule(new JavaTimeModule());
	        return objectMapper.writeValueAsString(object);
	    }

}
