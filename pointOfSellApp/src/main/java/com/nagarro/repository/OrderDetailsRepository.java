/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.OrderDetails;

/**
 * @author vijaysharma01
 *
 */
public interface OrderDetailsRepository {

	long save( OrderDetails orderDetails );
	List<OrderDetails> getAllOrderDetails();
	OrderDetails getOrderDetailById(long OrderDetailId);
}
