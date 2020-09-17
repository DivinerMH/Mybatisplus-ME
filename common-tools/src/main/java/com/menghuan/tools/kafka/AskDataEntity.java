package com.menghuan.tools.kafka;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AskDataEntity {
    private String proDomainName;

    private String machineId;

    private List<Map<String, String>> relationList;

    private List<Map<String, Object>> dataListMap;

    public AskDataEntity(){}

    public AskDataEntity(String proDomainName, String machineId, List<Map<String, String>> relationList, List<Map<String, Object>> dataListMap) {
        this.proDomainName=proDomainName;
        this.machineId=machineId;
        this.relationList=relationList;
        this.dataListMap=dataListMap;
    }
}
