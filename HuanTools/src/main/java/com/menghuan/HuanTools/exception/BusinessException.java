package com.menghuan.HuanTools.exception;

import com.menghuan.HuanTools.exception.enums.BusinessEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 *
 * @author menghuan
 * @date 2015-01-24
 */
public class BusinessException extends RuntimeException {

    @Getter
    @Setter
    protected Integer code;

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * 拓展部分
     * 
     * @param code 异常码
     * @param message 异常信息
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(BusinessEnum codeEnum, Object... args) {
        super(String.format(codeEnum.getDescription(), args));
        this.code = codeEnum.getCode();
    }

}
