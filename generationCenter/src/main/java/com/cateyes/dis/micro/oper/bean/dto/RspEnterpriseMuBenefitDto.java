package com.cateyes.dis.micro.oper.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业亩均效益(DisEnterpriseMuBenefit)RspDto
 *
 * @author CatEyes
 * @since 2024-02-01 18:31:31
 */
@Data
@ApiModel(value = "企业亩均效益RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspEnterpriseMuBenefitDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "园区企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "年月日期")
    private Date date;

    @ApiModelProperty(value = "土地面积（亩）")
    private Double landArea;

    @ApiModelProperty(value = "亩均产值（万元/亩）")
    private Double outputPerMu;

    @ApiModelProperty(value = "亩均税收（万元/亩）")
    private Double taxPerMu;

    @ApiModelProperty(value = "亩均工业增加值（万元/亩）")
    private Double industrialGrowthPerMu;

    @ApiModelProperty(value = "单位能耗营业收入（万元/吨标煤）")
    private Double operatingEnergyIncome;

    @ApiModelProperty(value = "亩均营业收入（万元/亩）")
    private Double operationRevenuePerMu;

    @ApiModelProperty(value = "全员劳动生产率（万元/人）")
    private Double overallLabourProductivity;

    @ApiModelProperty(value = "R&D经费支出占营业收入比例（%）")
    private Double ratioExpenditureRevenue;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    /*-----------------------------非数据库属性------------------------------*/

}
