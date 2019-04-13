package com.itany.exception;

/**
 * Author:yutao@itany.com
 * Date:19-4-12 上午10:27
 * description:
 * version:1.0
 */
public class UserPasswordException extends Exception {
    public UserPasswordException() {
    }

    public UserPasswordException(String message) {
        super(message);
    }

    public UserPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPasswordException(Throwable cause) {
        super(cause);
    }

    public UserPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
