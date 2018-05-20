/**
 * 
 */
package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.service.CustomerService;

/**
 * @author vijaysharma01
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping( value = "/customer", method = RequestMethod.POST )
	public void addCustomer() {
		
	}
}
