package com.cateyes.smart.park.safe.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 巡检点(SpSfPatrolPoint)RspDto
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspPatrolPointDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "构筑物ID")
    private Integer structureId;

    @ApiModelProperty(value = "作业名称")
    private String pointName;

    @ApiModelProperty(value = "作业编号")
    private String structureCode;

    @ApiModelProperty(value = "所属企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "计划类型：0-每日1次 1-每周一次")
    private Integer planType;

    @ApiModelProperty(value = "计划首次时间")
    private Date planFirstTime;

    @ApiModelProperty(value = "执行人")
    private String executorIds;

    @ApiModelProperty(value = "启用状态：0-禁用 1-启用")
    private Boolean enable;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "操作手册")
    private String manualFileIds;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
