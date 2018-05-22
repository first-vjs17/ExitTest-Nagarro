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

/**
 * @author vijaysharma01
 *
 */
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
	public List<EmployeeCashDrawer> getAllEmployeeCashDrawer() {
		return employeeCashDrawerRepository.getAllEmployeeCashDrawer();
	}

	@Override
	public void update(String employeeId, String endCash) {
		employeeCashDrawerRepository.update(employeeId, endCash);
	}

}
