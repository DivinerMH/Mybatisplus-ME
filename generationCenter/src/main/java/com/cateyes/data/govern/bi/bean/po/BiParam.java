package com.cateyes.data.govern.bi.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.base.mybatis.MetaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 參數(DgBiParam)Po
 *
 * @author CatEyes
 * @since 2024-01-23 12:01:18
 */
@Data
@ApiModel(value = "參數Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_bi_param")
public class BiParam extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类型：1-数据集 2-报表")
    private Integer type;

    @ApiModelProperty(value = "资源ID")
    private Integer resourceId;

    @ApiModelProperty(value = "参数键")
    private String paramKey;

    @ApiModelProperty(value = "参数值")
    private String paramValue;

    @ApiModelProperty(value = "参数默认值")
    private String paramValueDefault;

    @ApiModelProperty(value = "参数排序")
    private Integer paramSort;

    @ApiModelProperty(value = "参数描述")
    private String paramDesc;

}
