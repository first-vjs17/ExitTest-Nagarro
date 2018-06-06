/**
 * 
 */
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Customer;
import com.nagarro.service.CustomerService;
import com.nagarro.uri.CustomerRestURIConstants;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	/*------------------------------ GET METHODS ---------------------------------*/
	
	
	/*---get all customers---*/
	@GetMapping(value = CustomerRestURIConstants.GET_ALL_CUSTOMER )
	public ResponseEntity<List<Customer>> list() {
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok().body(customers);
	}
	
	/*---Get a customer by search inputs ---*/
	@GetMapping( value = CustomerRestURIConstants.GET_CUSTOMERS_BY_SEARCH )
	public ResponseEntity<List<Customer>> getCustomerBySearchParameter(@PathVariable("searchInput") String searchInput) {
		List<Customer> custList = customerService.getCustomerBySearchParameter(searchInput);
		return ResponseEntity.ok().body(custList);
	}
	
	
	/*------------------------------ POST METHODS --------------------------------*/
	
	
	/*--- add a customer ---*/
	@PostMapping( value = CustomerRestURIConstants.POST_CUSTOMER )
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		long id = customerService.save(customer);
	    return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
	}
	
	
}
