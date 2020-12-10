package com.hzcloud.iot.alarm.cache;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 业务配置，缓存对象
 * @author cyl
 * @since 2020-07-22 10:43:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class StructureStatusCache implements Serializable {

    private static final long serialVersionUID = 3870927632803751641L;


    /**资产结构ID*/
    private Integer structureId;

    /**报警内容 */
    private String status;

    /**状态时间*/
    private Long timeMilles;

    /**紧急程度 1-2 1一般  2严重*/
    private String alarmDegree;

}
