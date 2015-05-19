package com.beyonic.test.payment;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beyonic.client.payment.PaymentsMethods;
import com.beyonic.client.payment.PaymentsMethodsImpl;
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
public class PaymentsMethodsImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		
		PaymentsMethods paymentsMethods = new PaymentsMethodsImpl();
		PaymentCreate paymentCreate = new PaymentCreate("+918976466457", new BigDecimal(100.00), "USD", "This is created using jUnit test case.");
		PaymentResponse payment = null;
		String errMsg =  null;
		try {
			payment = paymentsMethods.create(paymentCreate);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
		}
		
		
		assertFalse("Collecetion request is not getting created: "+((errMsg==null)?"":errMsg), payment==null);
		
	}

	@Test
	public void testRead() {
		PaymentsMethods paymentsMethods = new PaymentsMethodsImpl();
		List<PaymentResponse> paymentList = paymentsMethods.list();
		PaymentResponse paymentResponse = null;
		if(paymentList != null && paymentList.size() > 0){
			paymentResponse = paymentList.get(0);
			paymentResponse = paymentsMethods.read(paymentResponse.getId()+"");
			assertFalse("Payment read method is not working", paymentResponse==null);
		}
		else{
			fail("Payment list method is not working");
		}
		
		
	}

	@Test
	public void testList() {
		
		PaymentsMethods paymentsMethods = new PaymentsMethodsImpl();
		
		List<PaymentResponse> paymentList = paymentsMethods.list();
		
		assertFalse("Payment list method is not working", paymentList==null);
		
		
	}

}
