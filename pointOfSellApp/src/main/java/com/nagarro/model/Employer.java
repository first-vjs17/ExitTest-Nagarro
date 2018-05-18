package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employer {

	@Id
    @GeneratedValue
	private long employerId;
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
	 * @return the order
	 */
	public Set<Order> getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	private String employerName;
	private String employerEmail;
	private String employerMobileNo;
	private String password;
	
	@OneToMany(mappedBy = "employee")
	private Set<EmployeeCashDrawer> employeeCashDrawerDetails = new HashSet<>();
	
	@OneToMany(mappedBy = "employee")
	private Set<Order> order = new HashSet<>();
	
	public Employer() {
		
	}

	/**
	 * @return the employerId
	 */
	public long getEmployerId() {
		return employerId;
	}

	/**
	 * @param employerId the employerId to set
	 */
	public void setEmployerId(long employerId) {
		this.employerId = employerId;
	}

	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}

	/**
	 * @param employerName the employerName to set
	 */
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	/**
	 * @return the employerEmail
	 */
	public String getEmployerEmail() {
		return employerEmail;
	}

	/**
	 * @param employerEmail the employerEmail to set
	 */
	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}

	/**
	 * @return the employerMobileNo
	 */
	public String getEmployerMobileNo() {
		return employerMobileNo;
	}

	/**
	 * @param employerMobileNo the employerMobileNo to set
	 */
	public void setEmployerMobileNo(String employerMobileNo) {
		this.employerMobileNo = employerMobileNo;
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
