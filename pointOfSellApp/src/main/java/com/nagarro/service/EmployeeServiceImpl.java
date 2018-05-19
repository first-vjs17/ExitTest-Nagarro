package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Employee;
import com.nagarro.repository.EmployeeRepository;

@Transactional
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public long createEmployee( Employee employee ) {
		
		return employeeRepository.createEmployee(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
	
//	@Autowired
//	EmployeeRepository employeeRepository;
//
//	@Override
//	public long createEmployee(Employee employee) {
//        return employeeRepository.createEmployee(employee);
//    }
}
