package com.cateyes.smart.park.invest.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产业链节点评价指标设置(SpInIndustryWeak)RspDto
 *
 * @author CatEyes
 * @since 2023-07-17 11:00:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspIndustryWeakDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "产业ID")
    private Integer industry;

    @ApiModelProperty(value = "产业环节ID")
    private Integer industrySecond;

    @ApiModelProperty(value = "产业节点ID")
    private Integer industryNode;

    @ApiModelProperty(value = "工业总产值")
    private Double industrialTotalOutput;

    @ApiModelProperty(value = "总产值增速")
    private Double growthTotalOutput;

    @ApiModelProperty(value = "工业增加值")
    private Double industrialAddedValue;

    @ApiModelProperty(value = "工业增加值增速")
    private Double growthIndustrialAdded;

    @ApiModelProperty(value = "企业税收（月平均）")
    private Double taxRevenue;

    @ApiModelProperty(value = "发明专利（累计）")
    private Double totalPatentInvention;

    @ApiModelProperty(value = "规上企业数")
    private Double totalScaleAbove;

    @ApiModelProperty(value = "上市企业数")
    private Double totalMarket;

    @ApiModelProperty(value = "工业投资（月平均）")
    private Double industrialInvestment;

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
