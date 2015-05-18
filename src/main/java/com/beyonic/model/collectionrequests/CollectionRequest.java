package com.beyonic.model.collectionrequests;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class CollectionRequest {

	private long id;
	private String organizaation;
	private String currency;
	private String phone_number;
	private String created;
	private String author;
	private String modified;
	private String updated_by;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrganizaation() {
		return organizaation;
	}
	public void setOrganizaation(String organizaation) {
		this.organizaation = organizaation;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	
	
}
