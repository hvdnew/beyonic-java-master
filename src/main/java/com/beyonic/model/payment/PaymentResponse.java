package com.beyonic.model.payment;

import java.awt.List;
import java.math.BigDecimal;
import java.util.HashMap;

import com.beyonic.model.enums.BeyonicRespStateEnum;
import com.beyonic.model.enums.PaymentTypeEnum;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class PaymentResponse {

	private long id;
	private String organization;
	private BigDecimal amount;
	private String currency;
	private PaymentTypeEnum payment_type;
	private Object metadata; //  {"id": 1234, "name": "Lucy"} // write logic to convert it into HashMap<String, String>
	private String[] phone_nos;
	private BeyonicRespStateEnum state;
	private String last_error;
	private String rejected_reason;
	private String rejected_by;
	private String rejected_time;
	private String cancelled_reason;
	private String cancelled_by;
	private String cancelled_time;
	private String created;//2014-11-22T20:57:04.017Z
	private String author;
	private String modified;
	private String updated_by;
	private String start_date;
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public PaymentTypeEnum getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(PaymentTypeEnum payment_type) {
		this.payment_type = payment_type;
	}
	public Object getMetadata() {
		return metadata;
	}
	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}
	public String[] getPhone_nos() {
		return phone_nos;
	}
	public void setPhone_nos(String[] phone_nos) {
		this.phone_nos = phone_nos;
	}
	public BeyonicRespStateEnum getState() {
		return state;
	}
	public void setState(BeyonicRespStateEnum state) {
		this.state = state;
	}
	public String getLast_error() {
		return last_error;
	}
	public void setLast_error(String last_error) {
		this.last_error = last_error;
	}
	public String getRejected_reason() {
		return rejected_reason;
	}
	public void setRejected_reason(String rejected_reason) {
		this.rejected_reason = rejected_reason;
	}
	public String getRejected_by() {
		return rejected_by;
	}
	public void setRejected_by(String rejected_by) {
		this.rejected_by = rejected_by;
	}
	public String getRejected_time() {
		return rejected_time;
	}
	public void setRejected_time(String rejected_time) {
		this.rejected_time = rejected_time;
	}
	public String getCancelled_reason() {
		return cancelled_reason;
	}
	public void setCancelled_reason(String cancelled_reason) {
		this.cancelled_reason = cancelled_reason;
	}
	public String getCancelled_by() {
		return cancelled_by;
	}
	public void setCancelled_by(String cancelled_by) {
		this.cancelled_by = cancelled_by;
	}
	public String getCancelled_time() {
		return cancelled_time;
	}
	public void setCancelled_time(String cancelled_time) {
		this.cancelled_time = cancelled_time;
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	
	
	
	
	
	
	
	
	
}
