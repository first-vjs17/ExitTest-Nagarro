/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.EmployeeCashDrawer;

public interface EmployeeCashDrawerService {

	long save( EmployeeCashDrawer employeeCashDrawer );
	
	List<EmployeeCashDrawer> getAllEmployeeCashDrawer( long employeeId );
	
	void update( long employeeId, double endCash );

}
