package com.itany.exception;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午10:13
 * description:
 * version:1.0
 */
public class BookeExistException extends Exception {
    public BookeExistException() {
    }

    public BookeExistException(String message) {
        super(message);
    }

    public BookeExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookeExistException(Throwable cause) {
        super(cause);
    }

    public BookeExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
