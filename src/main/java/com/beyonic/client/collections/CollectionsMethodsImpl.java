package com.beyonic.client.collections;

import java.lang.reflect.Type;
import java.math.BigDecimal;
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

public class CollectionsMethodsImpl implements CollectionsMethods {


	public static final Gson GSON = new GsonBuilder().create();
	
	
	@Override
	public CollectionResponse read(String id) {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT+"/"+id;

		String response = null;
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		System.out.println("Response: " + response);
		
		CollectionResponse collection = null;
	    Type stringStringMap = new TypeToken<CollectionResponse>() {}.getType();
	    collection = GSON.fromJson(response, stringStringMap);
		

		return collection;
	}

	@Override
	public List<CollectionResponse> list() {
		RequestOptions options = RequestOptions.getDefault();

		String url = COLLECTIONS_API_ENDPOINT;

		String response = null;
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		System.out.println("Response: " + response);
		
		List<CollectionResponse> toRet  = null;
	    Type stringStringMap = new TypeToken<List<CollectionResponse>>() {}.getType();
	    toRet = GSON.fromJson(response, stringStringMap);
		
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
		
		
		String response = null;
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		System.out.println("Response: " + response);
		
		List<CollectionResponse> toRet = null;
	    Type stringStringMap = new TypeToken<List<CollectionResponse>>() {}.getType();
	    toRet = GSON.fromJson(response, stringStringMap);
		

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
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		System.out.println("Response: " + response);
		
		List<CollectionResponse> toRet = null;
	    Type stringStringMap = new TypeToken<List<CollectionResponse>>() {}.getType();
	    toRet = GSON.fromJson(response, stringStringMap);
		

		return toRet;
	}

	
	

	
	
	public static void main(String[] args){
		
		CollectionsMethodsImpl collectionsMethodsImpl = new CollectionsMethodsImpl();
		//collectionsMethodsImpl.read("2");
		
		//List<CollectionResponse> resp = collectionsMethodsImpl.list();
		//System.out.println(resp.size());
		
		
		//List<CollectionResponse> resp = collectionsMethodsImpl.search("+254727843600", "12132");
		//System.out.println(resp.size());
		
		
		List<CollectionResponse> resp = collectionsMethodsImpl.claim("+254727843600", "12132", true, new BigDecimal(5.0));
		System.out.println(resp.size());
		
		
	}

	
	
}
