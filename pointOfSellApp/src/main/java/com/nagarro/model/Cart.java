/**
 * 
 */
package com.nagarro.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "cartId")
	private long cartId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Customer customer;

	public Cart() {

	}

	public Cart(long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartId
	 */
	public long getCartId() {
		return cartId;
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}