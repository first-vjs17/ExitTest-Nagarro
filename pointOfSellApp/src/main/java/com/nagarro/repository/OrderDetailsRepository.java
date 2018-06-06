/**
 * 
 */
package com.nagarro.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;
import com.nagarro.model.CartProduct;
import com.nagarro.model.OrderDetails;
import com.nagarro.model.OrderProduct;

public interface OrderDetailsRepository {

	long save( OrderDetails orderDetails );
	
	List<OrderDetails> getAllOrderDetails();
	
	OrderDetails getOrderDetailById(long OrderDetailId);
	
	double getAmountBetweenDate(long employeeId, LocalDateTime startTime, LocalDateTime endTime);
	
	List<OrderDetails> getAllCompleteOrderDetails(long empId);
	
	List<OrderDetails> getAllOnHoldOrderDetails(long empId);
	
	void saveOrder(long cartId, long employeeId, long custId, double amount, PaymentStatus status, List<CartProduct> list, ModeOfPayments modeOfPay);
	
	List<OrderProduct> getOrderProductById(long orderId);
	
	List<OrderDetails> getOrderDetailsListInGivenTime( long employeeCashDrawerId );

}
