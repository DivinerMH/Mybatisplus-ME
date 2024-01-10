package com.cateyes.data.govern.datafill.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 项目(DgBiProject)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:46
 */
@Data
@ApiModel(value = "项目ReqUpdateDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqBiProjectUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目简介")
    private String projectDesc;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
