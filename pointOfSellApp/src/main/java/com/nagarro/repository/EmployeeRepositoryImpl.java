package com.nagarro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Employee;
import com.nagarro.utils.HibernateUtil;

@Repository("employeeRepo")
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Autowired
    private HibernateUtil hibernateUtil;
	
	@Override
	public long createEmployee(Employee employee) {
		return (Long) hibernateUtil.create(employee);
	}

}
