package com.beyonic.client.payment;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.payment.PaymentCreate;
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
public class PaymentsMethodsImpl implements PaymentsMethods {

	public static final Gson GSON = new GsonBuilder().create();


	@Override
	public PaymentResponse create(PaymentCreate paymentInput)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException {

		RequestOptions options = RequestOptions.getDefault();
		
		options.setParams(BeyonicConstants.getAsParams(paymentInput));
		
		System.out.println("params: "+options.getParams());

		String url = PAYMENT_API_ENDPOINT;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.POST, url, options);
		
		System.out.println("response: "+response);
		
		PaymentResponse payment = null;
	    Type stringStringMap = new TypeToken<PaymentResponse>() {}.getType();
	    payment = GSON.fromJson(response, stringStringMap);
		

		return payment;

	}

	/**
	 * 
	 */
	@Override
	public PaymentResponse read(String id) {
		
		RequestOptions options = RequestOptions.getDefault();

		String url = PAYMENT_API_ENDPOINT+"/"+id;
		String response = null;
		PaymentResponse payment = null;
		
		
		try {
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET,
					url, options);
			System.out.println("Response: " + response);
			
		    Type stringStringMap = new TypeToken<PaymentResponse>() {}.getType();
		    payment = GSON.fromJson(response, stringStringMap);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		
		

		return payment;

	}

	/**
	 * @author Harshvardhan Dadhich
	 * 
	 */
	@Override
	public List<PaymentResponse> list() {
		
		RequestOptions options = RequestOptions.getDefault();
		
		String url = PAYMENT_API_ENDPOINT;
		
		String response = null;
		List<PaymentResponse> paymentList = null;
		try {
			
			response = ConnectionUtil.request(ConnectionUtil.RequestMethod.GET, url, options);
			
			System.out.println("Response: "+response);
			
			
		    Type stringStringMap = new TypeToken<List<PaymentResponse>>() {}.getType();
		    paymentList = GSON.fromJson(response, stringStringMap);
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		}
		
		
		return paymentList;
	}


}
