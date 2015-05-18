package com.beyonic.model.collections;

import java.math.BigDecimal;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class CollectionResponse {

	private long id;
	private String phonenumber;
	private String remote_transaction_id;
	private String payment_date;
	private String reference;
	private BigDecimal amount;
	private String currency;
	private String status;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRemote_transaction_id() {
		return remote_transaction_id;
	}
	public void setRemote_transaction_id(String remote_transaction_id) {
		this.remote_transaction_id = remote_transaction_id;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
