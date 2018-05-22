package com.nagarro.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Employee;
import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.service.EmployeeCashDrawerService;

@RestController
public class EmployeeCashDrawerController {

	@Autowired
	private EmployeeCashDrawerService employeeCashDrawerService;
	
	/*--- Add an EmployeeCashDrawer ---*/
	/* Method will run at time of login when employee enter starting cash */
	@PostMapping( value="/employeeCashDrawer", consumes="application/json")
	public ResponseEntity<?> addEmployeeCashDrawer(@RequestBody EmployeeCashDrawer employeeCashDrawer) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now)); 
		employeeCashDrawer.setStartTime(now);
		employeeCashDrawer.setEndTime(now);
		long id = employeeCashDrawerService.save(employeeCashDrawer);
	    return ResponseEntity.ok().body("New EmployeeCashDrawer has been saved with ID:" + id);
	}
	
	/*--- Get all employeeCashDrawer ---*/
	@GetMapping( value = "/employeeCashDrawer" )
	public ResponseEntity<List<EmployeeCashDrawer>> list() {
		List<EmployeeCashDrawer> employeeCashDrawers = 
				employeeCashDrawerService.getAllEmployeeCashDrawer();
		return ResponseEntity.ok().body(employeeCashDrawers);
	}
	
	/*--- Update an EmployeeCashDrawer ---*/
	/* Method will run at when employee logout */
	@PutMapping( value = "/employeeCashDrawer/{employeeId}/{endCash}")
	public ResponseEntity<?> updateEmployeeCashDrawer(@PathVariable String employeeId,
			@PathVariable String endCash) {
		employeeCashDrawerService.update(employeeId, endCash);
		return ResponseEntity.ok().body("Update EmployeeCashDrawer");
	}
	
}
