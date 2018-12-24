package com.gayathri.event;

import org.springframework.context.ApplicationEvent;

import com.gayathri.spring.model.Product;

public class ProductEvent  extends ApplicationEvent{
	
	private String eventType;
	private Product product;

	@Override
	public String toString() {
		return "ProductEvent [eventType=" + eventType + ", product=" + product + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductEvent(Object source) {
		super(source);
		
	}
	
	public ProductEvent(Object source,String eventType, Product product) {
		super(source);
		this.eventType =  eventType;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
