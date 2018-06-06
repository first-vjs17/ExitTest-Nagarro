/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;
import com.nagarro.repository.CartRepository;

@Transactional
@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public long save(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public void updateProductInCart(CartProduct cartProduct) {
		cartRepository.updateProductInCart(cartProduct);
	}

	@Override
	public CartProduct saveProductInCart(CartProduct cartProduct) {
		return cartRepository.saveProductInCart(cartProduct);
	}

	@Override
	public void deleteProductsInCart(long cartId) {
		cartRepository.deleteProductsInCart(cartId);
	}

	@Override
	public List<CartProduct> getAllCartProducts( long cartId ) {
		return cartRepository.getAllCartProducts( cartId );
	}

	@Override
	public List<Cart> getCartByCustId(long custId) {
		return cartRepository.getCartByCustId(custId);
	}

	@Override
	public void deleteOneProduct(CartProduct cartProduct) {
		cartRepository.deleteOneProduct(cartProduct);
	}

	@Override
	public CartProduct getCartProduct(long cartId, long productId) {
		return cartRepository.getCartProduct(cartId, productId);
	}

	@Override
	public void reloadCart(long orderId) {
		cartRepository.reloadCart(orderId);
	}

}
