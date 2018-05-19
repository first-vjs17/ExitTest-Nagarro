package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Employee;
import com.nagarro.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	@Override
	public void addEmployee(Employee employee) {
		System.out.println("In service..");
		employeeRepository.addEmployee(employee);
	}
}
