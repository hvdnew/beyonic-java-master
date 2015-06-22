package com.beyonic.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.beyonic.model.Webhook;
import com.beyonic.model.enums.WebhookEvents;
import com.beyonic.util.BeyonicConstants;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import co.freeside.betamax.util.SSLOverrider;


/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class WebhookTest {

	@Rule public Recorder  recorder = new Recorder();

	@Before
	public void setUp() throws Exception {
		
		SSLOverrider sslOverrider = new SSLOverrider();
		sslOverrider.activate();
	}


	@Betamax(tape = "webhook/create")
	@Test
	public void testCreate() {
		Webhook webhook = null;
		String errMsg = null;
		try {
			webhook = Webhook.create("payment.status.changed", "https://www.harsh.com");
		} catch (Exception e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook create is not working: "+((errMsg == null)?"":errMsg), webhook == null);
		
	}

	//@Betamax(tape = "webhook/read")
	//@Test
	public void testRead() {
		
		List<Webhook> toRet = null;
		String errMsg = null;
		Webhook webhook = null;
		try {
			System.out.println("testRead calling list: ");
			toRet = Webhook.list();
			System.out.println("list: "+toRet);
			if(toRet != null && toRet.size() > 0){
				
				webhook = toRet.get(0);
				System.out.println("testRead: "+webhook.getId());
				webhook = Webhook.read(webhook.getId()+"");
				
			}
			else{
				fail("Webhook list is not working from testRead");
			}
			
			
		} catch (Exception e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook read is not working: "+((errMsg == null)?"":errMsg), webhook == null);
		assertFalse("Webhook list is not working: "+((errMsg == null)?"":errMsg), toRet == null);
	}

	//@Betamax(tape = "webhook/list")
	//@Test
	public void testList() {
		
		List<Webhook> toRet = null;
		String errMsg = null;
		try {
			toRet = Webhook.list();
		} catch (Exception e) {
			errMsg = e.getMessage();
		}
		
		assertFalse("Webhook list is not working: "+((errMsg == null)?"":errMsg), toRet == null);
		
	}

	//@Betamax(tape = "webhook/delete")
	//@Test
	public void testDelete() {
		List<Webhook> toRet = null;
		String errMsg = null;
		Webhook webhook = null;
		try {
			toRet = Webhook.list();
			
			if(toRet != null && toRet.size() > 0){
				
				webhook = toRet.get(0);
				Webhook.delete(webhook.getId()+"");
				
			}
			else{
				fail("Webhook list is not working");
			}
			
			
		} catch (Exception e) {
			errMsg = e.getMessage();
			fail("Webhook delete is not working: "+errMsg);
		}
		
		
		
	}

	//@Betamax(tape = "webhook/update")
	//@Test
	public void testUpdate() {
		
		List<Webhook> toRet = null;
		String errMsg = null;
		Webhook webhook = null;
		try {
			toRet = Webhook.list();
			
			if(toRet != null && toRet.size() > 0){
				
				webhook = toRet.get(0);
				webhook = Webhook.update(webhook.getId()+"", WebhookEvents.payment_status_changed, "https://www.harsh.com");
				assertFalse("Webhook update is not working", webhook == null);
			}
			else{
				fail("Webhook list is not working");
			}
			
		} catch (Exception e) {
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
