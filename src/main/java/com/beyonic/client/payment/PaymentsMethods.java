package com.beyonic.client.payment;

import java.util.List;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.payment.PaymentCreate;
import com.beyonic.model.payment.PaymentResponse;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public interface PaymentsMethods {
	
	public static final String PAYMENT_API_ENDPOINT = "https://staging.beyonic.com/api/payments";
	
	
	public PaymentResponse create(PaymentCreate paymentInput)throws AuthenticationException, InvalidRequestException, APIConnectionException ;
	
	public PaymentResponse read(String id);
	public List<PaymentResponse> list();

}
