/**
 * 
 */
package com.nagarro.repository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public void updateProductInCart(CartProduct cartProduct) {
		hibernateUtil.update(cartProduct);
		
	}

	@Override
	public void saveProductInCart(CartProduct cartProduct) {
		Session session = getCurrentSession();
		session.save(cartProduct);
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void deleteProductsInCart(long cartId) {
		
		Cart cart = new Cart(cartId);
		Session session = getCurrentSession();
		String deleteHql = "delete from CartProduct where pk.cart = :cart ";
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(deleteHql)
				.setParameter("cart", cart);

		query.executeUpdate();
		
	}
	
}
