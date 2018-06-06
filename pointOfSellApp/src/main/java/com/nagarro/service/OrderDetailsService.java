/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;
import com.nagarro.model.OrderDetails;
import com.nagarro.model.OrderProduct;

public interface OrderDetailsService {

	long save( OrderDetails orderDetails );
	
	List<OrderDetails> getAllOrderDetails();
	
	OrderDetails getOrderDetailById(long OrderDetailId);
	
	List<OrderDetails> getAllCompleteOrderDetails(long empId);
	
	List<OrderDetails> getAllOnHoldOrderDetails(long empId);
	
	List<OrderProduct> getOrderProductById(long orderId);
	
	void saveOrder(long cartId, long employeeId, PaymentStatus status, ModeOfPayments modeOfPay);
	
	List<OrderDetails> getOrderDetailsListInGivenTime( long employeeCashDrawerId );
	
}
