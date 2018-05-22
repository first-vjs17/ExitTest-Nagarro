/**
 * 
 */
package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.OrderDetails;
import com.nagarro.model.Product;
import com.nagarro.service.OrderDetailsService;

/**
 * @author vijaysharma01
 *
 */
@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;
	
	/*--- Add an Order ---*/
	@PostMapping( value = "/orderDetails")
	public ResponseEntity<?> addProduct(@RequestBody OrderDetails orderDetails) {
		long id = orderDetailsService.save(orderDetails);
	    return ResponseEntity.ok().body("New Order has been saved with ID:" + id);
	}
}
