package com.cateyes.smart.park.report.bean.dto;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)ReqAddDto
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:38
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商项目-产业项目分布ReqAddDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqVtBsInvestmentItemIndustryAddDto {

    @ApiModelProperty(value = "招商项目Id")
    private Integer investmentItemId;

    @ApiModelProperty(value = "产业名称")
    private String industryName;

    @ApiModelProperty(value = "已签约项目数(个)")
    private Integer projectSignTotal;

    @ApiModelProperty(value = "已签约项目金额(万元)")
    private Double projectSignAmountTotal;

}
