package com.beyonic.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.beyonic.exception.APIConnectionException;
import com.beyonic.exception.AuthenticationException;
import com.beyonic.exception.InvalidRequestException;
import com.google.gson.Gson;
public abstract class ConnectionUtil {

	private static final String AUTHORIZATION = "Authorization";

	public static final String CHARSET = "UTF-8";

	private static final String DNS_CACHE_TTL_PROPERTY_NAME = "networkaddress.cache.ttl";

	public enum RequestMethod {
		GET, POST, PUT, DELETE
	}


	private static HttpsURLConnection createConnection(
			String url, RequestOptions options) throws Exception {

		// Create a trust manager that does not validate certificate chains
        /*TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
				@Override
				public void checkClientTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {
				}
				@Override
				public void checkServerTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {
				}
            }
        };
 
        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
 
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);*/
		
		
		HttpsURLConnection con = (HttpsURLConnection)new URL(url).openConnection();
		con.setConnectTimeout(30 * 1000);
		con.setReadTimeout(80 * 1000);
		con.setUseCaches(false);
		for (Map.Entry<String, String> header : options.getHeaders().entrySet()) {
			con.setRequestProperty(header.getKey(), header.getValue());
		}

		return con;
	}


	private static String formatURL(String url, String query) {
		if (query == null || query.isEmpty()) {
			return url;
		} else {
			// In some cases, URL can already contain a question mark (eg, upcoming invoice lines)
			String separator = url.contains("?") ? "&" : "?";
			return String.format("%s%s%s", url, separator, query);
		}
	}

	
	private static java.net.HttpURLConnection createGetConnection(
			String url, String query, RequestOptions options) throws Exception {
		
		String getURL = formatURL(url, query);
		HttpsURLConnection con = createConnection(getURL, options);
		con.setRequestMethod("GET");
		
		return con;
	}

	
	@SuppressWarnings("unused")
	private static void checkSSLCert(HttpsURLConnection hconn) throws IOException, APIConnectionException {
		if (!BeyonicConstants.verifySSL) {
			return;
		}

		
		hconn.connect();
		
		Certificate[] certs = hconn.getServerCertificates();

		System.out.println(certs);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			byte[] der = certs[0].getEncoded();
			md.update(der);
			byte[] digest = md.digest();

			System.out.println(digest);
			
			// verify the certificate here, this must be the same as the site cert
			byte[] revokedCertDigest = {(byte) 0x05, (byte) 0xc0, (byte) 0xb3, (byte) 0x64, (byte) 0x36, (byte) 0x94, (byte) 0x47, (byte) 0x0a, (byte) 0x88, (byte) 0x8c, (byte) 0x6e, (byte) 0x7f, (byte) 0xeb, (byte) 0x5c, (byte) 0x9e, (byte) 0x24, (byte) 0xe8, (byte) 0x23, (byte) 0xdc, (byte) 0x53};

			if (Arrays.equals(digest, revokedCertDigest)) {
				throw new APIConnectionException("Invalid server certificate. You tried to connect to a server that has a revoked SSL certificate, which means we cannot securely send data to that server. Please email abc@abc.com if you need help connecting to the correct API server.");
			}

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (CertificateEncodingException e) {
			throw new APIConnectionException("Invalid server certificate. You tried to connect to a server that has a revoked SSL certificate, which means we cannot securely send data to that server. Please email abc@abc.com if you need help connecting to the correct API server.");
		}
	}
	
	private static java.net.HttpURLConnection createPostConnection(
			String url, String query, RequestOptions options) throws Exception {
		
		//String getURL = formatURL(url, query);
		//System.out.println("getURL: "+getURL);
		
		java.net.HttpURLConnection conn = createConnection(url, options);
		
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("charset", CHARSET);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

		
		OutputStream output = null;
		try {
			output = conn.getOutputStream();
			output.write(query.getBytes(CHARSET));
		} finally {
			if (output != null) {
				output.close();
			}
		}
		
		return conn;
	}

	private static java.net.HttpURLConnection createPutConnection(
			String url, String query, RequestOptions options) throws Exception {
		
		String getURL = formatURL(url, query);
		//System.out.println("getURL: "+getURL);
		
		java.net.HttpURLConnection conn = createConnection(getURL, options);
		
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("charset", CHARSET);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

		
		OutputStream output = null;
		try {
			output = conn.getOutputStream();
			output.write(query.getBytes(CHARSET));
		} finally {
			if (output != null) {
				output.close();
			}
		}
		
		return conn;
	}
	
