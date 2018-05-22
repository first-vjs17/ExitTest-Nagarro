/**
 * 
 */
package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Product;
import com.nagarro.service.ProductService;

/**
 * @author vijaysharma01
 *
 */
@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/*--- Add a product ---*/
	@PostMapping( value = "/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		long id = productService.save(product);
	    return ResponseEntity.ok().body("New Product has been saved with ID:" + id);
	}
	
	/*--- Get all products ---*/
	@GetMapping( value = "/product" )
	public ResponseEntity<List<Product>> list() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok().body(products);
	}
	
	/*---Get a product by id---*/
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getByID(@PathVariable("id") long id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok().body(product);
	}
}
