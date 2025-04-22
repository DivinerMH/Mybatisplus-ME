package com.cateyes.smart.park.resource.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业亩均效益分析-企业得分(SpEnterpriseMuBenefitAnalysis)RspDto
 *
 * @author CatEyes
 * @since 2023-07-25 15:55:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspEnterpriseMuBenefitAnalysisDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "园区企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月")
    private Integer month;

    @ApiModelProperty(value = "年月日期")
    private Date date;

    @ApiModelProperty(value = "企业档位ID")
    private Integer gearValueId;

    @ApiModelProperty(value = "亩均效益得分")
    private Double benefitScore;

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
