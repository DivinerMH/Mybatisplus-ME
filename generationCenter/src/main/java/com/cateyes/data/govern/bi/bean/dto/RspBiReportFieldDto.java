package com.cateyes.data.govern.bi.bean.dto;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 报表-字段管理(DgBiReportField)RspDto
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:40
 */
@Data
@ApiModel(value = "报表-字段管理RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspBiReportFieldDto implements Serializable {

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
