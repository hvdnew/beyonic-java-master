package com.beyonic.test.webhooks;

import static org.junit.Assert.*;

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

import com.beyonic.client.webhooks.WebhookMethods;
import com.beyonic.client.webhooks.WebhookMethodsImpl;
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
public class WebhookMethodsImplTest {

	@Rule public Recorder  recorder = new Recorder();

	@Before
	public void setUp() throws Exception {
		
		BeyonicConstants.CLIENT_API_VERSION = "v1";//"v1"; // setting api version
		BeyonicConstants.CLIENT_API_KEY = "ab594c14986612f6167a975e1c369e71edab6900";// "312726d359422c52d986e6a67f713cdf42eb9f96"; // beyonic test key
		
		
		SSLOverrider sslOverrider = new SSLOverrider();
		sslOverrider.activate();
	}


	@Betamax(tape = "webhook/create")
	@Test
	public void testCreate() {
		WebhookMethods webhookMethods = new WebhookMethodsImpl();
		Webhook webhook = null;
		String errMsg = null;
		try {
			webhook = webhookMethods.create(WebhookEvents.payment_status_changed, "https://www.harsh.com");
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook create is not working: "+((errMsg == null)?"":errMsg), webhook == null);
		
	}

	@Betamax(tape = "webhook/read")
	@Test
	public void testRead() {
		
		WebhookMethods webhookMethods = new WebhookMethodsImpl();
		List<Webhook> toRet = null;
		String errMsg = null;
		Webhook webhook = null;
		try {
			toRet = webhookMethods.list();
			
			if(toRet != null && toRet.size() > 0){
				
				webhook = toRet.get(0);
				webhook = webhookMethods.read(webhook.getId()+"");
				
			}
			else{
				//fail("Webhook list is not working");
			}
			
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook read is not working: "+((errMsg == null)?"":errMsg), webhook == null);
		assertFalse("Webhook list is not working: "+((errMsg == null)?"":errMsg), toRet == null);
	}

	@Betamax(tape = "webhook/list")
	@Test
	public void testList() {
		
		WebhookMethods webhookMethods = new WebhookMethodsImpl();
		List<Webhook> toRet = null;
		String errMsg = null;
		try {
			toRet = webhookMethods.list();
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook list is not working: "+((errMsg == null)?"":errMsg), toRet == null);
		
	}

	@Betamax(tape = "webhook/delete")
	@Test
	public void testDelete() {
		WebhookMethods webhookMethods = new WebhookMethodsImpl();
		List<Webhook> toRet = null;
		String errMsg = null;
		Webhook webhook = null;
		try {
			toRet = webhookMethods.list();
			
			if(toRet != null && toRet.size() > 0){
				
				webhook = toRet.get(0);
				webhookMethods.delete(webhook.getId()+"");
				
			}
			else{
				fail("Webhook list is not working");
			}
			
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
			fail("Webhook delete is not working: "+errMsg);
		}
		
		
		
	}

	@Betamax(tape = "webhook/update")
	@Test
	public void testUpdate() {
		WebhookMethods webhookMethods = new WebhookMethodsImpl();
		List<Webhook> toRet = null;
		String errMsg = null;
		Webhook webhook = null;
		try {
			toRet = webhookMethods.list();
			
			if(toRet != null && toRet.size() > 0){
				
				webhook = toRet.get(0);
				webhook = webhookMethods.update(webhook.getId()+"", WebhookEvents.payment_status_changed, "https://www.harsh.com");
				assertFalse("Webhook update is not working", webhook == null);
			}
			else{
				fail("Webhook list is not working");
			}
			
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
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
