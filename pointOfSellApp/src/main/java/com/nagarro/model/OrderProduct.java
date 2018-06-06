/**
 * 
 */
package com.nagarro.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
@AssociationOverrides({
	@AssociationOverride(name="pk.orderDetails", joinColumns = {
			@JoinColumn(name = "order_id")
	}),
	@AssociationOverride(name="pk.product", joinColumns = {
			@JoinColumn(name = "product_id")
	})
})
public class OrderProduct {

	@EmbeddedId
	private OrderProductCompositeKey pk;

	@Column( name="p_qty")
	private int quantity;
	
	public OrderProduct(OrderProductCompositeKey pk, int quantity ) {
		this.pk = pk;
		this.quantity = quantity;
	}
	
	public OrderProduct() {
		
	}

	/**
	 * @return the pk
	 */
	public OrderProductCompositeKey getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(OrderProductCompositeKey pk) {
		this.pk = pk;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
