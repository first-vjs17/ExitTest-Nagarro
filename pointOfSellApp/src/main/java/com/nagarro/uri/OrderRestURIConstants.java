/**
 * 
 */
package com.nagarro.uri;

/**
 * @author vijaysharma01
 *
 */
public class OrderRestURIConstants {

	public static final String GET_ORDERS_BY_PAYMENT_STATUS = "/orderDetails/payment_status/{status}/employee_id/{empId}";
	
	public static final String GET_ON_HOLD_ORDERS = "order/on_hold/employeeId/{empId}";
	
	public static final String GET_COMPLETE_ORDERS = "order/complete/employeeId/{empId}";
	
	public static final String GET_ORDER_BY_ID = "orderDetails/orderId/{orderId}";
	
	public static final String GET_ORDERS_IN_A_DURATION = "/orderDetails/employeeCashDrawer/{employeeCashDrawerId}";
	
	public static final String POST_ORDER = "/orderDetails";
	
	public static final String POST_SAVE_AND_PLACED_ORDERS = "/orderDetails/{cartId}/employee/{employeeId}/status/{status}/modeOfPay/{modeOfPay}";

}
