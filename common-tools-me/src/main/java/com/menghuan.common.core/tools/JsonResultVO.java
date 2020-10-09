package com.menghuan.common.core.tools;

import lombok.Data;

@Data
public class JsonResultVO {

    private int code;       //结果状态码
    private String msg;     //结果信息
    private Object data;    //结果数据


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
