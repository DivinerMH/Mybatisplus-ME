package com.cateyes.smart.park.base.utils;

import com.cateyes.smart.park.base.ApiCode;

/**
 * 服务端异常
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
