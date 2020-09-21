package com.jzx.crowd.exception;

/**
 * 登陆失败后抛出的异常
 * @title: LoginFailedException
 * @Author Jzxxxx
 * @Date: 2020/9/19 22:26
 * @Version 1.0
 */
public class LoginFailedException extends RuntimeException{

    private static final long serialVersionUID = 2896466861902236974L;

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
