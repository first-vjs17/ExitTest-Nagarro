/**
 * 
 */
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

/**
 * @author vijaysharma01
 *
 */
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	/*--- Add a Cart ---*/
	@PostMapping( value = "/cart")
	public ResponseEntity<?> addCart(@RequestBody Cart cart) {
		long id = cartService.save(cart);
	    return ResponseEntity.ok().body("New Cart has been saved with ID:" + id);
	}
	
	@PostMapping( value = "/cartProduct/{cartId}/{productId}/{quantity}")
	public ResponseEntity<?> addProductInCart(@PathVariable String cartId,
			@PathVariable String productId, @PathVariable String quantity ){

		CartProduct cartProduct = getCartProduct(cartId, productId, quantity);
		
		cartService.saveProductInCart(cartProduct);
		
		return ResponseEntity.ok().body("New CartProduct has been saved with ID:");
	}
	
	/*
	 * This API will delete the cart entries of customer.
	 */
	@DeleteMapping( value = "/cartProduct/{cartId}" )
	public ResponseEntity<?> deleteProductsInCart(@PathVariable String cartId) {
		cartService.deleteProductsInCart(Long.parseLong(cartId));
		return ResponseEntity.ok().body("Products has been deleted.");
	}
	
	/* This API will update the quantity of product in DB */
	@PutMapping( value = "/cartProduct/{cartId}/{productId}/{quantity}")
	public ResponseEntity<?> updateProductInCart(@PathVariable String cartId,
			@PathVariable String productId, @PathVariable String quantity ){
		
		CartProduct cartProduct = getCartProduct(cartId, productId, quantity);
		
		cartService.updateProductInCart(cartProduct);
		
		return ResponseEntity.ok().body("Products has been updated.");
	}
	
	@GetMapping( value = "/cartProduct/{cartId}" )
	public ResponseEntity<List<CartProduct>> getAllCartProducts(@PathVariable long cartId) {
		List<CartProduct> list = cartService.getAllCartProducts(cartId);
		return ResponseEntity.ok().body(list);
	}
	
	private CartProduct getCartProduct(String cartId, String productId, String quantity) {
		Cart cart = new Cart(Long.parseLong(cartId));
		Product product = new Product(Long.parseLong(productId));
		
		CartProductCompositeKey cartProductCompositeKey = 
				new CartProductCompositeKey(cart,product);
		CartProduct cartProduct = new CartProduct(cartProductCompositeKey,
				Integer.parseInt(quantity));
		
		return cartProduct;
	}
}
