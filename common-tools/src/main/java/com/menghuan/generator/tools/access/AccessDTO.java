package com.menghuan.generator.tools.access;

import lombok.Data;

/**
 *  考勤业务传输对象
 * @author Administrator
 * @version Id: AccessDTO, v 0.1 2020\4\20 0020 13:36 Administrator Exp $$
 **/
@Data
public class AccessDTO {
    //设备ID  通过设备ID获取对应的租户信息
    private String machineId;
    //通过卡号获取过闸人员ID
    private String cardNo;
    //过闸时间
    private String timeMills = System.currentTimeMillis()+"";
}
