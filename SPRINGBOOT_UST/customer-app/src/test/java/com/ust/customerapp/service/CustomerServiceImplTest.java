package com.ust.customerapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.customerapp.exception.CustomerNotFoundException;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.model.UserType;

@SpringBootTest
//@TestInstance(Lifecycle.PER_CLASS)
class CustomerServiceImplTest  {
	@Autowired
	private CustomerService service;

//	@BeforeAll
//	public void setUp() {
//		Customer c1 = new Customer(101, "Vivek", "vivek@123.com", LocalDate.of(2000, 01, 15), UserType.GENERAL);
//		Customer c2 = new Customer(102, "Amal", "amal@123.com", LocalDate.of(2000, 07, 17), UserType.PREMIUM);
//		Customer c3 = new Customer(103, "Tony", "tony@123.com", LocalDate.of(2000, 03, 16), UserType.GENERAL);
//		service.addCustomer(c1);
//		service.addCustomer(c2);
//		service.addCustomer(c3);

//	}

//	@AfterEach
//	public void tearDown() {
//		service.deleteCustomer(101);
//		service.deleteCustomer(102);
//		service.deleteCustomer(103);
//	}

	@Test
	void testAddCustomer() {
		// GIVEN
		Customer c4 = new Customer(105, "shyma", "shyma@123.com",
				LocalDate.of(2000, 01, 15), UserType.GENERAL);

//When
		Customer savedCustomer = service.addCustomer(c4);
		// then
		assertEquals(c4, savedCustomer);
	}

	@Test
	void testGetCustomer() {
		// GIVEN
		int id = 102;
		int id2 = 109;

		// when
		Customer c1 = service.getCustomer(id);
		// then
		assertNotNull(c1);
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomer(id2));
	}

	@Test
	void testUpdateCustomer() {
		Customer c1 = new Customer(101, "Vivekkumar", "viveek@1234.com", 
				LocalDate.of(2000, 02, 15), UserType.GENERAL);
		Customer updatedCustomer = service.updateCustomer(c1);
		assertEquals(c1, updatedCustomer);
	}
	
	
	@Test
	void testGetCustomerbyName() {
		// GIVEN
				String name = "shyma";
				String name2 = "roopa";

				// when
				Customer c1 = service.getCustomerbyName(name);
				// then
				assertNotNull(c1);
				assertThrows(CustomerNotFoundException.class, () -> service.getCustomerbyName(name2));
		
	}

    @Test
    void testDeleteCustomer() {
    		// GIVEN
    			int id = 101;
    			// when
    			service.deleteCustomer(id);
    			// then
    			assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer(id));
    }

    @Test
    void testGetAllCustomers() {
    	 List<Customer> list=service.getAllCustomers();
    	 assertNotEquals(0, list.size());
    }
//
//    @Test
//    void testFindCustomerByDobRange() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    void testFindCustomerInIdRange() {
//        fail("Not yet implemented");
//    }

}
