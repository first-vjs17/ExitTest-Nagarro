package com.nagarro.model;

import java.io.Serializable;
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
public class Employee implements Serializable {

	@Id
    @GeneratedValue
    @Column(name = "emp_id")
	private long employeeId;
	
	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name = "emp_mail")
	private String employeeEmail;
	
	@Column(name = "emp_mobile")
	private String employeeMobileNo;
	
	@Column(name = "password")
	private String password;
	
	public Employee() {
		
	}
	
	public Employee(long id) {
		this.employeeId = id;
	}
	
	@OneToMany(mappedBy = "employee", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<EmployeeCashDrawer> employeeCashDrawerDetails = new HashSet<>();
	
//	@OneToMany(mappedBy = "employee", fetch=FetchType.EAGER)
//	private Set<OrderDetails> orderDetails = new HashSet<>();
	/**
	 * @return the employeeCashDrawerDetails
	 */
	public Set<EmployeeCashDrawer> getEmployeeCashDrawerDetails() {
		return employeeCashDrawerDetails;
	}

	/**
	 * @param employeeCashDrawerDetails the employeeCashDrawerDetails to set
	 */
	public void setEmployeeCashDrawerDetails(
			Set<EmployeeCashDrawer> employeeCashDrawerDetails) {
		this.employeeCashDrawerDetails = employeeCashDrawerDetails;
	}

	/**
	 * @return the orderDetails
	 */
//	public Set<OrderDetails> getOrderDetails() {
//		return orderDetails;
//	}
//
//	/**
//	 * @param orderDetails the orderDetails to set
//	 */
//	public void setOrderDetails(Set<OrderDetails> orderDetails) {
//		this.orderDetails = orderDetails;
//	}


	/**
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeEmail
	 */
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	/**
	 * @param employeeEmail the employeeEmail to set
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	/**
	 * @return the employeeMobileNo
	 */
	public String getEmployeeMobileNo() {
		return employeeMobileNo;
	}

	/**
	 * @param employeeMobileNo the employeeMobileNo to set
	 */
	public void setEmployeeMobileNo(String employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
