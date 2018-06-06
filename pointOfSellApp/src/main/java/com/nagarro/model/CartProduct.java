/**
 * 
 */
package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cart_product")
@AssociationOverrides({
	@AssociationOverride(name="cp.cart", joinColumns = {
			@JoinColumn(name = "cart_id")
	}),
	@AssociationOverride(name="cp.product", joinColumns = {
			@JoinColumn(name = "product_id")
	})
})
public class CartProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6647467153298091996L;

	@EmbeddedId
	private CartProductCompositeKey cp;

	/**
	 * @return the cp
	 */
	public CartProductCompositeKey getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(CartProductCompositeKey cp) {
		this.cp = cp;
	}

	@Column(name = "p_qty")
	private int quantity;
	
	public CartProduct( ) {
		
	}
	
	public CartProduct(CartProductCompositeKey cp) {
		this.cp = cp;
	}

	public CartProduct(CartProductCompositeKey cp, int quantity) {
		this.cp = cp;
		this.quantity = quantity;
	}

	public CartProduct(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
