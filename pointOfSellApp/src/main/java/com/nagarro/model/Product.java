package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Column(name="product_name")
	private String productName;
	@Id
	@GeneratedValue
	@Column(name="prduct_id")
	private long productId;
	@Column(name="stock")
	private int stock;
	@Column(name="u_price")
	private double unitPrice;
	
	public Product() {
		
	}
	
	public Product(long productId) {
		this.productId = productId;
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
	public int getStock() {
		return stock;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
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
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}