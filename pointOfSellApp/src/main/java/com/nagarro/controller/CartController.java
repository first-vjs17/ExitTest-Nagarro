/**
 * 
 */
package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//Not Working API
	@PostMapping( value = "/cartProduct/{cartId}/{productId}/{quantity}")
	public ResponseEntity<?> addProductInCart(@PathVariable String cartId,
			@PathVariable String productId, @PathVariable String quantity ){

		Cart cart = new Cart(Long.parseLong(cartId));
		Product product = new Product(Long.parseLong(productId));
		
		CartProductCompositeKey cartProductCompositeKey = 
				new CartProductCompositeKey(cart,product);
		CartProduct cartProduct = new CartProduct(cartProductCompositeKey,
				Integer.parseInt(quantity));
		
		cartService.saveProductInCart(cartProduct);
		
		return ResponseEntity.ok().body("New CartProduct has been saved with ID:");
	}
	
	//Incomplete
	@DeleteMapping( value = "/cartProduct/{cartId}" )
	public ResponseEntity<?> deleteProductsInCart(@PathVariable String cartId) {
		
		return ResponseEntity.ok().body("Products has been deleted.");
	}
}
