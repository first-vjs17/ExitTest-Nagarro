/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Employee;
import com.nagarro.model.Product;
import com.nagarro.utils.HibernateUtil;

/**
 * @author vijaysharma01
 *
 */
@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository{
	
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public List<Product> getAllProducts() {
		return hibernateUtil.fetchAll(Product.class);
	}

	@Override
	public long save(Product product) {
		return (Long) hibernateUtil.create(product);
	}

	@Override
	public Product getProductById(long productId) {
		return hibernateUtil.fetchById(productId, Product.class);
	}

}
