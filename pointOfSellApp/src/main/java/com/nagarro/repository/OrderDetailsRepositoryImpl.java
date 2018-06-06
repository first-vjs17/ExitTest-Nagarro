package com.nagarro.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.enums.ModeOfPayments;
import com.nagarro.enums.PaymentStatus;
import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;
import com.nagarro.model.Customer;
import com.nagarro.model.Employee;
import com.nagarro.model.EmployeeCashDrawer;
import com.nagarro.model.OrderDetails;
import com.nagarro.model.OrderProduct;
import com.nagarro.model.OrderProductCompositeKey;
import com.nagarro.model.Product;
import com.nagarro.utils.HibernateUtil;

@Repository("orderDetailsRepository")
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	/*--- Method for saving OrderDetails object in OrderDetails Table ---*/
	@Override
	public long save(OrderDetails orderDetails) {
		return (long) hibernateUtil.create(orderDetails);
	}

	/* Get all OrderDetails objects ---*/
	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return hibernateUtil.fetchAll(OrderDetails.class);
	}

	/*--- Get OrderDetails object using order id ---*/
	@Override
	public OrderDetails getOrderDetailById(long orderDetailId) {
		return hibernateUtil.fetchById(orderDetailId, OrderDetails.class);
	}
	
	
	/* Method will give the total Amount between specific time period
	 * for a particular employee 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public double getAmountBetweenDate(long employeeId,
			LocalDateTime startTime, LocalDateTime endTime) {
		
		// get current session
		Session session = hibernateUtil.getCurrentSession();
		
		String sumHql = "FROM OrderDetails where "
						+ "employee.employeeId = :id and "
						+ "modeOfPayments = :mop and "
						+ "status = :status and "
						+ "orderDate between :start and :end";
		
		Query query = session.createQuery(sumHql)
							 .setParameter("id", employeeId)
							 .setParameter("end", endTime)
							 .setParameter("start", startTime)
							 .setParameter("status", PaymentStatus.PAID)
							 .setParameter("mop" , ModeOfPayments.CASH);
		
		double endCash = 0;
		List<OrderDetails> list = query.list();
		for (OrderDetails orderDetails : list) {
			endCash = endCash + orderDetails.getAmount();
		}
		return endCash;
		
	}

	/*--- Get list of complete orders ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> getAllCompleteOrderDetails(long empId) {

		Session session = hibernateUtil.getCurrentSession();
		String hql = "from OrderDetails where status = :status and employee.employeeId"
				   + " = :empid order by orderDate DESC";
		return session.createQuery(hql)
					  .setParameter("status", PaymentStatus.PAID)
					  .setParameter("empid", empId)
					  .list();
		
	}

	/*--- Get List of On Hold status orders ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> getAllOnHoldOrderDetails(long empId) {
		
		Session session = hibernateUtil.getCurrentSession();
		String hql = "from OrderDetails where status = :status and employee.employeeId"
				   + " = :empid order by orderDate DESC";
		return session.createQuery(hql)
					  .setParameter("status", PaymentStatus.ON_HOLD)
					  .setParameter("empid", empId)
					  .list();
		
	}

	
	/*--- Get data from Cart by cartId and post in OrderDetail and OrderProduct ---*/
	@Override
	public void saveOrder(long cartId, long employeeId, long custId, double amount,
			PaymentStatus status, List<CartProduct> list, ModeOfPayments modeOfPay ) {
		
		// Create object of Cart, Employee and Customer.
		Cart cart = new Cart(cartId);
		Employee employee = new Employee(employeeId);
		Customer customer = new Customer(custId);
		
		// Set Above Details in OrderDetails object.
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setCustomer(customer);
		orderDetails.setEmployee(employee);
		if( status == PaymentStatus.ON_HOLD ) 
			orderDetails.setStatus(PaymentStatus.ON_HOLD);
		else 
			orderDetails.setStatus(PaymentStatus.PAID);
		if( modeOfPay == ModeOfPayments.CASH )
			orderDetails.setModeOfPayments(ModeOfPayments.CASH);
		else if( modeOfPay == ModeOfPayments.CARD )
			orderDetails.setModeOfPayments(ModeOfPayments.CARD);
		orderDetails.setAmount(amount);
		
		//Save orderDetails object in DB and get orderId.
		long orderId = (long) hibernateUtil.create(orderDetails);
		OrderDetails od = new OrderDetails(orderId);
		
		// Placed each product from cart table to OrderProduct table.
		Session session = hibernateUtil.getCurrentSession();
		for (CartProduct cp : list) {
			Product product = cp.getCp().getProduct();
			OrderProductCompositeKey key = new OrderProductCompositeKey(od,product);
			OrderProduct orderProduct = new OrderProduct(key, cp.getQuantity());
			session.save(orderProduct);
			// If payment status is paid update the stock.
			if( status == PaymentStatus.PAID ) {
				product.setStock(product.getStock()-cp.getQuantity());
				session.update(product);
			}
		}
		
		if( status == PaymentStatus.PAID ) {
			//Get current session.
			session = hibernateUtil.getCurrentSession();
			//Update the endcash and endTime for an employee by its id.
			String hql = "from employeeCashDrawer where employee.employeeId ="
							+ " :employeeId and active = :active";
			EmployeeCashDrawer employeeCashDrawer = (EmployeeCashDrawer) session.createQuery(hql)
														   						.setParameter("id", employeeId)
														   						.setParameter("active", true)
														   						.list().get(0);
			employeeCashDrawer.setEndCash( employeeCashDrawer.getEndCash() + amount );
			employeeCashDrawer.setEndTime(LocalDateTime.now());
		}
		
		// Delete entries from Cart.
		String deleteHql = "delete from CartProduct where cp.cart = :cart ";
		session.createQuery(deleteHql).setParameter("cart", cart).executeUpdate();
		

	}

	/*--- Get OrderProduct by id ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderProduct> getOrderProductById(long orderId) {
		
		OrderDetails orderDetails = new OrderDetails(orderId);
		String hql = "from OrderProduct where pk.orderDetails = :od";
		Session session = hibernateUtil.getCurrentSession();
		return session.createQuery(hql).setParameter("od", orderDetails).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> getOrderDetailsListInGivenTime( long employeeCashDrawerId) {

		//Get current Session.
		Session session = hibernateUtil.getCurrentSession();
		//Get EmployeeCashDrawer Object by its Id.
		EmployeeCashDrawer employeeCashDrawer = session.get(EmployeeCashDrawer.class, employeeCashDrawerId);
		//Take startTime and endTime from employeeCashDrawer
		//Find all OrderDetails between this duration.
		String hql = "from OrderDetails where employee.employeeId = :employeeId"
				   + " and orderDate between :start and :end ";
		List<OrderDetails> orderDetailsList = session.createQuery(hql)
													 .setParameter("employeeId", employeeCashDrawer.getEmployee().getEmployeeId())
													 .setParameter("start", employeeCashDrawer.getStartTime())
													 .setParameter("end", employeeCashDrawer.getEndTime())
													 .list();
		return orderDetailsList;
		
	}
	
}
