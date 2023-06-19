package com.cateyes.smart.park.safe.bean.dto;

import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 构筑物(SpSfPatrolStructure)ReqDto
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqPatrolStructureDto extends BaseDto {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "所属企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "作业名称")
    private String structureName;

    @ApiModelProperty(value = "作业编号（手填）")
    private String structureCode;

    @ApiModelProperty(value = "区域位置（手填）")
    private String region;

    @ApiModelProperty(value = "巡检类型：0-园区巡检 1-非园区去巡检")
    private Integer type;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
