package com.linksame.iot.meeting.entity;


import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 会议信息(IotMeeting)表实体类
 *
 * @author menghuan
 * @since 2021-03-31 17:33:06
 */
@Data
@ApiModel(value = "会议信息实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotMeeting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    /**
     * 会议主题
     */
    @ApiModelProperty(value = "会议主题", name = "name")
    private String name;
    /**
     * 会议事由
     */
    @ApiModelProperty(value = "会议事由", name = "cause")
    private String cause;
    /**
     * 平台租户id
     */
    @ApiModelProperty(value = "平台租户id", name = "tenantId")
    private Integer tenantId;
    /**
     * 会议室(资产结构)id
     */
    @ApiModelProperty(value = "会议室(资产结构)id", name = "roomId")
    private Integer roomId;
    /**
     * 会议主持人id
     */
    @ApiModelProperty(value = "会议主持人id", name = "compereId")
    private Integer compereId;
    /**
     * 会议准备事项负责人id
     */
    @ApiModelProperty(value = "会议准备事项负责人id", name = "preparerId")
    private Integer preparerId;
    /**
     * 发起类型：0-内部 1-外部
     */
    @ApiModelProperty(value = "发起类型：0-内部 1-外部", name = "type")
    private String type;
    /**
     * 会议级别：0-正式 1-临时
     */
    @ApiModelProperty(value = "会议级别：0-正式 1-临时", name = "level")
    private String level;
    /**
     * 会议开始时间
     */
    @ApiModelProperty(value = "会议开始时间", name = "startTime")
    private LocalDateTime startTime;
    /**
     * 会议结束时间
     */
    @ApiModelProperty(value = "会议结束时间", name = "endTime")
    private LocalDateTime endTime;
    /**
     * 会议简介
     */
    @ApiModelProperty(value = "会议简介", name = "introduction")
    private String introduction;
    /**
     * 计费id
     */
    @ApiModelProperty(value = "计费id", name = "billingId")
    private Integer billingId;
    /**
     * 状态：0-待审核 1-准备中 2-延期 3-进行中 4-结束 5-取消 6-驳回
     */
    @ApiModelProperty(value = "状态：0-待审核 1-准备中 2-延期 3-进行中 4-结束 5-取消 6-驳回", name = "status")
    private String status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;
    /**
     * 逻辑删：0-正常 1-删除
     */
    @ApiModelProperty(value = "逻辑删：0-正常 1-删除", name = "delFlag")
    private String delFlag;

}
