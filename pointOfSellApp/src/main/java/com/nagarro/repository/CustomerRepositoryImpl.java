/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Cart;
import com.nagarro.model.Customer;
import com.nagarro.model.Employee;
import com.nagarro.service.CartService;
import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private CartService cartService;

	@Override
	public long save(Customer customer) {
		long customerId = (long) hibernateUtil.create(customer);
		return customerId;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return hibernateUtil.fetchAll(Customer.class);
	}

	@Override
	public Customer getCustomerById(long customerId) {
		return hibernateUtil.fetchById(customerId, Customer.class);
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
