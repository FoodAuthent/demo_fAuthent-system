package org.foodauthent.api.internal.exception;


public class ServiceNotAvailableException extends FARuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8804503607496103848L;

	public ServiceNotAvailableException() {


	}

	public ServiceNotAvailableException(String message) {

		super(message);

	}

	public ServiceNotAvailableException(String message, Throwable cause) {

		super(message, cause);

	}

	public ServiceNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ServiceNotAvailableException(Throwable cause) {

		super(cause);

	}
}
