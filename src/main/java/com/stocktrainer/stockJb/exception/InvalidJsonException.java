package com.stocktrainer.stockJb.exception;

/**
 * <h1>InvalidJsonException</h1>
 * <p>Exception to be thrown when input json is incorrect, incomplete or invalid</p>
 *
 * @author jackbranch
 */
public class InvalidJsonException extends RuntimeException {

    public InvalidJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJsonException(String message) {
        super(message);
    }

    /**
     * <h2>InvalidJsonException</h2>
     * <p>Overload to be used for complex error messages using runtime specific data</p>
     *
     * @param message     exception message
     * @param messageInfo specific information
     * @param cause       exception trace information
     */
    public InvalidJsonException(String message, String messageInfo, Throwable cause) {
        super(message.concat(messageInfo), cause);
    }

}
