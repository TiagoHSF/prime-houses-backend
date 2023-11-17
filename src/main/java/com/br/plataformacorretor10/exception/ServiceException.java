package com.br.plataformacorretor10.exception;

/**
 * The Class ServiceException
 *
 * @author Tiago Ferreira.
 * @since 17/11/2023
 */
public class ServiceException extends Exception {

    /**
     * Instantiates a new business exception.
     */
    public ServiceException() {
        super();
    }

    /**
     * Instantiates a new business exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ServiceException(final String message, final Throwable cause, final boolean enableSuppression,
                             final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new business exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new business exception.
     *
     * @param message the message
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new business exception.
     *
     * @param cause the cause
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        final String s = this.getClass().getName();
        final String message = this.getLocalizedMessage();
        return (message != null) ? (message) : s;
    }
}