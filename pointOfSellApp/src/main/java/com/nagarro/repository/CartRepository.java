/**
 * 
 */
package com.nagarro.repository;

import com.nagarro.model.Cart;
import com.nagarro.model.Cart_Product;

/**
 * @author vijaysharma01
 *
 */
public interface CartRepository {

	long save( Cart cart );
	void saveProductInCart( Cart_Product cartProduct );
}
