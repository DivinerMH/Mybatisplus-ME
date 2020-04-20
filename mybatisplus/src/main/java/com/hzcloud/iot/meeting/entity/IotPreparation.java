package com.hzcloud.iot.meeting.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会议准备表
 * </p>
 *
 * @author menghuan
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotPreparation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 准备事项名称
     */
    private String name;

    /**
     * 会议id
     */
    private Integer meetingId;

    /**
     * 会议准备负责人
     */
    private Integer userId;

    /**
     * 详情描述
     */
    private String description;

    /**
     * 状态：0-待准备 1-已准备 2-其他
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
