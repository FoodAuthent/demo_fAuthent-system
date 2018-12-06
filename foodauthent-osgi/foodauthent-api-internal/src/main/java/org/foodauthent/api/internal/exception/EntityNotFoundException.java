package org.foodauthent.api.internal.exception;

public class EntityNotFoundException extends FARuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4901473988195681167L;

	public EntityNotFoundException() {
    }

    public EntityNotFoundException(final String message) {
	super(message);
    }

    public EntityNotFoundException(final Throwable cause) {
	super(cause);
    }

    public EntityNotFoundException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public EntityNotFoundException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
