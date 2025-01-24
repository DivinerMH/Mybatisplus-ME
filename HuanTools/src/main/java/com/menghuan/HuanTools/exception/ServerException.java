package com.menghuan.HuanTools.exception;

import com.menghuan.HuanTools.api.ApiCode;

/**
 * 服务端异常
 *
 * @author menghuan
 * @date 2015-01-24
 */
public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ApiCode apiCode;

    public ServerException(ApiCode apiCode) {
        this.apiCode = apiCode;
    }

    public ApiCode getApiCode() {
        return apiCode;
    }

}
