package com.linksame.iot.meeting.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 会议准备(IotPreparation)表实体类
 *
 * @author menghuan
 * @since 2021-03-20 16:29:55
 */
@Data
@ApiModel(value = "会议准备实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotPreparation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    /**
     * 会议id
     */
    @ApiModelProperty(value = "会议id", name = "meetingId")
    private Object meetingId;
    /**
     * 准备事项id
     */
    @ApiModelProperty(value = "准备事项id", name = "itemsId")
    private Integer itemsId;
    /**
     * 会议准备事项名称
     */
    @ApiModelProperty(value = "会议准备事项名称", name = "name")
    private String name;
    /**
     * 详情描述
     */
    @ApiModelProperty(value = "详情描述", name = "description")
    private String description;
    /**
     * 状态：0-待准备 1-已准备 2-其他
     */
    @ApiModelProperty(value = "状态：0-待准备 1-已准备 2-其他", name = "status")
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