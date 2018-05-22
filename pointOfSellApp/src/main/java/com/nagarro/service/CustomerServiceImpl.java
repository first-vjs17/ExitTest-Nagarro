/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Cart;
import com.nagarro.model.Customer;
import com.nagarro.repository.CustomerRepository;

/**
 * @author vijaysharma01
 *
 */

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartService cartService;

	@Override
	public long save(Customer customer) {
		long customerId = customerRepository.save(customer);
		Cart cart = new Cart();
		cart.setCustomer(customer);
		cartService.save(cart);
		return customerId;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(long customerId) {
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Customer getCustomerByName(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByMobileNo(String customerMobileNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
