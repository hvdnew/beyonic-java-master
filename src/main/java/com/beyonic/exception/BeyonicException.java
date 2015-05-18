package com.beyonic.exception;

/**
 * 
 * @author Harshvardhan Dadhich
 *
 */
public abstract class BeyonicException extends Exception {

	public BeyonicException(String message) {
		super(message, null);
	}

	public BeyonicException(String message, Throwable e) {
		super(message, e);
	}

	private static final long serialVersionUID = 1L;

}
