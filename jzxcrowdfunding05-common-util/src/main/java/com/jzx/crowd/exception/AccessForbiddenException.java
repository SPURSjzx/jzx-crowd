package com.jzx.crowd.exception;

/**
 * 拦截器判断用户未登录时抛出的异常
 * @title: AccessForbiddenException
 * @Author Jzxxxx
 * @Date: 2020/9/21 22:55
 * @Version 1.0
 */
public class AccessForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 3084165545139953250L;


    public AccessForbiddenException() {
        super();
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    protected AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
