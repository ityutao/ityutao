package com.itany.exception;

/**
 * Author:yutao@itany.com
 * Date:19-4-12 上午10:49
 * description:
 * version:1.0
 */
public class SmsCodeException extends Exception {
    public SmsCodeException() {
    }

    public SmsCodeException(String message) {
        super(message);
    }

    public SmsCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmsCodeException(Throwable cause) {
        super(cause);
    }

    public SmsCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
