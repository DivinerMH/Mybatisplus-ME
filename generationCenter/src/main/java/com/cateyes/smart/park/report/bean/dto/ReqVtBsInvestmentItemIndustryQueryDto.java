package com.cateyes.smart.park.report.bean.dto;

import com.base.dto.ReqBaseQueryDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)ReqQueryDto
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:39
 */
@Data
@ApiModel(value = "智慧大屏-手工-招商项目-产业项目分布ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqVtBsInvestmentItemIndustryQueryDto extends ReqBaseQueryDto {

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

}
