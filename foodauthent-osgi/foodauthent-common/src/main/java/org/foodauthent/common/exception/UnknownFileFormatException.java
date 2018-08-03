package org.foodauthent.common.exception;


public class UnknownFileFormatException extends FAException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8758511163605293140L;

	public UnknownFileFormatException() {


	}

	public UnknownFileFormatException(String message) {

		super(message);

	}

	public UnknownFileFormatException(String message, Throwable cause) {

		super(message, cause);

	}

	public UnknownFileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UnknownFileFormatException(Throwable cause) {

		super(cause);

	}
}
