package com.beyonic.test.collections.collectionrequests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beyonic.client.collections.collectionrequests.CollectionRequestMethods;
import com.beyonic.client.collections.collectionrequests.CollectionRequestsMethodsImpl;
import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.collectionrequests.CollectionRequest;

public class CollectionRequetsMethodsImplTest {

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
		
		CollectionRequestMethods collectionRequetsMethods = new CollectionRequestsMethodsImpl();
		CollectionRequest colReq = null;
		String errMsg = null;
		try {
			colReq = collectionRequetsMethods.create("+918976466457", new BigDecimal(500.0), "USD");
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Collecetion request is not getting created: "+((errMsg==null)?"":errMsg), colReq==null);
		
	}

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
		}
		
		assertFalse("Collecetion List is not retrieved: "+((errMsg==null)?"":errMsg), toRet==null);
		
	}

}
