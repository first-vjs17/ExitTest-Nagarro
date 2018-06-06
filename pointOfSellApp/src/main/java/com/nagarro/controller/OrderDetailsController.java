/**
 * 
 */
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;
import com.nagarro.model.OrderDetails;
import com.nagarro.model.OrderProduct;
import com.nagarro.service.OrderDetailsService;
import com.nagarro.uri.OrderRestURIConstants;

@CrossOrigin
@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	
	/*------------------------------ GET METHODS ---------------------------------*/

	
	/*--- Get List by PaymentStatus i.g. ON_HOLD and PAID ---*/
	@GetMapping(value = OrderRestURIConstants.GET_ORDERS_BY_PAYMENT_STATUS )
	public ResponseEntity<List<OrderDetails>> getListByStatus(@PathVariable PaymentStatus status,
					@PathVariable long empId ) {

		List<OrderDetails> list;
		if (status == PaymentStatus.PAID)
			list = orderDetailsService.getAllCompleteOrderDetails(empId);
		else
			list = orderDetailsService.getAllOnHoldOrderDetails(empId);
		return ResponseEntity.ok().body(list);
		
	}

	/*--- ON_HOLD orders list ---*/
	@GetMapping(value = OrderRestURIConstants.GET_ON_HOLD_ORDERS )
	public ResponseEntity<List<OrderDetails>> getAllOnHoldOrders(@PathVariable long empId) {
		
		return ResponseEntity.ok().body(orderDetailsService.getAllOnHoldOrderDetails(empId));
		
	}

	/*--- COMPLETE orders list ---*/
	@GetMapping(value = OrderRestURIConstants.GET_COMPLETE_ORDERS )
	public ResponseEntity<List<OrderDetails>> getAllCompleteOrders(@PathVariable long empId) {
		
		return ResponseEntity.ok().body(orderDetailsService.getAllCompleteOrderDetails(empId));
		
	}

	/*--- Get Data from OrderProduct table by orderId ---*/
	@GetMapping(value = OrderRestURIConstants.GET_ORDER_BY_ID )
	public ResponseEntity<List<OrderProduct>> getOrederProductById(@PathVariable long orderId) {
		
		return ResponseEntity.ok().body(orderDetailsService.getOrderProductById(orderId));
		
	}
	
	/*---- Get OrderDetails in a particular duration of an employee ---*/
	@GetMapping( value = OrderRestURIConstants.GET_ORDERS_IN_A_DURATION )
	public ResponseEntity<List<OrderDetails> > getOrderDetailsListInGivenTime( @PathVariable long employeeCashDrawerId ){
		
		return ResponseEntity.ok().body(orderDetailsService.getOrderDetailsListInGivenTime(employeeCashDrawerId));
	}

	
	/*------------------------------ POST METHODS --------------------------------*/

	
	/*--- Add an Order ---*/
	@PostMapping(value = OrderRestURIConstants.POST_ORDER )
	public ResponseEntity<?> addProduct(@RequestBody OrderDetails orderDetails) {
		
		orderDetailsService.save(orderDetails);
		return ResponseEntity.ok().body(null);
		
	}

	/*--- Post Save and Complete orders ---*/
	@PostMapping(value = OrderRestURIConstants.POST_SAVE_AND_PLACED_ORDERS )
	public ResponseEntity<?> addOrder(@PathVariable long cartId,@PathVariable long employeeId,
			@PathVariable PaymentStatus status, @PathVariable ModeOfPayments modeOfPay) {
		
		orderDetailsService.saveOrder(cartId, employeeId, status, modeOfPay);
		return ResponseEntity.ok().body(null);
		
	}

}
