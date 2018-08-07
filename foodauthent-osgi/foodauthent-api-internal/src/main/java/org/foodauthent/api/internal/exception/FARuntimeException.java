package org.foodauthent.api.internal.exception;

public class FARuntimeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -7751424592793957965L;

    public FARuntimeException() {

    }

    public FARuntimeException(final String message) {
	super(message);

    }

    public FARuntimeException(final String message, final Throwable cause) {
	super(message, cause);

    }

    public FARuntimeException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);

    }

    public FARuntimeException(final Throwable cause) {
	super(cause);

    }

}
