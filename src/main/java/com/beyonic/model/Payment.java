package com.beyonic.model;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.enums.BeyonicRespStateEnum;
import com.beyonic.model.enums.PaymentTypeEnum;
import com.beyonic.util.BeyonicConstants;
import com.beyonic.util.ConnectionUtil;
import com.beyonic.util.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class Payment{

	public static final Gson GSON = new GsonBuilder().create();
	public static final String PAYMENT_API_ENDPOINT = BeyonicConstants.BASE_URL+BeyonicConstants.getVersion()+"/payments";
	
	
	// request
	private String phonenumber; // must be in international format, eg - +256773712831
	// This description will be sent to the recipient along with the payment, so it should be limited to about 140 characters.
	private String description; 
	private String callback_url; // optional --
		
		
		
	// common 
	private Object metadata; //  {"id": 1234, "name": "Lucy"} // write logic to convert it into HashMap<String, String>
	private PaymentTypeEnum payment_type = PaymentTypeEnum.money; // optional -- Options: money (default), airtime - use “airtime” to send an airtime payment instead of a mobile money payment
	// 3 letter ISO currency code. No currency conversion is done, so the currency must be valid for the selected phonenumber. You must have funded Beyonic an account in this currency. If your account for this currency has zero balance, your payment will fail.
	private String currency;
	private BigDecimal amount; // it can be in string or Integer, -- Do not include thousands separators like comma(,)
		
		
	// response
	private long id;
	private String organization;
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
	
	

	public static Payment create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException {

		RequestOptions options = RequestOptions.getDefault();
		options.setParams(params);
		
		System.out.println("params: "+options.getParams());

		String url = PAYMENT_API_ENDPOINT;
		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.POST, url, options);
		
		System.out.println("response: "+response);
		Payment payment = null;
	    Type stringStringMap = new TypeToken<Payment>() {}.getType();
	    payment = GSON.fromJson(response, stringStringMap);

		return payment;

	}
	

	
	public static Payment read(String id) {
		
		RequestOptions options = RequestOptions.getDefault();

		String url = PAYMENT_API_ENDPOINT+"/"+id;
		String response = null;
		Payment payment = null;
		
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<Payment>() {}.getType();
		    payment = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		
		

		return payment;

	}

	
	public static List<Payment> list() {
		
		RequestOptions options = RequestOptions.getDefault();
		
		String url = PAYMENT_API_ENDPOINT;
		
		String response = null;
		List<Payment> paymentList = null;
		try {
			
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET, url, options);
			
			System.out.println("Response: "+response);
			
			
		    Type stringStringMap = new TypeToken<List<Payment>>() {}.getType();
		    paymentList = GSON.fromJson(response, stringStringMap);
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		
		
		return paymentList;
	}
	
	
	
	/**
	 * <p> Mandatory fields </p>
	 * @param phonenumber
	 * @param amount
	 * @param currency
	 * @param description
	 */
	public Payment(String phonenumber, BigDecimal amount, String currency, String description){
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
	public Payment(String phonenumber, BigDecimal amount, String currency, String description, PaymentTypeEnum payment_type, String callback_url){
		this.phonenumber = phonenumber;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.payment_type = payment_type;
		this.callback_url = callback_url;
	}
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public boolean isValidCrtObj(){
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public Object getMetadata() {
		return metadata;
	}

	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

	public PaymentTypeEnum getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(PaymentTypeEnum payment_type) {
		this.payment_type = payment_type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

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
