package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	private Set<Cart_Product> cartProduct = new HashSet<>();
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	private Set<Order_Product> orderProduct = new HashSet<>();
	private String prductName;
	@Id
	@GeneratedValue
	private long productId;
	
	private long stock;
	
	private double unitPrice;
	
	public Product() {
		
	}

	/**
	 * @return the cartProduct
	 */
	public Set<Cart_Product> getCartProduct() {
		return cartProduct;
	}

	/**
	 * @return the orderProduct
	 */
	public Set<Order_Product> getOrderProduct() {
		return orderProduct;
	}

	/**
	 * @return the prductName
	 */
	public String getPrductName() {
		return prductName;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @return the stock
	 */
	public long getStock() {
		return stock;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param cartProduct the cartProduct to set
	 */
	public void setCartProduct(Set<Cart_Product> cartProduct) {
		this.cartProduct = cartProduct;
	}

	/**
	 * @param orderProduct the orderProduct to set
	 */
	public void setOrderProduct(Set<Order_Product> orderProduct) {
		this.orderProduct = orderProduct;
	}

	/**
	 * @param prductName the prductName to set
	 */
	public void setPrductName(String prductName) {
		this.prductName = prductName;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(long stock) {
		this.stock = stock;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}