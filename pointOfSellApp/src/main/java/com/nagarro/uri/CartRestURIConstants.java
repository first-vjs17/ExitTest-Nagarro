/**
 * 
 */
package com.nagarro.uri;

/**
 * @author vijaysharma01
 *
 */
public class CartRestURIConstants {
	
	public static final String GET_CART = "/cart/{custId}";
	
	public static final String GET_CART_PRODUCT = "/cartProduct/{cartId}";
	
	public static final String POST_PRODUCT_IN_CART_PRODUCT = "/cartProduct/{cartId}/{productId}/{quantity}";
	
	public static final String POST_RELOAD_CART = "/cartProduct/{orderId}";
	
	public static final String POST_CART = "/cart";
	
	public static final String UPDATE_PRODUCT_IN_CART = "/cartProduct/{cartId}/{productId}/{quantity}";
	
	public static final String DELETE_CART_FROM_CART_PRODUCT = "/cartProduct/{cartId}";
	
	public static final String DELETE_ONE_PRODUCT_FROM_CART ="/cartProduct/{cartId}/{productId}";
}
