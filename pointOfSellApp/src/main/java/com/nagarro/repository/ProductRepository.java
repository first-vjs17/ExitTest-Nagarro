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

	public long createProduct(Product product);
	public List<Product> getAllProducts();
}
