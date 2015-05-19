package com.beyonic.test.collections;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.*;

import com.beyonic.client.collections.CollectionsMethods;
import com.beyonic.client.collections.CollectionsMethodsImpl;
import com.beyonic.model.collections.CollectionResponse;
import com.beyonic.util.BeyonicConstants;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class CollectionsMethodsImplTest {

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
	public void testRead() {
		
		CollectionsMethods collectionsMethods = new CollectionsMethodsImpl();
		List<CollectionResponse> resp = collectionsMethods.list();
		
		if(resp!=null && resp.size()>0){
			CollectionResponse colResp = resp.get(0);
			
			colResp = collectionsMethods.read(colResp.getId()+"");
			
			assertFalse("Collection search method is not working", colResp==null);
			
			
		} else{
			fail("Collection list returned null");
		}
	}

	@Test
	public void testList() {
		
		CollectionsMethods collectionsMethods = new CollectionsMethodsImpl();
		List<CollectionResponse> resp = collectionsMethods.list();
		
		assertFalse("Collection list method is not working", resp==null);
		
		
	}

	@Test
	public void testSearch() {
		
		CollectionsMethods collectionsMethods = new CollectionsMethodsImpl();
		List<CollectionResponse> resp = collectionsMethods.list();
		
		if(resp!=null && resp.size()>0){
			CollectionResponse colResp = resp.get(0);
			resp = collectionsMethods.search(colResp.getPhonenumber(), colResp.getRemote_transaction_id());
			
			assertFalse("Collection search method is not working", resp==null);
			
			
		} else{
			fail("Collection list returned null");
		}
		
	}

	@Test
	public void testClaim() {
		
		CollectionsMethods collectionsMethods = new CollectionsMethodsImpl();
		List<CollectionResponse> resp = collectionsMethods.list();
		
		if(resp!=null && resp.size()>0){
			CollectionResponse colResp = resp.get(0);
			resp = collectionsMethods.claim(colResp.getPhonenumber(), colResp.getRemote_transaction_id(), true, colResp.getAmount());
			
			assertFalse("Collection search method is not working", resp==null);
			
			
		} else{
			fail("Collection list returned null");
		}
	}

}
