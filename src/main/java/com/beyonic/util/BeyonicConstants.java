package com.beyonic.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Harshvardhan Dadhich
 */
public class BeyonicConstants {

	public static final String PROPERTIES_FILE_NAME = "beyonic.properties";
	public static final String PROP_DIR = "beyonic";
	public static final String USER_HOME = "user.home";
	public static final String CLIENT_API_VERSION = "v1";
	public static final String CLIENT_API_KEY = "312726d359422c52d986e6a67f713cdf42eb9f96";
	public static final String HOST_NAME = "staging.beyonic.com";
	public static final boolean verifySSL = true;

	public static final String KEYSTORE_LOCATION = "C:/Users/Owner/.keystore";
	public static final String KEYSTORE_SECRET = "changeit";

	public static void setEnvironment() {
		System.setProperty("javax.net.ssl.trustStore", KEYSTORE_LOCATION);
		System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_SECRET);
	}

	/**
	 * <p> set this hashmap into params of RequestObejct </p>
	 * @param object
	 * @return HashMap of all the fields of any class
	 */
	public static Map<String, String> getAsParams(Object object) {

		Class tClass = object.getClass();
		Method gs1Method;

		Map<String, String> paramMap = new HashMap<String, String>();

		try {

			Field[] fields = tClass.getDeclaredFields();
			System.out.printf("%d fields:%n", fields.length);
			for (Field field : fields) {

				String fieldName = field.getName();
				String methodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1, fieldName.length());
				gs1Method = tClass.getMethod(methodName, new Class[] {});
				String value = gs1Method.invoke(object, new Object[] {}) + "";
				
				if(value!=null && !value.trim().equalsIgnoreCase("null")){
					paramMap.put(fieldName, value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return paramMap;
	}

}
