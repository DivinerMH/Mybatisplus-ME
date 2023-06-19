package com.cateyes.smart.park.safe.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 应急预案(SpSfEmergencyPlan)RspDto
 *
 * @author CatEyes
 * @since 2023-06-05 11:50:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspEmergencyPlanDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "预案名称")
    private String planName;

    @ApiModelProperty(value = "预案编号")
    private String planCode;

    @ApiModelProperty(value = "附件")
    private String attachmentFileIds;

    @ApiModelProperty(value = "启用状态：1-启用；0-禁用；")
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
