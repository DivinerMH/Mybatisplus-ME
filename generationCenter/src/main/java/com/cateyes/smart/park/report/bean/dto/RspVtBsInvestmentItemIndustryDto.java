package com.cateyes.smart.park.report.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)RspDto
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:39
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商项目-产业项目分布RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspVtBsInvestmentItemIndustryDto implements Serializable {

    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "招商项目Id")
    private Integer investmentItemId;

    @ApiModelProperty(value = "产业名称")
    private String industryName;

    @ApiModelProperty(value = "已签约项目数(个)")
    private Integer projectSignTotal;

    @ApiModelProperty(value = "已签约项目金额(万元)")
    private Double projectSignAmountTotal;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /*-----------------------------非数据库属性------------------------------*/

}
