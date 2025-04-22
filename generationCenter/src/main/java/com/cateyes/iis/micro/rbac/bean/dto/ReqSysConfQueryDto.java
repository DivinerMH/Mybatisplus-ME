package com.cateyes.iis.micro.rbac.bean.dto;

import com.base.dto.ReqBaseQueryDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 系统配置表(IisSysConf)ReqQueryDto
 *
 * @author CatEyes
 * @since 2023-11-13 11:49:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReqSysConfQueryDto extends ReqBaseQueryDto {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "配置项")
    private String confKey;

    @ApiModelProperty(value = "配置值")
    private String confValue;

    @ApiModelProperty(value = "配置说明")
    private String confDesc;

}
