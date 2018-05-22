/**
 * 
 */
package com.nagarro.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */
@Repository("employeeCashDrawerRepository")
public class EmployeeCashDrawerRepositoryImpl
		implements
			EmployeeCashDrawerRepository {

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(EmployeeCashDrawer employeeCashDrawer) {
		return (long) hibernateUtil.create(employeeCashDrawer);
	}

	@Override
	public List<EmployeeCashDrawer> getAllEmployeeCashDrawer() {
		return hibernateUtil.fetchAll(EmployeeCashDrawer.class);
	}

	/* Method will set the endCash, after emloyee gets logged out
	 * and set active "false" which means this raw will never be used
	 */
	@Override
	public void update( String employeeId, String endCash ) {
		
		Session session = getCurrentSession();

		String hql = "UPDATE EmployeeCashDrawer set endCash = :cash "
				+ "WHERE employee.employeeId = :id and active = :active";
		Query query = session.createQuery(hql);
		query.setParameter("cash", Double.parseDouble(endCash));
		query.setParameter("id", Long.parseLong(employeeId));
		query.setParameter("active", true);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		hql = "UPDATE EmployeeCashDrawer set active = :notActive, endTime = :endtime "
				+ "WHERE employee.employeeId = :id and active = :active";
		query = session.createQuery(hql);
		query.setParameter("notActive", false);
		query.setParameter("endtime", now);
		query.setParameter("id", Long.parseLong(employeeId));
		query.setParameter("active", true);
		result = query.executeUpdate();

	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
