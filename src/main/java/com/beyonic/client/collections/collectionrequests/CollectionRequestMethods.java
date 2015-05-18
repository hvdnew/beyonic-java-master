package com.beyonic.client.collections.collectionrequests;

import java.math.BigDecimal;
import java.util.List;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.collectionrequests.CollectionRequest;
import com.beyonic.model.collections.CollectionResponse;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public interface CollectionRequestMethods {
	
	public static final String COLLECTIONREQUEST_API_ENDPOINT = "https://staging.beyonic.com/api/collectionrequests";
	
	
	public CollectionRequest create(String phonenumber, BigDecimal amount,
			String currency) throws APIConnectionException, AuthenticationException, InvalidRequestException;
	public CollectionRequest read(String id) throws APIConnectionException, AuthenticationException, InvalidRequestException;
	public List<CollectionRequest> list() throws APIConnectionException, AuthenticationException, InvalidRequestException;

}
