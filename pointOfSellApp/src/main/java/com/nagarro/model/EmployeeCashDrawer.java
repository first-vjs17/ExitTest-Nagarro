/**
 * This table will maintain Employee CashDrawer Details in each Session.
 */
package com.nagarro.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author vijaysharma01
 *
 */

@Entity
public class EmployeeCashDrawer implements Serializable{
	
	@Id
	@GeneratedValue
	private long employeeCashId;

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private double startCash;
	private double endCash;
	private boolean active;

	@ManyToOne //(fetch=FetchType.EAGER)
//	@JoinColumn(name="employeeId", nullable=false)
	private Employee employee;
	
	public EmployeeCashDrawer() {
		
	}
	
	public EmployeeCashDrawer(boolean active) {
		this.active = active;
	}

	/**
	 * @return the employeeCashId
	 */
	public long getEmployeeCashId() {
		return employeeCashId;
	}
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param employeeCashId the employeeCashId to set
	 */
	public void setEmployeeCashId(long employeeCashId) {
		this.employeeCashId = employeeCashId;
	}

	/**
	 * @return the startTime
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the startCash
	 */
	public double getStartCash() {
		return startCash;
	}

	/**
	 * @param startCash the startCash to set
	 */
	public void setStartCash(double startCash) {
		this.startCash = startCash;
	}

	/**
	 * @return the endCash
	 */
	public double getEndCash() {
		return endCash;
	}

	/**
	 * @param endCash the endCash to set
	 */
	public void setEndCash(double endCash) {
		this.endCash = endCash;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
