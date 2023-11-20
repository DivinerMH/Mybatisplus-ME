package com.cateyes.data.govern.datafill.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单模型(DgDynamicModel)Po
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_dynamic_model")
public class DynamicModel extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "模型名称")
    private String modelName;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "模型介绍")
    private String modelDesc;

    @ApiModelProperty(value = "启用状态：1-启用；2-禁用；")
    private Integer isDisabled;

}
