package com.cateyes.data.govern.datafill.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.base.mybatis.MetaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 项目(DgBiProject)Po
 *
 * @author CatEyes
 * @since 2023-12-12 16:05:45
 */
@Data
@ApiModel(value = "项目Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dg_bi_project")
public class BiProject extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目简介")
    private String projectDesc;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
