/**
 * 
 */
package com.nagarro.repository;

import com.nagarro.model.Cart;

/**
 * @author vijaysharma01
 *
 */
public interface CartRepository {

	long save( Cart cart );
}
