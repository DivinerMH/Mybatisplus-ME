package com.cateyes.data.govern.bi.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据集-字段管理(DgBiDatasetField)ReqAddDto
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:44
 */
@Data
@ApiModel(value = "数据集-字段管理ReqAddDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqBiDatasetFieldAddDto {

    @ApiModelProperty(value = "数据集ID")
    private Integer datasetId;

    @ApiModelProperty(value = "类型：1-维度 2-指标")
    private Integer type;

    @ApiModelProperty(value = "数据表名称")
    private String tableName;

    @ApiModelProperty(value = "字段原始名称")
    private String fieldOriginName;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段类型")
    private String fieldType;

    @ApiModelProperty(value = "字段长度")
    private Integer fieldLength;

    @ApiModelProperty(value = "字段列索引（由0递增）")
    private Integer fieldColumnIndex;

}
