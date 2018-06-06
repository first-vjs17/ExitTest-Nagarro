/**
 * 
 */
package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Product;
import com.nagarro.repository.ProductRepository;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public long save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(long productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public List<Product> getProductBySearchParameter(String searchInput) {
		return productRepository.getProductBySearchParameter(searchInput);
	}

}
