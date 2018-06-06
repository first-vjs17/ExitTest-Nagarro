/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Customer;

public interface CustomerService {

	long save(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(long customerId);
	
	List<Customer> getCustomerBySearchParameter(String searchInput);

}
