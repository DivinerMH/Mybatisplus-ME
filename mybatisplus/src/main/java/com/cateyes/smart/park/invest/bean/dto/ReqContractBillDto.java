package com.cateyes.smart.park.invest.bean.dto;

    
    






import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同费用项(SpContractBill)ReqDto
 *
 * @author CatEyes
 * @since 2023-04-14 10:34:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqContractBillDto extends BaseDto {

    @ApiModelProperty(value = "主键id")
    private Integer id;
    
    @ApiModelProperty(value = "合同id")
    private Integer contractId;
    
    @ApiModelProperty(value = "名称")
    private String name;
    
    @ApiModelProperty(value = "资源id")
    private Integer resourcesId;
    
    @ApiModelProperty(value = "资源面积")
    private BigDecimal resourcesArea;
    
    @ApiModelProperty(value = "单价类型：0-元/米·月 1-元/米 2-元/亩·月 3-元/亩")
    private Integer priceUnitType;
    
    @ApiModelProperty(value = "单价")
    private BigDecimal priceUnit;
    
    @ApiModelProperty(value = "总价")
    private BigDecimal priceTotal;
    
    @ApiModelProperty(value = "付款方式：0-全款 1-首付/月供")
    private Integer payWay;
    
    @ApiModelProperty(value = "首付比例")
    private String payRatio;
    
    @ApiModelProperty(value = "月供")
    private BigDecimal payMonthly;
    
    @ApiModelProperty(value = "押金")
    private BigDecimal cashPledge;
    
    @ApiModelProperty(value = "签约日期")
    private Date dateContract;
    
    @ApiModelProperty(value = "开始日期")
    private Date dateStart;
    
    @ApiModelProperty(value = "结束日期")
    private Date dateEnd;
    
    @ApiModelProperty(value = "是否含税：0-false 1-true")
    private Boolean isTax;
    
    @ApiModelProperty(value = "甲方承担税率")
    private BigDecimal taxRateFirst;
    
    @ApiModelProperty(value = "乙方承担税率")
    private BigDecimal taxRateSecond;
    
    @ApiModelProperty(value = "免租期")
    private Integer rentFree;
    

}
