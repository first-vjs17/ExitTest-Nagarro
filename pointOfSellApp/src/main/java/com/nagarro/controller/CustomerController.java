/**
 * 
 */
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Customer;
import com.nagarro.model.Employee;
import com.nagarro.service.CustomerService;

/**
 * @author vijaysharma01
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping( value = "/customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		long id = customerService.save(customer);
	    return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
	}
	
	/*---get all customers---*/
	@GetMapping(value="/customer")
	public ResponseEntity<List<Customer>> list() {
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok().body(customers);
	}
	
	/*---Get a customer by id---*/
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getByID(@PathVariable("id") long id) {
		Customer customer = customerService.getCustomerById(id);
		return ResponseEntity.ok().body(customer);
	}
	
	/*---Get a customer by name---*/
//	@GetMapping("/customer/{name}")
//	public ResponseEntity<Customer> getByName(@PathVariable("name") String name) {
//		Customer customer = customerService.getCustomerByName(name);
//		return ResponseEntity.ok().body(customer);
//	}
//	
//	/*---Get a customer by id---*/
//	@GetMapping("/customer/{mobileNo}")
//	public ResponseEntity<Customer> getByMobileNo(@PathVariable("mobileNo") String mobileNo) {
//		Customer customer = customerService.getCustomerByMobileNo(mobileNo);
//		return ResponseEntity.ok().body(customer);
//	}
}
