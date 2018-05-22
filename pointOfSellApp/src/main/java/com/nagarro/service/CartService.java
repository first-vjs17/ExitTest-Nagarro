/**
 * 
 */
package com.nagarro.service;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;

/**
 * @author vijaysharma01
 *
 */

public interface CartService {
	long save( Cart cart );
	void saveProductInCart( CartProduct cartProduct );
}
