package com.nagarro.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductCompositeKey implements Serializable{

	private long orderKey;
	private long productKey;
	
	public OrderProductCompositeKey() {
		
	}
	
	public OrderProductCompositeKey(long orderId, long productId) {
		this.orderKey = orderId;
		this.productKey = productId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(orderKey, productKey);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
