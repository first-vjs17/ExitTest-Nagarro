/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.EmployeeCashDrawer;

/**
 * @author vijaysharma01
 *
 */
public interface EmployeeCashDrawerService {

	long save( EmployeeCashDrawer employeeCashDrawer );
	List<EmployeeCashDrawer> getAllEmployeeCashDrawer();
	void update( String employeeId, String endCash );

}
