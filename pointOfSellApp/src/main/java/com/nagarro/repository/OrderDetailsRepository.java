/**
 * 
 */
package com.nagarro.repository;

import java.time.LocalDateTime;
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
	double getAmountBetweenDate(long employeeId,
			LocalDateTime startTime, LocalDateTime endTime);
	List<OrderDetails> getAllCompleteOrderDetails();
	List<OrderDetails> getAllOnHoldOrderDetails();
}
