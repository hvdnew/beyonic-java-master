package com.beyonic.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.beyonic.test.collections.CollectionsMethodsImplTest;
import com.beyonic.test.collections.collectionrequests.CollectionRequetsMethodsImplTest;
import com.beyonic.test.payment.PaymentsMethodsImplTest;
import com.beyonic.test.webhooks.WebhookMethodsImplTest;
import com.beyonic.util.BeyonicConstants;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
@RunWith(Suite.class)
@SuiteClasses({CollectionsMethodsImplTest.class, CollectionRequetsMethodsImplTest.class,
				PaymentsMethodsImplTest.class, WebhookMethodsImplTest.class})
public class BeyonicTest {

	
	/**
	 * <p>This methods is called just before invoking the test suite.</p>
	 */
	@BeforeClass
	public static void setUp() {
		
		
		BeyonicConstants.CLIENT_API_VERSION = "v1";//"v1"; // setting api version
		BeyonicConstants.CLIENT_API_KEY = "ab594c14986612f6167a975e1c369e71edab6900";// "312726d359422c52d986e6a67f713cdf42eb9f96"; // beyonic test key
		
		
	}
	
	
}
