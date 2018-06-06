/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Product;
import com.nagarro.utils.CheckNumericUtils;
import com.nagarro.utils.HibernateUtil;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository{
	
	@Autowired
	private HibernateUtil hibernateUtil;
	
	/*--- Get products list ---*/
	@Override
	public List<Product> getAllProducts() {
		return hibernateUtil.fetchAll(Product.class);
	}

	/*--- Save Product ---*/
	@Override
	public long save(Product product) {
		return (Long) hibernateUtil.create(product);
	}

	/*--- Get Product By id ---*/
	@Override
	public Product getProductById(long productId) {
		return hibernateUtil.fetchById(productId, Product.class);
	}

	/*--- Get Product By Search Parameters ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductBySearchParameter(String searchInput) {

		//Get the current session.
		Session session = hibernateUtil.getCurrentSession();
		List<Product> productList;
		// Check if search parameters is numeric, it may be product id.
		if( CheckNumericUtils.isNumeric(searchInput) ) {
			long id = Long.parseLong(searchInput);
			String hql = "select p from Product as p where p.productId = :proId ";
			productList = session.createQuery(hql)
							  	 .setParameter("proId", id)
							  	 .list();
			return productList;
		}
		
		// Check products by its name. 
		String hql = "select p from Product as p where p.productName like :proName ";
		productList = session.createQuery(hql)
						 	 .setParameter("proName", searchInput+"%")
						 	 .list();
		
		// return searched products.
		return productList;
		
	}

}
