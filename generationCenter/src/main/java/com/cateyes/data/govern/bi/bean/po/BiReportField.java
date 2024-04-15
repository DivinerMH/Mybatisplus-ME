package com.cateyes.data.govern.bi.bean.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.cateyes.base.mybatis.MetaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 报表-字段管理(DgBiReportField)Po
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:39
 */
@Data
@ApiModel(value = "报表-字段管理Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_bi_report_field")
public class BiReportField extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
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
