/**
 * 
 */
package com.nagarro.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.model.OrderDetails;
import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */
@Repository("orderDetailsRepository")
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(OrderDetails orderDetails) {
		return (long) hibernateUtil.create(orderDetails);
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return hibernateUtil.fetchAll(OrderDetails.class);
	}

	@Override
	public OrderDetails getOrderDetailById(long OrderDetailId) {
		return hibernateUtil.fetchById(OrderDetailId, OrderDetails.class);
	}
	
	
	/* Method will give the total Amount between specific time period
	 * for a particular employee 
	 */
	@Override
	public double getAmountBetweenDate(long employeeId,
			LocalDateTime startTime, LocalDateTime endTime) {
		
		Session session = getCurrentSession();
		String sumHql = "Select sum(amount) FROM OrderDetails where "
				+ "employee.employeeId = :id and "
				+ "modeOfPayments = :mop "
				+ "orderDate between :start and :end";
		Query query = session.createQuery(sumHql)
		.setParameter("id", employeeId)
		.setParameter("endtime", endTime)
		.setParameter("startTime", startTime)
		.setParameter("mop" , ModeOfPayments.CASH);
		
		List<Integer> list=query.list();  
		System.out.println(list.get(0));
		
		return list.get(0);
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
