package com.beyonic.model.enums;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public enum WebhookEvents {
	
	payment_status_changed("payment.status.changed"),
	collection_received("collection.received");
	

	private String eventType;

	
	
	private WebhookEvents(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventType() {
		return eventType;
	}

	
	
	
	
}
