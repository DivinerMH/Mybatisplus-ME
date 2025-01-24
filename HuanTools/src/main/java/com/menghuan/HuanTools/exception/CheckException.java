package com.menghuan.HuanTools.exception;

/**
 * 校验异常
 * 
 * @author menghuan
 * @date 2015-01-24
 */
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
