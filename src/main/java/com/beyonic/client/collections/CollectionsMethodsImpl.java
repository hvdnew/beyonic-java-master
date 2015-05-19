package com.beyonic.client.collections;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.collections.CollectionResponse;
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
public class CollectionsMethodsImpl implements CollectionsMethods {


	public static final Gson GSON = new GsonBuilder().create();
	
	
	@Override
	public CollectionResponse read(String id) {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT+"/"+id;

		String response = null;
		CollectionResponse collection = null;
		
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<CollectionResponse>() {}.getType();
		    collection = GSON.fromJson(response, stringStringMap);
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		

		return collection;
	}

	@Override
	public List<CollectionResponse> list() {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;

		String response = null;
		List<CollectionResponse> toRet  = null;
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			
			System.out.println("Response: " + response);
		    Type stringStringMap = new TypeToken<List<CollectionResponse>>() {}.getType();
		    toRet = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
			toRet = null;
		}
		
		
		
		return toRet;
	}


	@Override
	public List<CollectionResponse> search(String phonenumber,
			String remote_transaction_id) {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;

		Map<String, String> params = new HashMap<String, String>();
		params.put("phonenumber", phonenumber);
		params.put("remote_transaction_id", remote_transaction_id);
		
		options.setParams(params);
		List<CollectionResponse> toRet = null;
		
		String response = null;
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<List<CollectionResponse>>() {}.getType();
		    toRet = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		
		

		return toRet;
	}

	
	@Override
	public List<CollectionResponse> claim(String phonenumber,
			String remote_transaction_id, boolean claim, BigDecimal amount) {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;

		Map<String, String> params = new HashMap<String, String>();
		params.put("phonenumber", phonenumber);
		params.put("remote_transaction_id", remote_transaction_id);
		params.put("claim", claim+"");
		params.put("amount", amount+"");
		
		options.setParams(params);
		
		
		String response = null;
		List<CollectionResponse> toRet = null;
		
		
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<List<CollectionResponse>>() {}.getType();
		    toRet = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		
		

		return toRet;
	}

	
	
}
