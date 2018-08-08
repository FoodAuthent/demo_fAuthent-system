package org.foodauthent.api.internal.exception;

public class FAExceptionOld extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1566059953084078199L;

    public FAExceptionOld() {

    }

    public FAExceptionOld(final String message) {
	super(message);

    }

    public FAExceptionOld(final String message, final Throwable cause) {
	super(message, cause);

    }

    public FAExceptionOld(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);

    }

    public FAExceptionOld(final Throwable cause) {
	super(cause);

    }

}
