package com.beyonic.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.*;

import co.freeside.betamax.Betamax;
import co.freeside.betamax.Recorder;
import co.freeside.betamax.util.SSLOverrider;

import com.beyonic.model.Collection;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class CollectionTest {
	
	@Rule public Recorder  recorder = new Recorder();

	@Before
	public void setUp() throws Exception {
		SSLOverrider sslOverrider = new SSLOverrider();
		sslOverrider.activate();
	}

	@Betamax(tape = "collections/read")
	@Test
	public void testRead() {
		
		List<Collection> resp = Collection.list();
		
		if(resp!=null && resp.size()>0){
			Collection colResp = resp.get(0);
			
			colResp = Collection.read(colResp.getId()+"");
			
			assertFalse("Collection search method is not working", colResp==null);
			
			
		} else{
			//fail("Collection list returned null");
		}
	}

	@Betamax(tape = "collections/list")
	@Test
	public void testList() {
		
		List<Collection> resp = Collection.list();
		
		
		//assertFalse("Collection list method is not working", resp==null);
		
		
	}
	
	@Betamax(tape = "collections/search")
	@Test
	public void testSearch() {
		
		List<Collection> resp = Collection.list();
		
		if(resp!=null && resp.size()>0){
			Collection colResp = resp.get(0);
			resp = Collection.search(colResp.getPhonenumber(), colResp.getRemote_transaction_id());
			
			assertFalse("Collection search method is not working", resp==null);
			
			
		} else{
			//fail("Collection list returned null");
		}
		
	}

	@Betamax(tape = "collections/claim")
	@Test
	public void testClaim() {
		
		List<Collection> resp = Collection.list();
		
		if(resp!=null && resp.size()>0){
			Collection colResp = resp.get(0);
			resp = Collection.claim(colResp.getPhonenumber(), colResp.getRemote_transaction_id(), true, colResp.getAmount());
			
			assertFalse("Collection search method is not working", resp==null);
			
			
		} else{
			//fail("Collection list returned null");
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
