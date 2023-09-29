package com.ust.customerapp.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.ust.customerapp.exception.CustomerNotFoundException;
import com.ust.customerapp.exception.DuplicateCustomerException;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.model.UserType;
import com.ust.customerapp.repository.CustomerRepo;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceUnitImpl {
	
	@InjectMocks
	private CustomerServiceImpl service;
	
	@Mock
	private CustomerRepo rp;

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
		Customer c4 = new Customer(103, "shyma", "shyma@123.com",
				LocalDate.of(2000, 01, 15), UserType.GENERAL);
		
		Customer c2 = new Customer(106, "vivek", "vivi@123.com",
				LocalDate.of(2000, 01, 29), UserType.GENERAL);

//When
		when(rp.save(c4)).thenReturn(c4);
		when(rp.save(c2)).thenThrow(DuplicateCustomerException.class);
		Customer savedCustomer = service.addCustomer(c4);
		// then
		assertEquals(c4, savedCustomer);
		assertThrows(DuplicateCustomerException.class,()->service.addCustomer(c2));
		//Verify whether repo.save() method is called one time.
		verify(rp,times(1)).save(c4);
		verify(rp,times(1)).save(c2);
	}

	@Test
	void testGetCustomer() {
		// GIVEN
		int id = 106;
		int id2 = 109;
		Customer c4 = new Customer(106, "shyma", "shyma@123.com",
				LocalDate.of(2000, 01, 15), UserType.GENERAL);

		// when
		when(rp.findById(id)).thenReturn(Optional.of(c4));
		when(rp.findById(id2)).thenThrow(CustomerNotFoundException.class);
		
		
		
		//Customer c1 = service.getCustomer(id);
		// then
		//assertNotNull(c1);
		assertEquals(c4,service.getCustomer(id));
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomer(id2));
		
		//Verify
		verify(rp,times(1)).findById(id);
		verify(rp,times(1)).findById(id2);
	}
//
//	@Test
//	void testUpdateCustomer() {
//		Customer c1 = new Customer(101, "Vivekkumar", "viveek@1234.com", 
//				LocalDate.of(2000, 02, 15), UserType.GENERAL);
//		Customer updatedCustomer = service.updateCustomer(c1);
//		assertEquals(c1, updatedCustomer);
//	}
//
    @Test
    void testDeleteCustomer() {
    	// GIVEN
    			int id1 = 103;
    			int id2 = 100;
    			// when
    			when(rp.existsById(id1)).thenReturn(true);
    			when(rp.existsById(id2)).thenReturn(false);
    			// then
    			assertDoesNotThrow(()->service.deleteCustomer(id1));
    			assertThrows(CustomerNotFoundException.class, () -> service.deleteCustomer(id2));
    			//Verify
    			verify(rp,times(1)).deleteById(id1);
    			verify(rp,times(1)).existsById(id2);
    	
    	}

    @Test
    void testGetAllCustomers() {
    	//Given
       List<Customer> list=new ArrayList<>();
       Customer c1 = new Customer(101, "Vivekkumar", "viveek@1234.com", 
			LocalDate.of(2000, 02, 15), UserType.GENERAL);
       Customer c2 = new Customer(102, "Shyma", "shy@1234.com", 
    					LocalDate.of(2000, 02, 15), UserType.GENERAL);
       Customer c3 = new Customer(103, "Abhi", "abhi@1234.com", 
   							LocalDate.of(2000, 02, 15), UserType.GENERAL);
       list.add(c1);
       list.add(c2);
       list.add(c3);
       
       //when
       
       
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
