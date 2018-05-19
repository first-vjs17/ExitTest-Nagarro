/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Employee;

/**
 * @author vijaysharma01
 *
 */
public interface EmployeeService {

	public long createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	
}
