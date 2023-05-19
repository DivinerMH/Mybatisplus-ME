package com.cateyes.smart.park.resource.bean.dto;

    
    





import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 企业产值(SpEnterpriseOutput)RspDto
 *
 * @author CatEyes
 * @since 2023-05-19 10:23:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspSpEnterpriseOutputDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;
    
    @ApiModelProperty(value = "园区ID")
    private Integer parkId;
    
    @ApiModelProperty(value = "园区企业ID")
    private Integer enterpriseId;
    
    @ApiModelProperty(value = "年度/月")
    private Date month;
    
    @ApiModelProperty(value = "本月工业总产值（万元）")
    private Double outPut;
    
    @ApiModelProperty(value = "本月工业增加值（万元）")
    private Double outPutIncrease;
    
    @ApiModelProperty(value = "上报时间")
    private Date reportTime;
    
    @ApiModelProperty(value = "创建人")
    private Integer createBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    @ApiModelProperty(value = "更新人")
    private Integer updateBy;
    
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    

}
