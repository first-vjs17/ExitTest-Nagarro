/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.OrderDetails;

/**
 * @author vijaysharma01
 *
 */
public interface OrderDetailsService {

	long save( OrderDetails orderDetails );
	List<OrderDetails> getAllOrderDetails();
	OrderDetails getOrderDetailById(long OrderDetailId);
	List<OrderDetails> getAllCompleteOrderDetails();
	List<OrderDetails> getAllOnHoldOrderDetails();
	
}
