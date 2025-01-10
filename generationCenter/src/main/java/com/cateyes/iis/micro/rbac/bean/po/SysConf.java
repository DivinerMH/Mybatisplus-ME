package com.cateyes.iis.micro.rbac.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.base.mybatis.MetaData;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 系统配置表(IisSysConf)Po
 *
 * @author CatEyes
 * @since 2023-11-13 11:49:39
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("iis_sys_conf")
public class SysConf extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "配置项")
    private String confKey;

    @ApiModelProperty(value = "配置值")
    private String confValue;

    @ApiModelProperty(value = "配置说明")
    private String confDesc;

}
