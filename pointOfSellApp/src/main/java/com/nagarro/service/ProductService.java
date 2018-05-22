/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Product;

/**
 * @author vijaysharma01
 *
 */

public interface ProductService {

	long save( Product product );
	List<Product> getAllProducts();
	Product getProductById(long productId);
}
