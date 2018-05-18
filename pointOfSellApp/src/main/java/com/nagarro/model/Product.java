package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long productId;
	private String prductName;
	private long stock;
	private double unitPrice;
	
	@OneToMany(mappedBy="product")
	private Set<Order_Product> orderProduct = new HashSet<>();
	
	@OneToMany(mappedBy="product")
	private Set<Cart_Product> cartProduct = new HashSet<>();
	
	/**
	 * @return the orderProduct
	 */
	public Set<Order_Product> getOrderProduct() {
		return orderProduct;
	}

	/**
	 * @param orderProduct the orderProduct to set
	 */
	public void setOrderProduct(Set<Order_Product> orderProduct) {
		this.orderProduct = orderProduct;
	}

	/**
	 * @return the cartProduct
	 */
	public Set<Cart_Product> getCartProduct() {
		return cartProduct;
	}

	/**
	 * @param cartProduct the cartProduct to set
	 */
	public void setCartProduct(Set<Cart_Product> cartProduct) {
		this.cartProduct = cartProduct;
	}

	public Product() {
		
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the prductName
	 */
	public String getPrductName() {
		return prductName;
	}

	/**
	 * @param prductName the prductName to set
	 */
	public void setPrductName(String prductName) {
		this.prductName = prductName;
	}

	/**
	 * @return the stock
	 */
	public long getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(long stock) {
		this.stock = stock;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
