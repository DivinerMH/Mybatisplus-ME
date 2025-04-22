package com.cateyes.dis.micro.oper.bean.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业科技成果(DisEnterpriseTechAchieve)RspDto
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:45
 */
@Data
@ApiModel(value = "企业科技成果RspDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RspEnterpriseTechAchieveDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "园区企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "日期")
    private Date date;

    @ApiModelProperty(value = "商标")
    private Integer trademark;

    @ApiModelProperty(value = "专利")
    private Integer patent;

    @ApiModelProperty(value = "发明专利")
    private Integer inventionPatent;

    @ApiModelProperty(value = "国际专利")
    private Integer internationalPatent;

    @ApiModelProperty(value = "著作权")
    private Integer copyright;

    @ApiModelProperty(value = "科技成果")
    private Integer techAchievement;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;

    /*-----------------------------非数据库属性------------------------------*/

}
