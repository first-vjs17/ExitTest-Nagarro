package com.nagarro.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;
import com.nagarro.model.Employee;
import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.model.OrderDetails;
import com.nagarro.utils.HibernateUtil;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired 
	private EmployeeCashDrawerRepository employeeCashDrawerRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	/*--- Save Employee ---*/
	@Override
	public long createEmployee(Employee employee) {
		return (Long) hibernateUtil.create(employee);
	}

	/*--- Get all employees ---*/
	@Override
	public List<Employee> getAllEmployees() {
		return hibernateUtil.fetchAll(Employee.class);
	}

	/*--- Check employee is valid or not ---*/
	@SuppressWarnings("unchecked")
	@Override
	public Employee employeeVarification(Employee employee, double startCash ) {
		
		//get current session
		Session session = hibernateUtil.getCurrentSession();
		String hql = "from Employee where employeeName = :empName and password = :password";
		List<Employee> list = session.createQuery(hql)
									 .setParameter("empName", employee.getEmployeeName())
									 .setParameter("password", employee.getPassword())
									 .list();
		
		//List empty means employee is not enter valid details.
		Employee emp = null;
		if( !list.isEmpty() ) {
			//make employee object
			emp = list.get(0);
			EmployeeCashDrawer employeeCashDrawer = new EmployeeCashDrawer();
			DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			employeeCashDrawer.setStartTime(now);
			employeeCashDrawer.setEndTime(now);
			employeeCashDrawer.setEmployee(emp);
			employeeCashDrawer.setActive(true);
			employeeCashDrawer.setStartCash(startCash);
			employeeCashDrawer.setEndCash(startCash);
			session.save(employeeCashDrawer);
		}
		return emp;
	}

	/*--- Employee logout ---*/
	@SuppressWarnings("unchecked")
	@Override
	public double logoutEmployee(Employee employee) {
		
		//get current session
		Session session = hibernateUtil.getCurrentSession();
		
		//Find employee last active entry.
		String hql = "from EmployeeCashDrawer where employee.employeeId = :empid and active = :active";
		List<EmployeeCashDrawer> empList = session.createQuery(hql)
							 			.setParameter("empid", employee.getEmployeeId())
							 			.setParameter("active", true)
							 			.list();
		
		EmployeeCashDrawer empCashDrawer = empList.get(0);
		
		//Check all the order entries by login employee in its ongoing duration. 
		String hql2 = "FROM OrderDetails where "
						+ "employee.employeeId = :id and "
						+ "modeOfPayments = :mop and "
						+ "status = :status and "
						+ "orderDate between :start and :end";
		
		DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		
		Query query = session.createQuery(hql2)
							 .setParameter("id", employee.getEmployeeId())
							 .setParameter("end", now)
							 .setParameter("status", PaymentStatus.PAID)
							 .setParameter("start", empCashDrawer.getStartTime())
							 .setParameter("mop" , ModeOfPayments.CASH);
		
		//Calculate its end cash.
		List<OrderDetails> list=query.list();  
		double endCash = empCashDrawer.getStartCash();
		for (OrderDetails orderDetails : list) {
			endCash = endCash + orderDetails.getAmount();
		}
		
		// update its end cash in employee cash drawer.
		employeeCashDrawerRepository.update(employee.getEmployeeId(), endCash);
		
		return endCash;
		
	}

	@Override
	public List<Employee> downloadDataByEmployeeId(long empId) {
		
		//LocalDateTime startOfDay = date.atStartOfDay(); // 2014-02-15 00:00
		LocalDateTime endTime = LocalDateTime.now();
		LocalDate date = LocalDate.now();
		LocalDateTime st = LocalDateTime.now();
		LocalDateTime startTime = st.minus(10, ChronoUnit.DAYS);
		System.out.println("endTime: " + endTime + "   " + "startTime: " + startTime );
		
		double totalCash = orderDetailsRepository.getAmountBetweenDate(empId, startTime, endTime);
		
		return null;
		
	}


}
