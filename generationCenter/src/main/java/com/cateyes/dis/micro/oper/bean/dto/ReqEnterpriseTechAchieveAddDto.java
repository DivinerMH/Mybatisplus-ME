package com.cateyes.dis.micro.oper.bean.dto;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 企业科技成果(DisEnterpriseTechAchieve)ReqAddDto
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:44
 */
@Data
@ApiModel(value = "企业科技成果ReqAddDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqEnterpriseTechAchieveAddDto {

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
