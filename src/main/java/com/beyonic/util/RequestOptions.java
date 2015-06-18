package com.beyonic.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class RequestOptions {
	private Map<String,Object> params;
	private Map<String,String> headers;

	/**
	 * 
	 * @return RequestOptions object with default values in header field.
	 */
	public static RequestOptions getDefault() {
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Charset", ConnectionUtil.CHARSET);
		headers.put("Accept", "application/json");
		headers.put("Beyonic-Version", BeyonicConstants.CLIENT_API_VERSION);
		headers.put("Authorization", String.format("Token %s", BeyonicConstants.CLIENT_API_KEY));
		
		RequestOptions options = new RequestOptions();
		options.setHeaders(headers);
		
		return options;
	}

	public Map<String, Object> getParams() {
		if(params == null)
			return new HashMap<String, Object>();
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Map<String, String> getHeaders() {
		if(headers == null)
			return new HashMap<String, String>();
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

}
