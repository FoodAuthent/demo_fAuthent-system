package org.foodauthent.api.internal.exception;

public class ModelExistsException extends FARuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4901473988195681167L;

	public ModelExistsException() {
    }

    public ModelExistsException(final String message) {
	super(message);
    }

    public ModelExistsException(final Throwable cause) {
	super(cause);
    }

    public ModelExistsException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public ModelExistsException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
