package com.customerapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.customerapp.model.Customer;

@Component
public class CustomerRepoImpl implements CustomerRepo {

	// static List<Customer> customerDb = new ArrayList<>();
	Map<Integer, Customer> customerDb = new HashMap<>();

	@Override
	public Customer addCustomer(Customer c) {
		customerDb.put(c.getId(), c);
		return c;
	}

	@Override
	public Customer getCustomerById(int id) {

		return customerDb.get(id);

	}

	@Override
	public Customer getCustomerByName(String name) {
		for (Customer c : customerDb.values()) {
			if (c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		}
		return null;

	}

	@Override
	public void deleteCustomerById(int id) {
//        int index = -1;
//        int customerIndex = -1;
//        for (Customer c : customerDb) {
//            index++;
//            if (c.getId() == id) {
//                customerIndex = index;
//                break;
//            }
//        }
//
//        if (customerIndex != -1) {
//            customerDb.remove(customerIndex);
//        }

		customerDb.remove(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return new ArrayList<>(customerDb.values());
	}

}
