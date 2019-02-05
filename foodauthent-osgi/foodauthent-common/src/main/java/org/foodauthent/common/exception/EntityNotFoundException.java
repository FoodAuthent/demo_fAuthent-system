package org.foodauthent.common.exception;

public class EntityNotFoundException extends ServiceException {

	private static final long serialVersionUID = -8040865583916614304L;

	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}

}
