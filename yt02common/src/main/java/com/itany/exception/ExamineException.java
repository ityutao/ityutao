package com.itany.exception;

/**
 * Author:yutao@itany.com
 * Date:19-4-4 上午9:08
 * description:
 * version:1.0
 */
public class ExamineException extends Exception {
    public ExamineException() {
    }

    public ExamineException(String message) {
        super(message);
    }

    public ExamineException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExamineException(Throwable cause) {
        super(cause);
    }

    public ExamineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
