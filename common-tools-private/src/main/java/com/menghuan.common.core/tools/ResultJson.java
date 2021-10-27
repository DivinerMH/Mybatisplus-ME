package com.menghuan.common.core.tools;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultJson {

    private String resultCode;
    private String resultDesc;
    private Object resultData;

    private ResultJson() {
    }

    public static ResultJson createSuccessResult(Object data) {
        ResultJson resultJson = new ResultJson();
        resultJson.setResultCode("0");
        resultJson.setResultData(data);
        return resultJson;
    }

    public static ResultJson createFailResult(String resultCode, String resultDesc) {
        ResultJson resultJson = new ResultJson();
        resultJson.setResultCode(resultCode);
        resultJson.setResultDesc(resultDesc);
        return resultJson;
    }
}
