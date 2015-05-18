package com.beyonic.exception;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public class APIConnectionException extends BeyonicException {
	private static final long serialVersionUID = -2021678130595872541L;
	
	public APIConnectionException(String message) {
		super(message);
	}
	
	public APIConnectionException(String message, Throwable e) {
		super(message, e);
	}

}
