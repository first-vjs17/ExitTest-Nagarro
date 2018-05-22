/**
 * 
 */
package com.nagarro.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author vijaysharma01
 *
 */
@Embeddable
public class CartProductCompositeKey implements Serializable{

	private long cartKey;
	private long productKey;
	
	public CartProductCompositeKey() {
	}
	
	public CartProductCompositeKey(long cartId, long productId) {
		this.cartKey = cartId;
		this.productKey = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productKey, cartKey);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}