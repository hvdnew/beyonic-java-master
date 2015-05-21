package com.beyonic.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.beyonic.test.payment.PaymentsMethodsImplTest;
import com.beyonic.util.BeyonicConstants;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
@RunWith(Suite.class)
@SuiteClasses({PaymentsMethodsImplTest.class })
public class BeyonicTest {

	//CollectionsMethodsImplTest.class, CollectionRequetsMethodsImplTest.class,
	//PaymentsMethodsImplTest.class, WebhookMethodsImplTest.class
	
	/**
	 * <p>This methods is called just before invoking the test suite.</p>
	 */
	@BeforeClass
	public static void setUp() {
		
		
		BeyonicConstants.CLIENT_API_VERSION = "v1"; // setting api version
		BeyonicConstants.CLIENT_API_KEY = "312726d359422c52d986e6a67f713cdf42eb9f96"; // beyonic test key
		
		
	}
	
	
}
