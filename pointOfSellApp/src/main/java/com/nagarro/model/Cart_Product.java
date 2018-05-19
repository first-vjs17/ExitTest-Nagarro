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
public class Cart_Product {
	
	@EmbeddedId
	private CartProductCompositeKey id;
	
	private int quantity;
	
	@MapsId("cartKey")
	@ManyToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	@MapsId("productKey")
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	/**
	 * @return the id
	 */
	public CartProductCompositeKey getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CartProductCompositeKey id) {
		this.id = id;
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
