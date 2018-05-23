package com.nagarro.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;

@Entity
@Table(name="orderDetails")
public class OrderDetails {
	
	@Column(name="amount")
	private double amount;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Employee employee;
	
	@Enumerated(EnumType.STRING)
	@Column(length=8,name="mode_of_payments")
	private ModeOfPayments modeOfPayments;
	
	@CreationTimestamp
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	@Id
    @GeneratedValue
    @Column(name="order_id")
	private long orderId;
	
	@OneToMany(mappedBy="pk.orderDetails" )
	@JsonIgnore
	private Set<OrderProduct> orderProduct = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
	@Column(length=8,name="status")
	private PaymentStatus status;
	
	public OrderDetails() {
		
	}
	
	
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @return the modeOfPayments
	 */
	public ModeOfPayments getModeOfPayments() {
		return modeOfPayments;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * @return the orderProduct
	 */
	public Set<OrderProduct> getOrderProduct() {
		return orderProduct;
	}

	/**
	 * @return the status
	 */
	public PaymentStatus getStatus() {
		return status;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @param modeOfPayments the modeOfPayments to set
	 */
	public void setModeOfPayments(ModeOfPayments modeOfPayments) {
		this.modeOfPayments = modeOfPayments;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @param orderProduct the orderProduct to set
	 */
	public void setOrderProduct(Set<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	

}
