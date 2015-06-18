package com.beyonic.model;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
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
public class Collection {

	public static final String COLLECTIONS_API_ENDPOINT = BeyonicConstants.BASE_URL+BeyonicConstants.getVersion()+"/collections";
	public static final Gson GSON = new GsonBuilder().create();
	
	private long id;
	private String phonenumber;
	private String remote_transaction_id;
	private String payment_date;
	private String reference;
	private BigDecimal amount;
	private String currency;
	private String status;
	
	
	public static Collection read(String id) {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT+"/"+id;

		String response = null;
		Collection collection = null;
		
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<Collection>() {}.getType();
		    collection = GSON.fromJson(response, stringStringMap);
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		

		return collection;
	}

	
	public static List<Collection> list() {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;

		String response = null;
		List<Collection> toRet  = null;
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			
			System.out.println("Response: " + response);
		    Type stringStringMap = new TypeToken<List<Collection>>() {}.getType();
		    toRet = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
			toRet = null;
		}
		
		
		
		return toRet;
	}


	
	public static List<Collection> search(Map<String, Object> params) {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;
		
		options.setParams(params);
		List<Collection> toRet = null;
		
		String response = null;
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<List<Collection>>() {}.getType();
		    toRet = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		

		return toRet;
	}
	
	
	public static List<Collection> search(String phonenumber,
			String remote_transaction_id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phonenumber", phonenumber);
		params.put("remote_transaction_id", remote_transaction_id);

		return search(params);
	}

	
	
	public static List<Collection> claim(Map<String, Object> params) {
		
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;
		
		options.setParams(params);
		
		
		String response = null;
		List<Collection> toRet = null;
		
		
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<List<Collection>>() {}.getType();
		    toRet = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		

		return toRet;
	}

	public static List<Collection> claim(String phonenumber,
			String remote_transaction_id, boolean claim, BigDecimal amount) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phonenumber", phonenumber);
		params.put("remote_transaction_id", remote_transaction_id);
		params.put("claim", claim+"");
		params.put("amount", amount+"");

		return claim(params);
	}
	
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
