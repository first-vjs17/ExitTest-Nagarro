package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Customer;
import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*--- add a employee ---*/
	@PostMapping( value = "/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		long id = employeeService.createEmployee(employee);
	    return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
	}
	
	/*---get all employees---*/
	@GetMapping(value="/employee")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok().body(employees);
	}
	
	/*---Get a employee by id---*/
//	@GetMapping("/employee/{id}")
//	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id) {
//		Employee employee = employeeService.
//		return ResponseEntity.ok().body(customer);
//	}
}
