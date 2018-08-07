package org.foodauthent.api.internal.exception;

public class EntityExistsException extends FARuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4901473988195681167L;

	public EntityExistsException() {
    }

    public EntityExistsException(final String message) {
	super(message);
    }

    public EntityExistsException(final Throwable cause) {
	super(cause);
    }

    public EntityExistsException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public EntityExistsException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
