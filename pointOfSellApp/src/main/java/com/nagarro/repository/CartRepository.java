/**
 * 
 */
package com.nagarro.repository;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;

/**
 * @author vijaysharma01
 *
 */
public interface CartRepository {

	long save( Cart cart );
	void saveProductInCart( CartProduct cartProduct );
	void updateProductInCart( CartProduct cartProduct );
	void deleteProductsInCart( long cartId );
}
