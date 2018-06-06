/**
 * 
 */
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProductCompositeKey;
import com.nagarro.model.Product;
import com.nagarro.model.CartProduct;
import com.nagarro.service.CartService;
import com.nagarro.uri.CartRestURIConstants;

@CrossOrigin
@RestController
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	
	/*------------------------------ GET METHODS ---------------------------------*/
	
	
	/*--- Get Cart using Customer id ---*/
	@GetMapping( value = CartRestURIConstants.GET_CART )
	public ResponseEntity<List<Cart>> getCart( @PathVariable long custId ) {
		return ResponseEntity.ok().body(cartService.getCartByCustId(custId));
	}

	/*--- Get CartProduct object By Cart id ---*/
	@GetMapping( value = CartRestURIConstants.GET_CART_PRODUCT )
	public ResponseEntity<List<CartProduct>> getAllCartProducts(@PathVariable long cartId) {
		
		List<CartProduct> list = cartService.getAllCartProducts(cartId);
		return ResponseEntity.ok().body(list);
		
	}
	
	
	/*------------------------------- POST METHODS -------------------------------*/
	
	
	/*--- Add a Cart ---*/
	@PostMapping( value = CartRestURIConstants.POST_CART )
	public ResponseEntity<?> addCart(@RequestBody Cart cart) {
		
		cartService.save(cart);
	    return ResponseEntity.ok().body(null);
	
	}
	
	//Reload A On hold order into cart.
	@PostMapping( value = CartRestURIConstants.POST_RELOAD_CART )
	public ResponseEntity<?> reloadCart(@PathVariable long orderId ) {
		
		cartService.reloadCart(orderId);
		return ResponseEntity.ok().body(null);
		
	}
	
	/*--- Add Product in Selected customer cart ---*/
	@PostMapping( value = CartRestURIConstants.POST_PRODUCT_IN_CART_PRODUCT )
	public ResponseEntity<CartProduct> addProductInCart(@PathVariable long cartId,
			@PathVariable long productId, @PathVariable int quantity ){

		CartProduct cartProduct = getCartProduct(cartId, productId, quantity);
		@SuppressWarnings("unused")
		CartProduct cpp = cartService.saveProductInCart(cartProduct);
		CartProduct ccp = cartService.getCartProduct(cartId, productId);
		return ResponseEntity.ok().body(ccp);
		
	}
	
	
	/*------------------------------- DELETE METHODES --------------------------*/
	
	
	/*--- This API will delete the cart entries of customer. ---*/
	@DeleteMapping( value = CartRestURIConstants.DELETE_CART_FROM_CART_PRODUCT )
	public ResponseEntity<?> deleteProductsInCart(@PathVariable String cartId) {
		
		cartService.deleteProductsInCart(Long.parseLong(cartId));
		return ResponseEntity.ok().body(null);
		
	}
	
	/*--- This API will delete a particular product from cart ---*/
	@DeleteMapping( value = CartRestURIConstants.DELETE_ONE_PRODUCT_FROM_CART )
	public ResponseEntity<?> deleteOneProduct( @PathVariable long cartId,
			@PathVariable long productId ) {
		
		Cart cart = new Cart(cartId);
		Product product = new Product(productId);
		CartProductCompositeKey cartProductCompositeKey = new CartProductCompositeKey(cart,product);
		CartProduct cartProduct = new CartProduct(cartProductCompositeKey);
		cartService.deleteOneProduct(cartProduct);
		return ResponseEntity.ok().body(null);
		
	}
	
	
	/*-------------------------------- PUT METHODS ------------------------------*/
	
	
	/* This API will update the quantity of product in DB */
	@PutMapping( value = CartRestURIConstants.UPDATE_PRODUCT_IN_CART )
	public ResponseEntity<?> updateProductInCart(@PathVariable long cartId,
			@PathVariable long productId, @PathVariable int quantity ){
		
		CartProduct cartProduct = getCartProduct(cartId, productId, quantity);
		cartService.updateProductInCart(cartProduct);
		return ResponseEntity.ok().body(null);
		
	}
	
	
	/*----------------------------- HELPING METHODS ----------------------------*/
	
	/*--- Method will give a CartProduct object ---*/
	private CartProduct getCartProduct(long cartId, long productId, int quantity) {
		
		Cart cart = new Cart(cartId);
		Product product = new Product(productId);
		CartProductCompositeKey cartProductCompositeKey = new CartProductCompositeKey(cart,product);
		CartProduct cartProduct = new CartProduct(cartProductCompositeKey,quantity);
		return cartProduct;
		
	}
}
