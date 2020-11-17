package com.hzcloud.iot.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 巡检节点(DangerNode)表实体类
 *
 * @author MH
 * @since 2020-11-13 16:01:15
 */
@Data
@ApiModel(value = "巡检节点实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DangerNode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键/自增/唯一
     */
    @ApiModelProperty(value = "主键/自增/唯一", name = "id")
    private Integer id;
    /**
     * 巡检计划id
     */
    @ApiModelProperty(value = "巡检计划id", name = "inspectionId")
    private Integer inspectionId;
    /**
     * 节点名称
     */
    @ApiModelProperty(value = "节点名称", name = "nodeName")
    private String nodeName;
    /**
     * 资产结构id
     */
    @ApiModelProperty(value = "资产结构id", name = "structureId")
    private Integer structureId;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址", name = "addr")
    private String addr;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", name = "sort")
    private Integer sort;
    /**
     * 状态：0-未巡检 1-已巡检
     */
    @ApiModelProperty(value = "状态：0-未巡检 1-已巡检", name = "status")
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
     * 逻辑删除(0=正常,1=删除)
     */
    @ApiModelProperty(value = "逻辑删除(0=正常,1=删除)", name = "delFlag")
    private String delFlag;

}