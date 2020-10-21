package com.menghuan.generator.tools.dto;

import lombok.Data;

@Data
public class MachineOnilneStateDto {
    //租户ID
    private Integer tenantId;
    //超时时间 秒
    private Integer outTime;
    //上传数据的时间戳
    private Long upStreamTime;
    //同一次离线 重复轮询只报警一次
    //报警过一次后修改状态  如果设备上线则改为未报
    //报警状态  0 未报  1 已报
    private Integer AlarmState;
    //上一次 在离线状态  0 在线  1 离线
    private Integer lastOnlineState;
}
