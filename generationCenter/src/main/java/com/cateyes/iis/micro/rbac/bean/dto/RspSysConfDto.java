package com.cateyes.iis.micro.rbac.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统配置表(IisSysConf)RspDto
 *
 * @author CatEyes
 * @since 2023-11-13 11:49:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspSysConfDto implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "配置项")
    private String confKey;

    @ApiModelProperty(value = "配置值")
    private String confValue;

    @ApiModelProperty(value = "配置说明")
    private String confDesc;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    /*-----------------------------非数据库属性------------------------------*/

}
