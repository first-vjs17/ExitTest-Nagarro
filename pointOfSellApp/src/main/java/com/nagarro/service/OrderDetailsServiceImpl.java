/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;
import com.nagarro.model.CartProduct;
import com.nagarro.model.OrderDetails;
import com.nagarro.model.OrderProduct;
import com.nagarro.repository.CartRepository;
import com.nagarro.repository.OrderDetailsRepository;

@Transactional
@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private CartRepository cartRepository;

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

	@Override
	public List<OrderDetails> getAllCompleteOrderDetails(long empId) {
		return orderDetailsRepository.getAllCompleteOrderDetails(empId);
	}

	@Override
	public List<OrderDetails> getAllOnHoldOrderDetails(long empId) {
		return orderDetailsRepository.getAllOnHoldOrderDetails(empId);
	}

	@Override
	public void saveOrder( long cartId, long employeeId, PaymentStatus status, ModeOfPayments modeOfPay ) {

		List<CartProduct> list = cartRepository.getAllCartProducts(cartId);
		long custId = list.get(0).getCp().getCart().getCustomer().getCustomerId();
		Double amount = 0.0;
		for (CartProduct cp : list) {
			amount += cp.getQuantity() * cp.getCp().getProduct().getUnitPrice();
		}
		orderDetailsRepository.saveOrder(cartId, employeeId, custId, amount, status, list, modeOfPay);
		
	}

	@Override
	public List<OrderProduct> getOrderProductById(long orderId) {
		return orderDetailsRepository.getOrderProductById(orderId);
	}

	@Override
	public List<OrderDetails> getOrderDetailsListInGivenTime( long employeeCashDrawerId) {
		return orderDetailsRepository.getOrderDetailsListInGivenTime(employeeCashDrawerId);
	}
	
	
}
