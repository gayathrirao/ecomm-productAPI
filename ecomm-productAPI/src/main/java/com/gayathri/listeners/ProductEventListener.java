package com.gayathri.listeners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.gayathri.event.ProductEvent;

@Component
public class ProductEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(ProductEvent productEvent) {
		log.info("Received Product Event : "+productEvent.getEventType());
		log.info("Received Product From Product Event :"+productEvent.getProduct().toString());
	}
}