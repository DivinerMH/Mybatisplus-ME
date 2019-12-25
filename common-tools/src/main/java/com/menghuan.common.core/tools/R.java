package com.menghuan.common.core.tools;

import com.menghuan.common.core.constant.CommonConstants;
import com.menghuan.common.core.constant.enums.BusinessEnum;
import com.menghuan.common.core.constant.enums.ResponseCodeEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author menghuan
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@Data
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code = CommonConstants.SUCCESS;

    @Getter
    @Setter
    private String msg = "success";


    @Getter
    @Setter
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = CommonConstants.FAIL;
    }




    public static <T> R<T> ok() {
        return restResult(null, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDesc());
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDesc());
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, ResponseCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> failed() {
        return restResult(null, ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDesc());
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, ResponseCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDesc());
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, ResponseCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> R<T> failed(BusinessEnum businessEnum) {
        return restResult(null, businessEnum.getCode(), businessEnum.getDescription());
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}