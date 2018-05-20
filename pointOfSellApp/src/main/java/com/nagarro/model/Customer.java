package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private long customerId;
	private String customerName;
	private String customerMail;
	private String customerMobile;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private Set<OrderDetails> orderDetails = new HashSet<>();
	
//	@OneToOne(mappedBy="customer", fetch=FetchType.LAZY)
//	private Cart cart = new Cart();


	/**
	 * @return the cart
	 */
//	public Cart getCart() {
//		return cart;
//	}
//
//	/**
//	 * @param cart the cart to set
//	 */
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

	/**
	 * @return the orderDetails
	 */
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Customer() {
		
	}
	
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerMail
	 */
	public String getCustomerMail() {
		return customerMail;
	}
	/**
	 * @param customerMail the customerMail to set
	 */
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	/**
	 * @return the customerMobile
	 */
	public String getCustomerMobile() {
		return customerMobile;
	}
	/**
	 * @param customerMobile the customerMobile to set
	 */
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	
	
}
