package com.beyonic.exception;

public class InvalidCertificateException extends Exception {
	
	private static final long serialVersionUID = 7942610225843383624L;
	
	public InvalidCertificateException(String message, Throwable e) {
		super(message, e);
	}
	
	public InvalidCertificateException(String message) {
		super(message);
	}
}