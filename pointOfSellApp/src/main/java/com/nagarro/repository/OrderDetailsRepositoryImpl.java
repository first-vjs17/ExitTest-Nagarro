/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	
}
