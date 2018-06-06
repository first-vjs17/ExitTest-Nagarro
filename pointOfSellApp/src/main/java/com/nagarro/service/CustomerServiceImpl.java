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
	public List<Customer> getCustomerBySearchParameter(String searchInput) {
		return customerRepository.getCustomerBySearchParameter(searchInput);
	}
}
