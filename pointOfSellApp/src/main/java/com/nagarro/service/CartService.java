/**
 * 
 */
package com.nagarro.service;

import com.nagarro.model.Cart;
import com.nagarro.model.Cart_Product;

/**
 * @author vijaysharma01
 *
 */

public interface CartService {
	long save( Cart cart );
	void saveProductInCart( Cart_Product cartProduct );
}
