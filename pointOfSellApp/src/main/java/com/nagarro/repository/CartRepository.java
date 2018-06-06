/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;

public interface CartRepository {

	long save( Cart cart );
	
	CartProduct saveProductInCart( CartProduct cartProduct );
	
	void updateProductInCart( CartProduct cartProduct );
	
	void deleteProductsInCart( long cartId );
	
	List<CartProduct> getAllCartProducts(long cartId);
	
	List<Cart> getCartByCustId(long custId);
	
	void deleteOneProduct( CartProduct cartProduct );
	
	CartProduct getCartProduct(long cartId, long productId);
	
	void reloadCart(long orderId);

}
