package com.beyonic.test.collections.collectionrequests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import co.freeside.betamax.util.SSLOverrider;

import com.beyonic.client.collections.collectionrequests.CollectionRequestMethods;
import com.beyonic.client.collections.collectionrequests.CollectionRequestsMethodsImpl;
import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.collectionrequests.CollectionRequest;
import com.beyonic.util.BeyonicConstants;

public class CollectionRequetsMethodsImplTest {

	@Rule public Recorder  recorder = new Recorder();

	@Before
	public void setUp() throws Exception {
		
		
		SSLOverrider sslOverrider = new SSLOverrider();
		sslOverrider.activate();
	}

	@Betamax(tape = "collections/requests/create")
	@Test
	public void testCreate() {
		
		CollectionRequestMethods collectionRequetsMethods = new CollectionRequestsMethodsImpl();
		CollectionRequest colReq = null;
		String errMsg = null;
		try {
			colReq = collectionRequetsMethods.create("+256772781923", new BigDecimal(50.0), "UGX");
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Collecetion request is not getting created: "+((errMsg==null)?"":errMsg), colReq==null);
		
	}
	
	@Betamax(tape = "collections/requests/read")
	@Test
	public void testRead() {
		
		
		CollectionRequestMethods collectionRequetsMethods = new CollectionRequestsMethodsImpl();
		CollectionRequest colReq = null;
		String errMsg = null;
		List<CollectionRequest> toRet = null;
		try {
			toRet = collectionRequetsMethods.list();
			if(toRet != null && toRet.size() > 0){
				colReq = toRet.get(0);
				colReq = collectionRequetsMethods.read(colReq.getId()+"");
				
			}
			else{
				fail("Collecetion List is not retrieved: ");
			}
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Collecetion Read is not executed: "+((errMsg==null)?"":errMsg), colReq==null);
		
	}
	
	@Betamax(tape = "collections/requests/list")
	@Test
	public void testList() {
		
		
		CollectionRequestMethods collectionRequetsMethods = new CollectionRequestsMethodsImpl();
		CollectionRequest colReq = null;
		String errMsg = null;
		List<CollectionRequest> toRet = null;
		try {
			toRet = collectionRequetsMethods.list();
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
			fail("fail");
		}
		
		//assertFalse("Collecetion List is not retrieved: "+((errMsg==null)?"":errMsg), toRet==null);
		
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
