package com.cateyes.data.govern.bi.bean.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 报表-字段管理(DgBiReportField)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:40
 */
@Data
@ApiModel(value = "报表-字段管理ReqUpdateDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqBiReportFieldUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "报表ID")
    private Integer reportId;

    @ApiModelProperty(value = "数据表名称")
    private String tableName;

    @ApiModelProperty(value = "字段原始名称")
    private String fieldOriginName;

    @ApiModelProperty(value = "字段名称(支持自定义)")
    private String fieldName;

    @ApiModelProperty(value = "字段类型:INT/VARCHAR/DATETIME")
    private String fieldType;

    @ApiModelProperty(value = "字段长度")
    private Integer fieldLength;

    @ApiModelProperty(value = "字段列索引（由0递增）")
    private Integer fieldColumnIndex;

    @ApiModelProperty(value = "类型：1-维度 2-指标")
    private Integer fieldAttribute;

}
