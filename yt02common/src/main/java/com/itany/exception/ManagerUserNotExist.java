package com.itany.exception;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午2:37
 * description:
 * version:1.0
 */
public class ManagerUserNotExist extends Throwable {

    public ManagerUserNotExist() {
    }

    public ManagerUserNotExist(String message) {
        super(message);
    }

    public ManagerUserNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerUserNotExist(Throwable cause) {
        super(cause);
    }

    public ManagerUserNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
