package com.cateyes.smart.park.safe.bean.dto;

import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 巡检任务(SpSfPatrolTask)ReqDto
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqPatrolTaskDto extends BaseDto {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "巡检点ID")
    private Integer pointId;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "任务编号")
    private String taskCode;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "目标完成时间（分钟）")
    private Integer timeConsuming;

    @ApiModelProperty(value = "启用状态：0-禁用 1-启用")
    private Boolean enable;

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
