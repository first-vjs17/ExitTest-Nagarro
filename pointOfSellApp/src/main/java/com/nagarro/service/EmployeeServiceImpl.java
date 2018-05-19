package com.nagarro.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Employee;
import com.nagarro.repository.EmployeeRepository;

@Transactional
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public long createEmployee( Employee employee ) {
		
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return 0;
		
	}

//	@Autowired
//	EmployeeRepository employeeRepository;
//
//	@Override
//	public long createEmployee(Employee employee) {
//        return employeeRepository.createEmployee(employee);
//    }
}
