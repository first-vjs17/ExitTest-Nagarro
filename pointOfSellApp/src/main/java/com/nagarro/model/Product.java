package com.nagarro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@OneToMany(mappedBy="pk.product",fetch=FetchType.EAGER)
	private Set<CartProduct> cartProduct = new HashSet<>();
	@OneToMany(mappedBy="product",fetch=FetchType.EAGER)
	private Set<Order_Product> orderProduct = new HashSet<>();
	private String productName;
	@Id
	@GeneratedValue
	private long productId;
	
	private long stock;
	
	private double unitPrice;
	
	public Product() {
		
	}
	
	public Product(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the cartProduct
	 */
	public Set<CartProduct> getCartProduct() {
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
	public String getProductName() {
		return productName;
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
	public void setCartProduct(Set<CartProduct> cartProduct) {
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
	public void setProductName(String prductName) {
		this.productName = prductName;
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