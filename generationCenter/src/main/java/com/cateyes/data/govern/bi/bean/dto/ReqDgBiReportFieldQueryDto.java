package com.cateyes.data.govern.bi.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 报表-字段管理(DgBiReportField)ReqQueryDto
 *
 * @author CatEyes
 * @since 2024-03-19 14:40:05
 */
@Data
@ApiModel(value = "报表-字段管理ReqQueryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqDgBiReportFieldQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "ID")
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
