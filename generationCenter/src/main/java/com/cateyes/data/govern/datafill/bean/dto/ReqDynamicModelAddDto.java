package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单模型(DgDynamicModel)ReqAddDto
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqDynamicModelAddDto {

    @ApiModelProperty(value = "模型名称")
    private String modelName;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "模型介绍")
    private String modelDesc;

    @ApiModelProperty(value = "启用状态：1-启用；2-禁用；")
    private Integer isDisabled;

}
