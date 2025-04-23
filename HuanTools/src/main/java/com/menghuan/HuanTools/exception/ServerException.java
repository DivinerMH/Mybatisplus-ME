package com.menghuan.HuanTools.exception;

import com.menghuan.HuanTools.bean.api.ApiCode;

/**
 * 服务端异常
 *
 * @author menghuan
 */
public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiCode apiCode;

    /**
     * 使用错误码构造异常
     *
     * @param apiCode 标准错误码枚举（包含预定义错误消息）
     */
    public ServerException(ApiCode apiCode) {
        super(apiCode.getMsg());
        this.apiCode = apiCode;
    }

    /**
     * 基础构造器
     *
     * @param apiCode 错误码枚举
     * @param message 动态消息（覆盖apiCode默认消息）
     */
    public ServerException(ApiCode apiCode, String message) {
        super(message);
        this.apiCode = apiCode;
    }

    /**
     * 自定义消息构造器
     *
     * @param message 纯文本错误描述（无错误码关联）
     */
    public ServerException(String message) {
        super(message);
    }

    /**
     * 带根本原因异常的构造器
     *
     * @param apiCode 错误码枚举
     * @param cause 原始异常（触发此异常的底层原因）
     */
    public ServerException(ApiCode apiCode, Throwable cause) {
        super(apiCode.getMsg(), cause);
        this.apiCode = apiCode;
    }

    /**
     * 获取关联的错误码对象
     * 
     * @return ApiCode 标准错误码实例
     */
    public ApiCode getApiCode() {
        return apiCode;
    }

}
