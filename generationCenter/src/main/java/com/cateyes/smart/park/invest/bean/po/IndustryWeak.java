package com.cateyes.smart.park.invest.bean.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 产业链节点评价指标设置(SpInIndustryWeak)Po
 *
 * @author CatEyes
 * @since 2023-07-17 11:00:33
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_in_industry_weak")
public class IndustryWeak implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @TableField(value = "industry")
    @ApiModelProperty(value = "产业ID")
    private Integer industry;

    @TableField(value = "industry_second")
    @ApiModelProperty(value = "产业环节ID")
    private Integer industrySecond;

    @TableField(value = "industry_node")
    @ApiModelProperty(value = "产业节点ID")
    private Integer industryNode;

    @TableField(value = "industrial_total_output")
    @ApiModelProperty(value = "工业总产值")
    private Double industrialTotalOutput;

    @TableField(value = "growth_total_output")
    @ApiModelProperty(value = "总产值增速")
    private Double growthTotalOutput;

    @TableField(value = "industrial_added_value")
    @ApiModelProperty(value = "工业增加值")
    private Double industrialAddedValue;

    @TableField(value = "growth_industrial_added")
    @ApiModelProperty(value = "工业增加值增速")
    private Double growthIndustrialAdded;

    @TableField(value = "tax_revenue")
    @ApiModelProperty(value = "企业税收（月平均）")
    private Double taxRevenue;

    @TableField(value = "total_patent_invention")
    @ApiModelProperty(value = "发明专利（累计）")
    private Double totalPatentInvention;

    @TableField(value = "total_scale_above")
    @ApiModelProperty(value = "规上企业数")
    private Double totalScaleAbove;

    @TableField(value = "total_market")
    @ApiModelProperty(value = "上市企业数")
    private Double totalMarket;

    @TableField(value = "industrial_investment")
    @ApiModelProperty(value = "工业投资（月平均）")
    private Double industrialInvestment;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
