package com.beyonic.test.payment;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.*;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import co.freeside.betamax.util.SSLOverrider;

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

	@Rule public Recorder  recorder = new Recorder();
	
	

	@Before
	public void setUp() throws Exception {
		
		SSLOverrider sslOverrider = new SSLOverrider();
		sslOverrider.activate();
	}
	
	
	@Betamax(tape = "payments/read")
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
			//fail("Payment list method is not working");
		}
		
		
	}
	
	
	@Betamax(tape = "payments/create")
	@Test
	public void testCreate() {

		
		PaymentsMethods paymentsMethods = new PaymentsMethodsImpl();
		PaymentCreate paymentCreate = new PaymentCreate("+256772781923", new BigDecimal(100.00), "UGX", "This is created using jUnit test case.");
		PaymentResponse payment = null;
		String errMsg =  null;
		try {
			payment = paymentsMethods.create(paymentCreate);
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			e.printStackTrace();
		} finally{
		}
		
		
		assertFalse("Collecetion request is not getting created: "+((errMsg==null)?"":errMsg), payment==null);
		
		
		
	}
	
	

	@Betamax(tape = "payments/list")
	@Test
	public void testList() {
		
		PaymentsMethods paymentsMethods = new PaymentsMethodsImpl();
		List<PaymentResponse> paymentList = paymentsMethods.list();
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
