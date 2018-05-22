/**
 * 
 */
package com.nagarro.repository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;
import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */

@Repository("cartRepository")
public class CartRepositoryImpl implements CartRepository{

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Cart cart) {
		return (long) hibernateUtil.create(cart);
	}

	@Override
	public void saveProductInCart(CartProduct cartProduct) {
		getCurrentSession().save(cartProduct);
//		getCurrentSession().createNativeQuery("select sum(amount)");
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
