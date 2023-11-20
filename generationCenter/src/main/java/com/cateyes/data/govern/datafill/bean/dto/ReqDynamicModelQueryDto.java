package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 动态表单模型(DgDynamicModel)ReqQueryDto
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqDynamicModelQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "主键")
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
