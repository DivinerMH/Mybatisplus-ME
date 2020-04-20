package com.hzcloud.iot.meeting.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会议信息表
 * </p>
 *
 * @author menghuan
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotMeeting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议主题
     */
    private String name;

    /**
     * 会议事由
     */
    private String cause;

    /**
     * 房源id
     */
    private Integer resourcesId;

    /**
     * 会议准备id
     */
    private Integer preparationId;

    /**
     * 签到id
     */
    private Integer registerId;

    /**
     * 发起类型：0-内部 1-外部
     */
    private String type;

    /**
     * 会议开始时间
     */
    private LocalDateTime startTime;

    /**
     * 会议结束时间
     */
    private LocalDateTime endTime;

    /**
     * 会议简介
     */
    private String introduction;

    /**
     * 状态：0-等待 1-进行中 2-延期 3-取消
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删：0-正常 1-删除
     */
    private String delFlag;


}
