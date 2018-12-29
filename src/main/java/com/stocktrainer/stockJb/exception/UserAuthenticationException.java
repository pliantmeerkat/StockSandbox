package com.stocktrainer.stockJb.exception;

/**
 * <h1>UserAuthenticationException</h1>
 * <p>Exception for when user login is invalid</p>
 *
 * @author jackbranch
 */
public class UserAuthenticationException extends Throwable {

    public UserAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAuthenticationException(String message) {
        super(message);
    }
}
