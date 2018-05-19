package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@RequestMapping(value="/employee", method = RequestMethod.GET)
//	public String demo() {
//		return "Hello";
//	}
	
	@RequestMapping(value="/addemp")
	public void addEmployee() {
//		System.out.println(employee.getEmployeeId()+" "+employee.getEmployeeName());
		System.out.println("In controller..");
		Employee emp = new Employee();
		emp.setEmployeeId(101);
		emp.setEmployeeEmail("vij@gmail.com");
		emp.setEmployeeMobileNo("12345678");
		emp.setEmployeeName("vijay");
		emp.setPassword("1234");
		employeeService.addEmployee(emp);
	}
}
