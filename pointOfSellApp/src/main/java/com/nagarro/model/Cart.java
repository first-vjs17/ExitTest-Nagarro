/**
 * 
 */
package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author vijaysharma01
 *
 */

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private long cartId;
	
	@OneToMany(mappedBy="cart")
	private Set<Cart_Product> cartProduct = new HashSet<>();
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name="cust_id", nullable = false )
	private Customer customer;

	/**
	 * @return the cartId
	 */
	public long getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartProduct
	 */
	public Set<Cart_Product> getCartProduct() {
		return cartProduct;
	}

	/**
	 * @param cartProduct the cartProduct to set
	 */
	public void setCartProduct(Set<Cart_Product> cartProduct) {
		this.cartProduct = cartProduct;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}