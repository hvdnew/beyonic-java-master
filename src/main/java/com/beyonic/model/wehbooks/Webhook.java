package com.beyonic.model.wehbooks;

import com.beyonic.model.enums.WebhookEvents;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class Webhook {

	private long id;
	private String created;
	private String updated;
	private String user;
	private WebhookEvents event;
	private String target;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public WebhookEvents getEvent() {
		return event;
	}
	public void setEvent(WebhookEvents event) {
		this.event = event;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
}
