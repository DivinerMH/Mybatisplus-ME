package com.cateyes.smart.park.invest.bean.dto;

    
    






import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 招商线索列表(SpInvestmentLead)ReqDto
 *
 * @author CatEyes
 * @since 2023-05-08 10:15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqInvestmentLeadDto extends BaseDto {

    @ApiModelProperty(value = "主键id")
    private Integer id;
    
    @ApiModelProperty(value = "园区id")
    private Integer parkId;
    
    @ApiModelProperty(value = "名称")
    private String name;
    
    @ApiModelProperty(value = "线索编码")
    private String serialNumber;
    
    @ApiModelProperty(value = "联系人")
    private String contactPerson;
    
    @ApiModelProperty(value = "联系电话")
    private String contactTel;
    
    @ApiModelProperty(value = "线索来源")
    private Integer wayFromId;
    
    @ApiModelProperty(value = "渠道类型")
    private Integer wayChannelId;
    
    @ApiModelProperty(value = "跟进人")
    private Integer follow;
    
    @ApiModelProperty(value = "创建人")
    private Integer createBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    

}
