/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Customer;
import com.nagarro.utils.CheckNumericUtils;
import com.nagarro.utils.HibernateUtil;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	/*--- Save customer ---*/
	@Override
	public long save(Customer customer) {
		
		long customerId = (long) hibernateUtil.create(customer);
		return customerId;
		
	}

	/*--- Get all customers ---*/
	@Override
	public List<Customer> getAllCustomers() {
		
		return hibernateUtil.fetchAll(Customer.class);
		
	}

	/*--- Get customer by id ---*/
	@Override
	public Customer getCustomerById(long customerId) {
		
		return hibernateUtil.fetchById(customerId, Customer.class);
		
	}

	/*--- Get customer list by search parameters ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerBySearchParameter(String searchInput) {
		
		// Get current Session
		Session session = hibernateUtil.getCurrentSession();
		List<Customer> custList;
		//Check if entry is numeric, it may be an customer id or mobile no.
		if( CheckNumericUtils.isNumeric(searchInput) ) {
			long id = Long.parseLong(searchInput);
			String hql = "select c from Customer as c where c.customerId = :custId or c.customerMobile like :custMobile";
			custList = session.createQuery(hql)
							  .setParameter("custId", id)
							  .setParameter("custMobile", searchInput+"%")
							  .list();
			return custList;
		}
		
		//If search parameter isn't numeric value search by customer name and mail.
		String hql = "select c from Customer as c where c.customerName like :custName or "
				   + "c.customerMail like :custMail or c.customerMobile like :custMobile ";
		custList = session.createQuery(hql)
						  .setParameter("custName", searchInput+"%")
						  .setParameter("custMail", searchInput+"%")
						  .setParameter("custMobile", searchInput+"%")
						  .list();
		
		//return list of searched customer.
		return custList;
		
	}

	
}
