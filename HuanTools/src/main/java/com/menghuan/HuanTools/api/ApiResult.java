package com.menghuan.HuanTools.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * REST API 响应结果
 */
@Data
public class ApiResult<T> implements Serializable {

    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    public ApiResult() {
        this.success = true;
        this.msg = ApiCode.SUCCESS.getMsg();
        this.code = ApiCode.SUCCESS.getCode();
    }

    public static ApiResult of() {
        return new ApiResult();
    }

    public static ApiResult of(final Boolean result) {
        ApiResult apiResult = ApiResult.of();
        apiResult.setSuccess(result);
        apiResult.setData(null);
        return apiResult;
    }

    public static ApiResult of(final String msg) {
        ApiResult apiResult = ApiResult.of();
        apiResult.setSuccess(false);
        apiResult.setCode(ApiCode.FAIL.getCode());
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static ApiResult of(final Object data) {
        ApiResult apiResult = ApiResult.of();
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult of(final ApiCode resultCode) {
        return of(false, resultCode);
    }

    public static ApiResult of(final String msg, final ApiCode resultCode) {
        ApiResult apiResult = ApiResult.of();
        apiResult.setSuccess(false);
        apiResult.setMsg(msg);
        apiResult.setCode(resultCode.getCode());
        return apiResult;
    }

    public static ApiResult of(final ApiCode resultCode, final Object data) {
        ApiResult apiResult = of(false, resultCode);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult of(final Boolean result, final ApiCode resultCode) {
        ApiResult apiResult = ApiResult.of();
        apiResult.setSuccess(result);
        apiResult.setMsg(resultCode.getMsg());
        apiResult.setCode(resultCode.getCode());
        return apiResult;
    }

    public static ApiResult of(final Boolean result, final Object data) {
        ApiResult apiResult = ApiResult.of();
        apiResult.setSuccess(result);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult of(final Boolean result, final Object data, final ApiCode resultCode) {
        ApiResult apiResult = of(result, resultCode);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult ok() {
        return of(true);
    }

    public static ApiResult ok(final Object data) {
        return of(data);
    }

    public static ApiResult ok(final ApiCode data) {
        return of(data);
    }

    public static ApiResult ok(final Object data, final ApiCode resultCode) {
        return of(true, data, resultCode);
    }

    public static ApiResult fail() {
        return of(false, ApiCode.FAIL);
    }

    public static ApiResult fail(final ApiCode data) {
        return of(false, data);
    }

    public static ApiResult fail(final String msg) {
        return of(msg);
    }

    public static ApiResult fail(ApiCode apiCode, Object data) {
        return of(apiCode, data);
    }

    public static ApiResult okMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return ok(map);
    }

}
