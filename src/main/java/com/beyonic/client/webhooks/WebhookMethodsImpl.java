package com.beyonic.client.webhooks;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.enums.WebhookEvents;
import com.beyonic.model.payment.PaymentResponse;
import com.beyonic.model.wehbooks.Webhook;
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
public class WebhookMethodsImpl implements WebhookMethods {

	public static final Gson GSON = new GsonBuilder().create();
	
	@Override
	public Webhook create(WebhookEvents event, String target) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		RequestOptions options = RequestOptions.getDefault();
		
		Map<String, String> params	= new HashMap<String, String>();
		params.put("event", event.getEventType());
		params.put("target", target);

		options.setParams(params);
		
		String url = WEBHOOK_API_ENDPOINT;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.POST, url, options);
		
		System.out.println("response: "+response);
		
		Webhook webhook = null;
	    Type stringStringMap = new TypeToken<Webhook>() {}.getType();
	    webhook = GSON.fromJson(response, stringStringMap);
		

		return webhook;
	}

	@Override
	public Webhook read(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		RequestOptions options = RequestOptions.getDefault();
		
		String url = WEBHOOK_API_ENDPOINT+"/"+id;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.GET, url, options);
		
		System.out.println("response: "+response);
		
		Webhook webhook = null;
	    Type stringStringMap = new TypeToken<Webhook>() {}.getType();
	    webhook = GSON.fromJson(response, stringStringMap);
		

		return webhook;
	}

	@Override
	public List<Webhook> list() throws APIConnectionException, AuthenticationException, InvalidRequestException {
		RequestOptions options = RequestOptions.getDefault();
		
		String url = WEBHOOK_API_ENDPOINT;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.GET, url, options);
		
		System.out.println("response: "+response);
		
		List<Webhook> toRet = null;
	    Type stringStringMap = new TypeToken<List<Webhook>>() {}.getType();
	    toRet = GSON.fromJson(response, stringStringMap);
		

		return toRet;
	}

	@Override
	public void delete(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		RequestOptions options = RequestOptions.getDefault();
		
		String url = WEBHOOK_API_ENDPOINT+"/"+id;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.DELETE, url, options);
		
		System.out.println("response: "+response);
		
	}

	@Override
	public Webhook update(String id, WebhookEvents event, String target) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		Map<String, String> params	= new HashMap<String, String>();
		params.put("event", event.getEventType());
		params.put("target", target);
		
		RequestOptions options = RequestOptions.getDefault();
		
		options.setParams(params);
		String url = WEBHOOK_API_ENDPOINT+"/"+id;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.PUT, url, options);
		
		System.out.println("response: "+response);
		
		Webhook webhook = null;
	    Type stringStringMap = new TypeToken<Webhook>() {}.getType();
	    webhook = GSON.fromJson(response, stringStringMap);
		

		return webhook;
	}

	
	public static void main(String[] args) throws APIConnectionException, AuthenticationException, InvalidRequestException{
		
		WebhookMethodsImpl webhookMethodsImpl = new WebhookMethodsImpl();
		
		//webhookMethodsImpl.create(WebhookEvents.payment_status_changed, "https://www.harsh.com");
		
		//webhookMethodsImpl.read("76");
		
		//List<Webhook> toRet = webhookMethodsImpl.list();
		//System.out.println(toRet.size());
		
		//webhookMethodsImpl.delete("49");
		
		//webhookMethodsImpl.update("53", WebhookEvents.collection_received, "https://www.harshvardhan.com");
		
		
		
	}
	
	
}
