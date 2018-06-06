/**
 * 
 */
package com.nagarro.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.utils.HibernateUtil;

@Repository("employeeCashDrawerRepository")
public class EmployeeCashDrawerRepositoryImpl implements EmployeeCashDrawerRepository {

	@Autowired
	private HibernateUtil hibernateUtil;

	/*--- Save employeeCashDrawer object ---*/
	@Override
	public long save(EmployeeCashDrawer employeeCashDrawer) {
		return (long) hibernateUtil.create(employeeCashDrawer);
	}

	/*--- Get all EmployeeCashDrawer by employee id ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeCashDrawer> getAllEmployeeCashDrawer( long employeeId ) {
		Session session = hibernateUtil.getCurrentSession();
		String hql = "From EmployeeCashDrawer where employee.employeeId = :employeeId ";
		return session.createQuery(hql)
				   .setParameter("employeeId", employeeId)
				   .list();
	}

	/* 
	 * Method will set the endCash, after emloyee gets logged out
	 * and set active "false" which means this raw will never be used
	 */
	@Override
	public void update( long employeeId, double endCash ) {
		
		//Get current session.
		Session session = hibernateUtil.getCurrentSession();
		//Update the endcash for an employee by its id.
		String hql = "UPDATE EmployeeCashDrawer set endCash = :cash "
				+ "WHERE employee.employeeId = :id and active = :active";
		session.createQuery(hql)
			   .setParameter("cash", endCash)
			   .setParameter("id", employeeId)
			   .setParameter("active", true)
			   .executeUpdate();
		
		DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		//When employee logouts set its active column as false and update its endtime too.
		hql = "UPDATE EmployeeCashDrawer set active = :notActive, endTime = :endtime "
				+ "WHERE employee.employeeId = :id and active = :active";
		session.createQuery(hql)
			   .setParameter("notActive", false)
			   .setParameter("endtime", now)
			   .setParameter("id", employeeId)
			   .setParameter("active", true)
			   .executeUpdate();

	}
	
}
