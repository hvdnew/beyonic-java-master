package com.beyonic.exception;
/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class InvalidRequestException extends Exception {
	private static final long serialVersionUID = 7942610225843383624L;
	
	public InvalidRequestException(String message, Throwable e) {
		super(message, e);
	}
	
	public InvalidRequestException(String message) {
		super(message);
	}
}
