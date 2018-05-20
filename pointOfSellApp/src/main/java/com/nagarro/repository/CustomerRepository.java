/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Customer;

/**
 * @author vijaysharma01
 *
 */
public interface CustomerRepository {
	
	long save( Customer customer );
	List<Customer> getAllCustomers();
	Customer getCustomerById(long customerId);
	Customer getCustomerByName(String customerName);
	Customer getCustomerByMobileNo(String customerMobileNo);
}
