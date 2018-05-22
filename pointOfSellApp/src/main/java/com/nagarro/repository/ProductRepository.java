/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.Product;

/**
 * @author vijaysharma01
 *
 */
public interface ProductRepository {

	long save( Product product );
	List<Product> getAllProducts();
	Product getProductById(long productId);
}
