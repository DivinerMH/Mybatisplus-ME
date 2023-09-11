package com.cateyes.smart.park.report.bean.dto;

import java.util.Date;

import com.cateyes.smart.park.base.BaseDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业亩均效益指标设置(SpEnterpriseMuBenefitTarget)ReqDto
 *
 * @author CatEyes
 * @since 2023-07-21 15:43:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqEnterpriseMuBenefitTargetDto extends BaseDto {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "指标")
    private String targetValue;

    @ApiModelProperty(value = "基准值")
    private Double fiducialValue;

    @ApiModelProperty(value = "权重（%）")
    private Double weightValue;

    @ApiModelProperty(value = "备注说明")
    private String remark;

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
