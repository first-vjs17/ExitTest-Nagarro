/**
 * 
 */
package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProductCompositeKey;
import com.nagarro.model.Cart_Product;
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

		CartProductCompositeKey cartProductCompositeKey = 
				new CartProductCompositeKey(Long.parseLong(cartId),Long.parseLong(productId));
		Cart_Product cartProduct = new Cart_Product(cartProductCompositeKey,
				Integer.parseInt(quantity));
		
		cartService.saveProductInCart(cartProduct);
		
		return ResponseEntity.ok().body("New CartProduct has been saved with ID:");
	}
}
