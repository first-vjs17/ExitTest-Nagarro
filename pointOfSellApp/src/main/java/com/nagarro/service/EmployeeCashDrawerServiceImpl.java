/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.repository.EmployeeCashDrawerRepository;

@Transactional
@Service("employeeCashDrawerService")
public class EmployeeCashDrawerServiceImpl implements EmployeeCashDrawerService{
	
	@Autowired
	private EmployeeCashDrawerRepository employeeCashDrawerRepository;

	@Override
	public long save(EmployeeCashDrawer employeeCashDrawer) {
		return employeeCashDrawerRepository.save(employeeCashDrawer);
	}

	@Override
	public List<EmployeeCashDrawer> getAllEmployeeCashDrawer( long employeeId ) {
		return employeeCashDrawerRepository.getAllEmployeeCashDrawer( employeeId );
	}

	@Override
	public void update(long employeeId, double endCash ) {
		employeeCashDrawerRepository.update(employeeId, endCash);
	}

}