	private static java.net.HttpURLConnection createDeleteConnection(
			String url, String query, RequestOptions options) throws Exception {
		String deleteUrl = formatURL(url, query);
		java.net.HttpURLConnection conn = createConnection(
				deleteUrl, options);
		conn.setRequestMethod("DELETE");

		return conn;
	}

	
	private static String createQuery(Map<String, String> params)
			throws UnsupportedEncodingException, InvalidRequestException {
		StringBuilder queryStringBuffer = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (queryStringBuffer.length() > 0) {
				queryStringBuffer.append("&");
			}
			queryStringBuffer.append(urlEncodePair(entry.getKey(),
					entry.getValue()));
		}
		return queryStringBuffer.toString();
	}

	// represents Errors returned as JSON
	private static class ErrorContainer {
		private Error error;
	}

	private static class Error {
		@SuppressWarnings("unused")
		String type;

		String message;

		String code;

		String param;
	}

	private static String getResponseBody(InputStream responseStream)
			throws IOException {
		//\A is the beginning of
		// the stream boundary
		String rBody = null;
		try {
			rBody = new Scanner(responseStream, CHARSET).useDelimiter("\\A").next();
			responseStream.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return rBody;
	}

	private static String makeConnectionRequest(RequestMethod method, String url, String query,
			RequestOptions options) throws Exception {
		java.net.HttpURLConnection conn = null;
		try {
			switch (method) {
			case GET:
				conn = createGetConnection(url, query, options);
				break;
			case POST:
				conn = createPostConnection(url, query, options);
				break;
			case DELETE:
				conn = createDeleteConnection(url, query, options);
				break;
			case PUT:
				conn = createPutConnection(url, query, options);
				break;
			default:
				throw new IllegalArgumentException("Unrecognized HTTP method");
			}
			// trigger the request
			int rCode = conn.getResponseCode();
			String rBody;
			rBody = getResponseBody(conn.getInputStream());
			
			if (rCode < 200 && rCode > 300) {
				handleAPIError(rBody, rCode);
			} 
			
			return rBody;
		} catch (IOException e) {
			try {
				if(conn!=null)
				System.out.println("Error Stream: "+getResponseBody(conn.getErrorStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new APIConnectionException(e.getMessage()+" . IOException during API request. Please check your internet connection and try again.");
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static String request(RequestMethod method, String url, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException	{
		if (options == null) {
			options = RequestOptions.getDefault();
		}
		String originalDNSCacheTTL = null;
		Boolean allowedToSetTTL = true;

		try {
			originalDNSCacheTTL = java.security.Security
					.getProperty(DNS_CACHE_TTL_PROPERTY_NAME);
			// disable DNS cache
			java.security.Security
					.setProperty(DNS_CACHE_TTL_PROPERTY_NAME, "0");
		} catch (SecurityException se) {
			se.printStackTrace();
			allowedToSetTTL = false;
		}

		try {
			return _request(method, url, options);
		} finally {
			if (allowedToSetTTL) {
				if (originalDNSCacheTTL == null) {
					// value unspecified by implementation
					// DNS_CACHE_TTL_PROPERTY_NAME of -1 = cache forever
					java.security.Security.setProperty(DNS_CACHE_TTL_PROPERTY_NAME, "-1");
				} else {
					java.security.Security.setProperty(
							DNS_CACHE_TTL_PROPERTY_NAME, originalDNSCacheTTL);
				}
			}
		}
	}

	protected static String _request(RequestMethod method, String url,	RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException {
		String apiKey = options.getHeaders().get(AUTHORIZATION);
		if (apiKey == null || apiKey.trim().isEmpty()) {
			throw new AuthenticationException(
					"No API key provided. (HINT: set your API key using 'Client.apiKey = <API-KEY>'. "
							+ "You can generate API keys from the Beyonic web interface. ");
		}

		

		//BeyonicConstants.setEnvironment();
		
		String query;

		try {
			query = createQuery(options.getParams());
		} catch (UnsupportedEncodingException e) {
			throw new InvalidRequestException("Unable to encode parameters to "	+ CHARSET+"."+ e.getMessage());
		}

		String response = null;
		try {
			// HTTPSURLConnection verifies SSL cert by default
			response = makeConnectionRequest(method, url, query, options);
		} catch (ClassCastException ce) {
				throw ce;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	private static void handleAPIError(String rBody, int rCode)
			throws InvalidRequestException, AuthenticationException, APIConnectionException {
		Error error = new Gson().fromJson(rBody,
				ErrorContainer.class).error;
		switch (rCode) {
		case 400:
			throw new InvalidRequestException(error.message);
		case 404:
			throw new InvalidRequestException(error.message);
		case 401:
			throw new AuthenticationException(error.message);
		default:
			throw new APIConnectionException(error.message);
		}
	}

	private static String urlEncode(String str) throws UnsupportedEncodingException {
		// Preserve original behavior that passing null for an object id will lead
		// to us actually making a request to /v1/foo/null
		if (str == null) {
			return null;
		}
		else {
			return URLEncoder.encode(str, CHARSET);
		}
	}

	private static String urlEncodePair(String k, String v)
			throws UnsupportedEncodingException {
		return String.format("%s=%s", urlEncode(k), urlEncode(v));//urlEncode(v)
	}
}
