package com.beyonic.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import co.freeside.betamax.util.SSLOverrider;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.Payment;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class PaymentTest {

	@Rule public Recorder  recorder = new Recorder();
	
	

	@Before
	public void setUp() throws Exception {
		
		SSLOverrider sslOverrider = new SSLOverrider();
		sslOverrider.activate();
	}
	
	
	@Betamax(tape = "payments/read")
	@Test
	public void testRead() {

		List<Payment> paymentList = Payment.list();
		Payment paymentResponse = null;
		if(paymentList != null && paymentList.size() > 0){
			paymentResponse = paymentList.get(0);
			paymentResponse = Payment.read(paymentResponse.getId()+"");
			assertFalse("Payment read method is not working", paymentResponse==null);
		}
		else{
			//fail("Payment list method is not working");
		}
		
		
	}
	
	
	@Betamax(tape = "payments/create")
	@Test
	public void testCreate() {

		
		Payment payment = null;
		
		Map<String, Object> paymentParams = new HashMap<String, Object>();
		paymentParams.put("phonenumber", "+256773712831");
		paymentParams.put("amount", 400);
		paymentParams.put("currency", "ugx");
		paymentParams.put("description", "transport payment");
		paymentParams.put("callback_url", "https://my.website/payments/callback");
		
		
		
		try {
			payment = Payment.create(paymentParams);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		} finally{
		}
		
		
		assertFalse("Payment request is not created ", payment==null);
		
		
		
	}
	
	

	@Betamax(tape = "payments/list")
	@Test
	public void testList() {
		
		List<Payment> paymentList = Payment.list();
		assertFalse("Payment list method is not working", paymentList==null);
		
		
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	@After
	public void tearDown() throws Exception {
	}

}
