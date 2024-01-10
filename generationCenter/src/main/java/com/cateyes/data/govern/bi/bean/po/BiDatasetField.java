package com.cateyes.data.govern.bi.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.cateyes.base.mybatis.MetaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 数据集-字段管理(DgBiDatasetField)Po
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:44
 */
@Data
@ApiModel(value = "数据集-字段管理Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_bi_dataset_field")
public class BiDatasetField extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
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

}
