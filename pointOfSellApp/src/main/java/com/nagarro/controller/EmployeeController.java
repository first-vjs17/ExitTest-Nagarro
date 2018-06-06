package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;
import com.nagarro.uri.EmployeeRestURIConstants;

@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*------------------------------ GET METHODS ---------------------------------*/
	
	
	/*---get all employees---*/
	@GetMapping(value= EmployeeRestURIConstants.GET_EMP )
	public ResponseEntity<List<Employee>> list() {
		List<Employee> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok().body(employees);
	}
	
	/*---   ---*/
	@GetMapping( value = EmployeeRestURIConstants.DOWNLOAD_EMP_REPORT )
	public ResponseEntity< List<Employee> > downloadDataByEmployeeId( @PathVariable long empId ){
		
		return ResponseEntity.ok().body(employeeService.downloadDataByEmployeeId(empId)); 
	}
	
	
	/*------------------------------ POST METHODS --------------------------------*/
	
	
	/*--- add a employee ---*/
	@PostMapping( value = EmployeeRestURIConstants.CREATE_EMP )
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		long id = employeeService.createEmployee(employee);
	    return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
	}
	
	/*--- Return a boolean value to varify whether an employee is valid or not ---*/
	@PostMapping( value = EmployeeRestURIConstants.POST_STARTCASH_EMP )
	public ResponseEntity<Employee > employeeVarification( @RequestBody Employee employee,
			@PathVariable double startCash) {
		
		return ResponseEntity.ok().body(employeeService.employeeVarification(employee, startCash));
		
	}
	
	@PostMapping( value = EmployeeRestURIConstants.LOGOUT_EMP )
	public ResponseEntity<Double> logoutEmployee(@RequestBody Employee employee) {
		
		return ResponseEntity.ok().body(employeeService.logoutEmployee(employee));
	}

	
}
