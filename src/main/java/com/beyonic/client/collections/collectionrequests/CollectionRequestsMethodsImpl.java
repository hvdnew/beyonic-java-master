package com.beyonic.client.collections.collectionrequests;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.client.collections.CollectionsMethodsImpl;
import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.collectionrequests.CollectionRequest;
import com.beyonic.model.payment.PaymentResponse;
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
public class CollectionRequestsMethodsImpl implements CollectionRequestMethods{

	public static final Gson GSON = new GsonBuilder().create();
	
	@Override
	public CollectionRequest create(String phonenumber, BigDecimal amount,
			String currency) throws APIConnectionException, AuthenticationException, InvalidRequestException {

		Map<String, String> params = new HashMap<String, String>();
		params.put("phonenumber", phonenumber);
		params.put("amount", amount+"");
		params.put("currency", currency);
		
		
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

	@Override
	public CollectionRequest read(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException {
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

	
	@Override
	public List<CollectionRequest> list() throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
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

	
	
}
