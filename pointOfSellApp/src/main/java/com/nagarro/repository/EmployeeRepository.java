/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Employee;

/**
 * @author vijaysharma01
 *
 */
public interface EmployeeRepository {

	public long createEmployee(Employee employee);
	public List<Employee> getAllEmployees();

}
