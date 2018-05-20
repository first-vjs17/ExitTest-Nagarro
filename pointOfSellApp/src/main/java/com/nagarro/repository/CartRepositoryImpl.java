/**
 * 
 */
package com.nagarro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Cart;
import com.nagarro.model.Customer;
import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */

@Repository("cartRepository")
public class CartRepositoryImpl implements CartRepository{

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long save(Cart cart) {
		return (long) hibernateUtil.create(cart);
	}
	
}
