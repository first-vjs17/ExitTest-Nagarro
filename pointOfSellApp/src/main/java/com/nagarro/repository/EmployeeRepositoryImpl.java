package com.nagarro.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Employee;
import com.nagarro.utils.HibernateUtil;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createEmployee(Employee employee) {
		return (Long) hibernateUtil.create(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return hibernateUtil.fetchAll(Employee.class);
	}

}
