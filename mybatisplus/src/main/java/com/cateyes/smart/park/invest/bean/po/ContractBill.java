package com.cateyes.smart.park.invest.bean.po;

    
    


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同费用项(SpContractBill)Po
 *
 * @author CatEyes
 * @since 2023-04-14 10:34:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_contract_bill")
public class ContractBill implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "contract_id")
        private Integer contractId;
    
            @TableField(value = "name")
        private String name;
    
            @TableField(value = "resources_id")
        private Integer resourcesId;
    
            @TableField(value = "resources_area")
        private BigDecimal resourcesArea;
    
            @TableField(value = "price_unit_type")
        private Integer priceUnitType;
    
            @TableField(value = "price_unit")
        private BigDecimal priceUnit;
    
            @TableField(value = "price_total")
        private BigDecimal priceTotal;
    
            @TableField(value = "pay_way")
        private Integer payWay;
    
            @TableField(value = "pay_ratio")
        private String payRatio;
    
            @TableField(value = "pay_monthly")
        private BigDecimal payMonthly;
    
            @TableField(value = "cash_pledge")
        private BigDecimal cashPledge;
    
            @TableField(value = "date_contract")
        private Date dateContract;
    
            @TableField(value = "date_start")
        private Date dateStart;
    
            @TableField(value = "date_end")
        private Date dateEnd;
    
            @TableField(value = "is_tax")
        private Boolean isTax;
    
            @TableField(value = "tax_rate_first")
        private BigDecimal taxRateFirst;
    
            @TableField(value = "tax_rate_second")
        private BigDecimal taxRateSecond;
    
            @TableField(value = "rent_free")
        private Integer rentFree;
    
}
