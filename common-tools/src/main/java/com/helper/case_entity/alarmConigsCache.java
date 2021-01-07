package com.hzcloud.iot.alarm.cache;

import com.hzcloud.iot.alarm.entity.IotAlarmMachineRelation;
import com.hzcloud.iot.alarm.entity.IotAlarmRuleMachineProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 业务配置，缓存对象
 *
 * @author cyl
 * @since 2020-07-22 10:43:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class AlarmCache implements Serializable {

    private static final long serialVersionUID = 3870927632803751641L;

    /**
     * 主键ID
     */
    private Integer alarmId;

    /**
     * 产品ID
     */
    private Integer proId;

    /**
     * 报警标题
     */
    private String alarmTitle;

    /**
     * 报警内容
     */
    private String alarmContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


    /**
     * 0 正常 1逻辑删除
     */
    private String delFlag;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 是否生成对应的小应用 0否 1是
     */
    private String hasApp;

    /**
     * 0 禁用  1启用
     */
    private String status;

    /**
     * 告警规则对应的状态
     */
    @ApiModelProperty(value = "告警规则研判的状态", name = "businessStatus")
    private String businessStatus;

    /**
     * 报警设备条件 (设备应满足的条件)
     */
    private List<IotAlarmRuleMachineProperty> machinePropertyRules;

    /**
     * 设备列表
     */
    private List<IotAlarmMachineRelation> machines;

    /**
     * 紧急程度 1-5
     */
    private String alarmDegree;

    /**
     * 条件连接符
     */
    @ApiModelProperty(value = "条件连接符", name = "conditionRelation")
    private String conditionRelation;

}
