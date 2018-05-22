/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.OrderDetails;
import com.nagarro.repository.OrderDetailsRepository;

/**
 * @author vijaysharma01
 *
 */
@Transactional
@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public long save(OrderDetails orderDetails) {
		return orderDetailsRepository.save(orderDetails);
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsRepository.getAllOrderDetails();
	}

	@Override
	public OrderDetails getOrderDetailById(long OrderDetailId) {
		return orderDetailsRepository.getOrderDetailById(OrderDetailId);
	}
	
	
}
