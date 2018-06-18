package org.foodauthent.api.internal.exeption;

public class FAException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1566059953084078199L;

    public FAException() {

    }

    public FAException(final String message) {
	super(message);

    }

    public FAException(final String message, final Throwable cause) {
	super(message, cause);

    }

    public FAException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);

    }

    public FAException(final Throwable cause) {
	super(cause);

    }

}
