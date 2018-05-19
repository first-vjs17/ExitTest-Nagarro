package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*---get all employees---*/
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public List<Employee> demo() {
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName());
		}
		return employees;
	}
	
	@RequestMapping(value="/addemp")
	public void addEmployee() {
		System.out.println("In controller..");
		Employee emp = new Employee();
		emp.setEmployeeId(101);
		emp.setEmployeeEmail("vij@gmail.com");
		emp.setEmployeeMobileNo("12345678");
		emp.setEmployeeName("vijay");
		emp.setPassword("1234");
		System.out.println(employeeService.createEmployee(emp));
		
	}
}
