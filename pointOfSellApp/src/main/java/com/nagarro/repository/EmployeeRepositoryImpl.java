package com.nagarro.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.nagarro.model.Employee;

@Repository("employeeRepo")
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addEmployee(Employee employee) {
		System.out.println("In Repo..");
		em.persist(employee);
		em.flush();
	}

}
