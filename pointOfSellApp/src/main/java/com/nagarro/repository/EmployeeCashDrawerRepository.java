/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.EmployeeCashDrawer;

/**
 * @author vijaysharma01
 *
 */
public interface EmployeeCashDrawerRepository {

	long save( EmployeeCashDrawer employeeCashDrawer );
	List<EmployeeCashDrawer> getAllEmployeeCashDrawer();
	void update( String employeeId, String endCash );

}
