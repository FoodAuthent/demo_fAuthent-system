package org.foodauthent.common.exception;

public class InvalidOperationException extends ServiceException {

	private static final long serialVersionUID = -8040865583916614304L;

	public InvalidOperationException() {
		super();
	}

	public InvalidOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidOperationException(String message) {
		super(message);
	}

	public InvalidOperationException(Throwable cause) {
		super(cause);
	}

}
