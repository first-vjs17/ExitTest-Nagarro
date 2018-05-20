/**
 * 
 */
package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.repository.CartRepository;

/**
 * @author vijaysharma01
 *
 */

@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
}
