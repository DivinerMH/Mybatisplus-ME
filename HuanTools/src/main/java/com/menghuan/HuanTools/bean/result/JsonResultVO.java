package com.menghuan.HuanTools.bean.result;

import lombok.Data;

/**
 * 返回结果集封装
 *
 * @author menghuan
 * @date 2025-01-24
 */
@Data
public class JsonResultVO {

    /**
     * 结果状态码
     */
    private Integer code;
    /**
     * 结果信息
     * 
     */
    private String msg;

    /**
     * 结果数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
