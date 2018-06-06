/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Employee;


public interface EmployeeService {

	public long createEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	Employee employeeVarification(Employee employee, double startCash );
	
	double logoutEmployee(Employee employee);
	
	public List<Employee> downloadDataByEmployeeId(long empId);
	
}
