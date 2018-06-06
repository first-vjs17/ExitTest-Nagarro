package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "cust_id")
	private long customerId;
	
	@Column(name = "cust_name")
	private String customerName;
	
	@Column(name = "cust_mail")
	private String customerMail;
	
	@Column(name = "cust_mobile")
	private String customerMobile;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<OrderDetails> orderDetails = new HashSet<>();

	public Customer() {
		
	}
	
	public Customer(long custId) {
		this.customerId = custId;
	}

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
