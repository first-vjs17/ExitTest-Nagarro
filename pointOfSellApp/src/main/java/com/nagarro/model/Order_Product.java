/**
 * 
 */
package com.nagarro.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author vijaysharma01
 *
 */
@Entity
public class Order_Product {

	@EmbeddedId
	private OrderProductCompositeKey id;

	private int quantity;

	@MapsId("orderKey")
	@ManyToOne(cascade = CascadeType.ALL)
	private OrderDetails orderDetails;

	@MapsId("productKey")
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	/**
	 * @return the orderDetails
	 */
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
