package com.hzcloud.iot.meeting.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会议签到表
 * </p>
 *
 * @author menghuan
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotRegister implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议id
     */
    private String meetingId;

    /**
     * 会议参与人id
     */
    private Integer userId;

    /**
     * 详情描述
     */
    private String description;

    /**
     * 状态：0-未进园区 1-已进园区 2-已签到 3-逾期
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
