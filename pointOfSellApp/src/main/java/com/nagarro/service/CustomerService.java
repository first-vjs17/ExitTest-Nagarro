/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Customer;

/**
 * @author vijaysharma01
 *
 */
public interface CustomerService {

	long save(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(long customerId);
	Customer getCustomerByName(String customerName);
	Customer getCustomerByMobileNo(String customerMobileNo);
}
