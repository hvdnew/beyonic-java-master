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
public class CollectionRequest{

	public static final Gson GSON = new GsonBuilder().create();
	public static final String COLLECTIONREQUEST_API_ENDPOINT = BeyonicConstants.BASE_URL+BeyonicConstants.getVersion()+"/collectionrequests";
	
	
	private long id;
	private String organizaation;
	private String currency;
	private String phone_number;
	private String created;
	private String author;
	private String modified;
	private String updated_by;
	
	
	
	public static CollectionRequest create(Map<String, Object> params ) throws APIConnectionException, AuthenticationException, InvalidRequestException {

		RequestOptions options = RequestOptions.getDefault();
		options.setParams(params);
		System.out.println("params: "+options.getParams());
		
		
		String url = COLLECTIONREQUEST_API_ENDPOINT;
		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.POST, url, options);
		
		System.out.println("response: "+response);
		
		CollectionRequest colReq = null;
	    Type stringStringMap = new TypeToken<CollectionRequest>() {}.getType();
	    colReq = GSON.fromJson(response, stringStringMap);
		

		return colReq;
	}
	
	public static CollectionRequest create(String phonenumber, BigDecimal amount,
			String currency) throws APIConnectionException, AuthenticationException, InvalidRequestException {

		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phonenumber", phonenumber);
		params.put("amount", amount+"");
		params.put("currency", currency);
		

		return create(params);
	}

	
	public static CollectionRequest read(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		RequestOptions options = RequestOptions.getDefault();
		
		
		String url = COLLECTIONREQUEST_API_ENDPOINT+"/"+id;
		
		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.GET, url, options);
		
		System.out.println("response: "+response);
		
		CollectionRequest colReq = null;
	    Type stringStringMap = new TypeToken<CollectionRequest>() {}.getType();
	    colReq = GSON.fromJson(response, stringStringMap);
		

		return colReq;
	}

	
	
	public static List<CollectionRequest> list() throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		RequestOptions options = RequestOptions.getDefault();
		
		
		String url = COLLECTIONREQUEST_API_ENDPOINT;
		
		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.GET, url, options);
		
		System.out.println("response: "+response);
		
		List<CollectionRequest> toRet = null;
	    Type stringStringMap = new TypeToken<List<CollectionRequest>>() {}.getType();
	    toRet = GSON.fromJson(response, stringStringMap);
		
		return toRet;
	}

	
	
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
