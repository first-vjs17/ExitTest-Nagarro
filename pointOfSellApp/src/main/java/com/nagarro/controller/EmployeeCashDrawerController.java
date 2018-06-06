package com.nagarro.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.service.EmployeeCashDrawerService;
import com.nagarro.uri.EmployeeRestURIConstants;

@CrossOrigin
@RestController
public class EmployeeCashDrawerController {

	@Autowired
	private EmployeeCashDrawerService employeeCashDrawerService;

	/*------------------------------ GET METHODS ---------------------------------*/

	/*--- Get all employeeCashDrawer ---*/
	@GetMapping(value = EmployeeRestURIConstants.GET_LIST_EMP_DRAWER )
	public ResponseEntity<List<EmployeeCashDrawer>> list(@PathVariable long employeeId ) {
		
		List<EmployeeCashDrawer> employeeCashDrawers = employeeCashDrawerService.getAllEmployeeCashDrawer(employeeId);
		return ResponseEntity.ok().body(employeeCashDrawers);
		
	}

	/*------------------------------ POST METHODS --------------------------------*/

	/*--- Add an EmployeeCashDrawer ---*/
	/* Method will run at time of login when employee enter starting cash */
	@PostMapping(value = EmployeeRestURIConstants.POST_EMPDRAWER , consumes = "application/json")
	public ResponseEntity<?> addEmployeeCashDrawer(@RequestBody EmployeeCashDrawer employeeCashDrawer) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		employeeCashDrawer.setStartTime(now);
		employeeCashDrawer.setEndTime(now);
		long id = employeeCashDrawerService.save(employeeCashDrawer);
		return ResponseEntity.ok().body(null);
		
	}

	/*------------------------------- PUT METHODS --------------------------------*/

	/*--- Update an EmployeeCashDrawer ---*/
	/*--- Method will run at when employee logout ---*/
	@PutMapping(value = EmployeeRestURIConstants.UPDATE_ENDCASH )
	public ResponseEntity<?> updateEmployeeCashDrawer(@PathVariable long employeeId, @PathVariable double endCash) {
		
		employeeCashDrawerService.update(employeeId, endCash);
		return ResponseEntity.ok().body("Update EmployeeCashDrawer");
		
	}

}
