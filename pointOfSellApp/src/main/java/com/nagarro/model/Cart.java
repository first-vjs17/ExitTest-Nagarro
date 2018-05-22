/**
 * 
 */
package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author vijaysharma01
 *
 */

@Entity
@Table(name= "cart")
public class Cart {
	
	@Id
	@GeneratedValue
	@Column( name = "cartId" )
	private long cartId;
	
	@OneToMany(mappedBy="pk.cart" )
	private Set<CartProduct> cartProduct = new HashSet<>();
	
	@OneToOne( cascade = CascadeType.ALL )
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
	 * @return the cartProduct
	 */
	public Set<CartProduct> getCartProduct() {
		return cartProduct;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @param cartProduct the cartProduct to set
	 */
	public void setCartProduct(Set<CartProduct> cartProduct) {
		this.cartProduct = cartProduct;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}