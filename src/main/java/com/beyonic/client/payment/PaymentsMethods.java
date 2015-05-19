package com.beyonic.client.payment;

import java.util.List;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.payment.PaymentCreate;
import com.beyonic.model.payment.PaymentResponse;
import com.beyonic.util.BeyonicConstants;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public interface PaymentsMethods {
	
	public static final String PAYMENT_API_ENDPOINT = BeyonicConstants.BASE_URL+BeyonicConstants.getVersion()+"/payments";
	
	
	public PaymentResponse create(PaymentCreate paymentInput)throws AuthenticationException, InvalidRequestException, APIConnectionException ;
	
	public PaymentResponse read(String id);
	public List<PaymentResponse> list();

}
