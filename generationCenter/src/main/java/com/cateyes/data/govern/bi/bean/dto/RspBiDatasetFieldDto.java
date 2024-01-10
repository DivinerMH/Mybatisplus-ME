package com.cateyes.data.govern.bi.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 数据集-字段管理(DgBiDatasetField)RspDto
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:45
 */
@Data
@ApiModel(value = "数据集-字段管理RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspBiDatasetFieldDto implements Serializable {

    @ApiModelProperty(value = "ID")
    private Integer id;

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

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    /*-----------------------------非数据库属性------------------------------*/

}
