package com.cateyes.dis.micro.oper.bean.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业科技成果(DisEnterpriseTechAchieve)Po
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:44
 */
@Data
@ApiModel(value = "企业科技成果Po")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("dis_enterprise_tech_achieve")
public class EnterpriseTechAchieve extends MetaData {

    @TableId(value = "id", type = IdType.AUTO)
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

}
