package com.cateyes.data.govern.datafill.bean.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表单实例(DgFormInst)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqFormInstUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "模型ID")
    private Integer modelId;

    @ApiModelProperty(value = "模型配置")
    private String modelSetting;

}
