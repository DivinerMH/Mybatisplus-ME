package com.menghuan.HuanTools.exception;

/**
 * 校验异常
 * 
 * @author menghuan
 * @date 2015-01-24
 */
public class ValidateException extends RuntimeException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateException() {}

    public ValidateException(String msg) {
        super(msg);
    }

}
