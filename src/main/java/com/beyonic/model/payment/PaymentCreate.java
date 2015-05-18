package com.beyonic.model.payment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.beyonic.model.enums.PaymentTypeEnum;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class PaymentCreate {
	
	private String phonenumber; // must be in international format, eg - +256773712831
	private BigDecimal amount; // it can be in string or Integer, -- Do not include thousands separators like comma(,)
	// 3 letter ISO currency code. No currency conversion is done, so the currency must be valid for the selected phonenumber. You must have funded Beyonic an account in this currency. If your account for this currency has zero balance, your payment will fail.
	private String currency;
	// This description will be sent to the recipient along with the payment, so it should be limited to about 140 characters.
	private String description; 
	private PaymentTypeEnum payment_type = PaymentTypeEnum.money; // optional -- Options: money (default), airtime - use “airtime” to send an airtime payment instead of a mobile money payment
	private String callback_url; // optional --
	private Map<String, String> metadata;
	
	
	
	
	/**
	 * <p> Mandatory fields </p>
	 * @param phonenumber
	 * @param amount
	 * @param currency
	 * @param description
	 */
	public PaymentCreate(String phonenumber, BigDecimal amount, String currency, String description){
		this.phonenumber = phonenumber;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
	}
	
	/**
	 * <p>All fields</p>
	 * @param phonenumber
	 * @param amount
	 * @param currency
	 * @param description
	 * @param payment_type
	 * @param callback_url
	 */
	public PaymentCreate(String phonenumber, BigDecimal amount, String currency, String description, PaymentTypeEnum payment_type, String callback_url){
		this.phonenumber = phonenumber;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.payment_type = payment_type;
		this.callback_url = callback_url;
	}
	
	public boolean isValid(){
		
		if(this.phonenumber == null || this.amount == null || this.currency == null || this.description == null){
			return false;
		}
		if(this.description.length() > 140){
			return false;
		}
		
		return true;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PaymentTypeEnum getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(PaymentTypeEnum payment_type) {
		this.payment_type = payment_type;
	}
	public String getCallback_url() {
		return callback_url;
	}
	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	
	
}
