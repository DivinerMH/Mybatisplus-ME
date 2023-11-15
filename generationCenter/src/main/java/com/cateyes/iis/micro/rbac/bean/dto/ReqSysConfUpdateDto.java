package com.cateyes.iis.micro.rbac.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 系统配置表(IisSysConf)ReqUpdateDto
 *
 * @author CatEyes
 * @since 2023-11-13 11:49:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqSysConfUpdateDto {

    @NotNull(message = "主键ID不可为NULL")
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "配置项")
    private String confKey;

    @ApiModelProperty(value = "配置值")
    private String confValue;

    @ApiModelProperty(value = "配置说明")
    private String confDesc;

}
