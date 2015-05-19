package com.beyonic.test.webhooks;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beyonic.client.webhooks.WebhookMethods;
import com.beyonic.client.webhooks.WebhookMethodsImpl;
import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.beyonic.model.enums.WebhookEvents;
import com.beyonic.model.webhooks.Webhook;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class WebhookMethodsImplTest {

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
				fail("Webhook list is not working");
			}
			
			
		} catch (APIConnectionException | AuthenticationException
				| InvalidRequestException e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook read is not working: "+((errMsg == null)?"":errMsg), webhook == null);
		assertFalse("Webhook list is not working: "+((errMsg == null)?"":errMsg), toRet == null);
	}

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

}
