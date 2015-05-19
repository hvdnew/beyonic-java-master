package com.beyonic.client.webhooks;

import java.util.List;
import java.util.Map;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.enums.WebhookEvents;
import com.beyonic.model.webhooks.Webhook;
import com.beyonic.util.BeyonicConstants;


/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public interface WebhookMethods {
	public static final String WEBHOOK_API_ENDPOINT = BeyonicConstants.BASE_URL+BeyonicConstants.getVersion()+"/webhooks";
	
	
	public Webhook create(WebhookEvents event, String target) throws APIConnectionException, AuthenticationException, InvalidRequestException;
	
	public Webhook read(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException;
	
	public List<Webhook> list() throws APIConnectionException, AuthenticationException, InvalidRequestException;
	
	public void delete(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException;
	
	public Webhook update(String id, WebhookEvents event, String target) throws APIConnectionException, AuthenticationException, InvalidRequestException;
	
	
	
}
