package org.foodauthent.api.internal.exeption;

public class NoSuchIDException extends FARuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -7323657753953154792L;

    public NoSuchIDException() {

    }

    public NoSuchIDException(final String message) {
	super(message);

    }

    public NoSuchIDException(final Throwable cause) {
	super(cause);

    }

    public NoSuchIDException(final String message, final Throwable cause) {
	super(message, cause);

    }

    public NoSuchIDException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);

    }

}
