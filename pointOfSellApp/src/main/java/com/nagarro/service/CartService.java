/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;

public interface CartService {
	
	long save( Cart cart );
	
	CartProduct saveProductInCart( CartProduct cartProduct );
	
	void updateProductInCart( CartProduct cartProduct );
	
	void deleteProductsInCart( long cartId );
	
	List<CartProduct> getAllCartProducts(long cartId);
	
	List<Cart> getCartByCustId(long custId);
	
	public void deleteOneProduct(CartProduct cartProduct);
	
	CartProduct getCartProduct(long cartId, long productId);
	
	void reloadCart(long orderId);

}
