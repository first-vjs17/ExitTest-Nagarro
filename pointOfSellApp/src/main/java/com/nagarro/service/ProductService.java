/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Product;

public interface ProductService {

	long save( Product product );
	
	List<Product> getAllProducts();
	
	Product getProductById(long productId);

	List<Product> getProductBySearchParameter(String searchInput);
	
}
