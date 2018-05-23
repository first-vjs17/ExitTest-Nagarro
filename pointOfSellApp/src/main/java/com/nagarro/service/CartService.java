/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;

/**
 * @author vijaysharma01
 *
 */

public interface CartService {
	long save( Cart cart );
	void saveProductInCart( CartProduct cartProduct );
	void updateProductInCart( CartProduct cartProduct );
	void deleteProductsInCart( long cartId );
	
	List<CartProduct> getAllCartProducts(long cartId);
}
