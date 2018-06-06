/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.EmployeeCashDrawer;

public interface EmployeeCashDrawerRepository {

	long save( EmployeeCashDrawer employeeCashDrawer );
	
	List<EmployeeCashDrawer> getAllEmployeeCashDrawer( long employeeId );
	
	void update( long employeeId, double endCash );

}
