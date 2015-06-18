package com.beyonic.model;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.enums.WebhookEvents;
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
public class Webhook {

	public static final Gson GSON = new GsonBuilder().create();
	public static final String WEBHOOK_API_ENDPOINT = BeyonicConstants.BASE_URL+BeyonicConstants.getVersion()+"/webhooks";
	
	private long id;
	private String created;
	private String updated;
	private String user;
	private WebhookEvents event;
	private String target;
	
	
	public static Webhook create(String event, String target) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		RequestOptions options = RequestOptions.getDefault();
		
		Map<String, Object> params	= new HashMap<String, Object>();
		params.put("event", event);
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

	
	public static Webhook read(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
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

	
	public static List<Webhook> list() throws APIConnectionException, AuthenticationException, InvalidRequestException {
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

	
	public static void delete(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		RequestOptions options = RequestOptions.getDefault();
		
		String url = WEBHOOK_API_ENDPOINT+"/"+id;

		String response = ConnectionUtil.request(
				ConnectionUtil.RequestMethod.DELETE, url, options);
		
		System.out.println("response: "+response);
		
	}

	
	public static Webhook update(String id, WebhookEvents event, String target) throws APIConnectionException, AuthenticationException, InvalidRequestException {
		
		Map<String, Object> params	= new HashMap<String, Object>();
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

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public WebhookEvents getEvent() {
		return event;
	}
	public void setEvent(WebhookEvents event) {
		this.event = event;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
}
