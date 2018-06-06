/**
 * 
 */
package com.nagarro.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Cart;
import com.nagarro.model.CartProduct;
import com.nagarro.model.CartProductCompositeKey;
import com.nagarro.model.Customer;
import com.nagarro.model.OrderDetails;
import com.nagarro.model.OrderProduct;
import com.nagarro.model.Product;
import com.nagarro.utils.HibernateUtil;

@Repository("cartRepository")
public class CartRepositoryImpl implements CartRepository{

	@Autowired
	private HibernateUtil hibernateUtil;

	/*--- Method for saving cart object in Cart Table ---*/
	@Override
	public long save(Cart cart) {
		return (long) hibernateUtil.create(cart);
	}

	/*--- Method for updating product in cart ---*/
	@Override
	public void updateProductInCart(CartProduct cartProduct) {
		hibernateUtil.update(cartProduct);
		
	}

	/*--- Save product in cart ---*/
	@Override
	public CartProduct saveProductInCart(CartProduct cartProduct) {
		
		Session session = hibernateUtil.getCurrentSession();
		session.save(cartProduct);
		return hibernateUtil.fetchById(cartProduct.getCp(), CartProduct.class);

	}

	/*--- Delete Cart Details from CartProduct Table ---*/
	@Override
	public void deleteProductsInCart(long cartId) {
		
		Cart cart = new Cart(cartId);
		Session session = hibernateUtil.getCurrentSession();
		String deleteHql = "delete from CartProduct where cp.cart = :cart ";
		session.createQuery(deleteHql)
			   .setParameter("cart", cart)
			   .executeUpdate();
		
	}

	/*--- Get All Products by Cart ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<CartProduct> getAllCartProducts( long cartId ) {
		
		Cart cart = new Cart(cartId);
		Session session = hibernateUtil.getCurrentSession();
		String hql = "from CartProduct where cp.cart = :cart";
		return session.createQuery(hql)
					  .setParameter("cart", cart)
					  .list();

	}

	/*--- Get Cart By Customer Id ---*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getCartByCustId(long custId) {
		
		Session session = hibernateUtil.getCurrentSession();
		String hql = "from Cart where customer.customerId = :custId";
		return session.createQuery(hql)
					  .setParameter("custId", custId)
					  .list();
		
	}

	/*--- Delete one Product from CartProduct Table ---*/
	@Override
	public void deleteOneProduct(CartProduct cartProduct) {
		hibernateUtil.delete(cartProduct);
	}

	/*--- Get CartProduct By cart id and product id ---*/
	@Override
	public CartProduct getCartProduct(long cartId, long productId) {
		
		Cart cart = new Cart(cartId);
		Product product = new Product(productId);
		
		Session session = hibernateUtil.getCurrentSession();
		String hql = "from CartProduct where cp.cart = :cart and cp.product = :product";
		@SuppressWarnings("unchecked")
		List<CartProduct> list = session.createQuery(hql)
								.setParameter("cart", cart)
								.setParameter("product", product)
								.list();
		CartProduct cartProduct = list.get(0);
		return cartProduct;
		
	}

	/*--- Reload Cart ---*/
	@Override
	public void reloadCart(long orderId) {

		//Get OrderDetails By order id.
		OrderDetails orderdetails = hibernateUtil.fetchById(orderId, OrderDetails.class);
		//Get Customer from order details.
		Customer customer = orderdetails.getCustomer();
		//Get Cart By Customer.
		Session session = hibernateUtil.getCurrentSession();
		Cart cart = (Cart) session.createQuery("from Cart where customer = :customer")
								  .setParameter("customer", customer)
								  .list().get(0);
		
		String hql = "from OrderProduct where pk.orderDetails = :od";
		@SuppressWarnings("unchecked")
		List<OrderProduct> list = session.createQuery(hql)
										 .setParameter("od", orderdetails)
										 .list();
		//Add product list into cart.
		for (OrderProduct op : list) {
			Product product = op.getPk().getProduct();
			CartProductCompositeKey key = new CartProductCompositeKey(cart,product);
			CartProduct cart_product = (CartProduct) session.get(CartProduct.class, key);
			System.err.println("CartProduct: " + cart_product);
			//Check if product is already present in cart or not.
			int p_quantity = op.getQuantity();
			if( cart_product != null ) {
				p_quantity = p_quantity + cart_product.getQuantity();
			}
			//If stock is less than the selected quantity than reduce the quantity of product.
			if( product.getStock() < p_quantity )
				p_quantity = product.getStock();
			// If cart_product is already present update it else save it.
			if( cart_product != null ) {
				cart_product.setQuantity(p_quantity);
				hibernateUtil.update(cart_product);
			}
			else {
				CartProduct cartProduct = new CartProduct(key, p_quantity);
				session.save(cartProduct);
			}

		}
		// Delete entries from Cart.
		hql = "delete from OrderProduct where pk.orderDetails = :orderDetails";
		session.createQuery(hql)
		.setParameter("orderDetails", orderdetails).executeUpdate();
		// Delete order from OrderDetails.
		hql = "delete from OrderDetails where orderId = :orderId";
		session.createQuery(hql)
			   .setParameter("orderId", orderId)
			   .executeUpdate();
		
	}
	
	
}
