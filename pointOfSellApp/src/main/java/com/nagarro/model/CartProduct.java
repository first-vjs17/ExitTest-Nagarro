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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author vijaysharma01
 *
 */
@Entity
@Table(name="cart_product")
@AssociationOverrides({
	@AssociationOverride(name="pk.cart", joinColumns = {
			@JoinColumn(name = "cart_id")
	}),
	@AssociationOverride(name="pk.product", joinColumns = {
			@JoinColumn(name = "product_id")
	})
})
public class CartProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6647467153298091996L;

	@EmbeddedId
	private CartProductCompositeKey pk =
			new CartProductCompositeKey();

	@Column(name = "p_qty")
	private int quantity;
	
	public CartProduct( ) {
		
	}

	public CartProduct(CartProductCompositeKey pk, int quantity) {
		this.pk = pk;
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
