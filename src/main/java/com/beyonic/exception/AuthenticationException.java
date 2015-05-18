package com.beyonic.exception;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class AuthenticationException extends Exception {
	private static final long serialVersionUID = -6257654490161245331L;
	
	public AuthenticationException(String message, Throwable e) {
		super(message, e);
	}
	
	public AuthenticationException(String message) {
		super(message);
	}
	
}
