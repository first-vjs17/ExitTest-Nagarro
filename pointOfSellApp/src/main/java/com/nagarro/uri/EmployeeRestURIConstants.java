/**
 * URI for Employee Controller.
 */
package com.nagarro.uri;

/**
 * @author vijaysharma01
 *
 */
public class EmployeeRestURIConstants {

	public static final String LOGOUT_EMP = "/employee/logout";
	
	public static final String GET_EMP = "/employee";
	
	public static final String POST_STARTCASH_EMP = "/employee/{startCash}";
	
	public static final String CREATE_EMP = "/employee";
	
	public static final String GET_LIST_EMP_DRAWER = "/employeeCashDrawer/{employeeId}";
	
	public static final String POST_EMPDRAWER = "/employeeCashDrawer";
	
	public static final String UPDATE_ENDCASH = "/employeeCashDrawer/emp_id/{employeeId}/end_cash/{endCash}";
	
	public static final String DOWNLOAD_EMP_REPORT = "employee/downloads/{empId}";
	
}
