/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Customer;

public interface CustomerRepository {
	
	long save( Customer customer );
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(long customerId);
	
	List<Customer> getCustomerBySearchParameter(String searchInput);

}
