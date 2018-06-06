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
import com.nagarro.uri.ProductRestURIConstants;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	
	/*------------------------------ GET METHODS ---------------------------------*/
	
	
	/*--- Get all products ---*/
	@GetMapping( value = ProductRestURIConstants.GET_PRODUCT )
	public ResponseEntity<List<Product>> list() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok().body(products);
	}

	/*---Get a customer by search inputs ---*/
	@GetMapping( value = ProductRestURIConstants.GET_PRODUCT_BY_SEARCH_PARAMETER )
	public ResponseEntity<List<Product>> getProductBySearchParameter(@PathVariable("searchInput") String searchInput) {
		List<Product> proList = productService.getProductBySearchParameter(searchInput);
		return ResponseEntity.ok().body(proList);
	}
	
	/*------------------------------ POST METHODS --------------------------------*/
	
	
	/*--- Add a product ---*/
	@PostMapping( value = ProductRestURIConstants.POST_PRODUCT )
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		long id = productService.save(product);
	    return ResponseEntity.ok().body("New Product has been saved with ID:" + id);
	}
	
	
}
