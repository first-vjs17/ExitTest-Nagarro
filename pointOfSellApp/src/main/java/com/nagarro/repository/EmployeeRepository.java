/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Employee;

public interface EmployeeRepository {

	public long createEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee employeeVarification( Employee employee, double startCash);
	
	public double logoutEmployee( Employee employee );
	
	public List<Employee> downloadDataByEmployeeId(long empId);

}
