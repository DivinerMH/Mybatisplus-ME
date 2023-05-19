package com.cateyes.smart.park.invest.bean.po;

    
    


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 招商线索列表(SpInvestmentLead)Po
 *
 * @author CatEyes
 * @since 2023-05-08 10:15:31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_investment_lead")
public class InvestmentLead implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "park_id")
        private Integer parkId;
    
            @TableField(value = "name")
        private String name;
    
            @TableField(value = "serial_number")
        private String serialNumber;
    
            @TableField(value = "contact_person")
        private String contactPerson;
    
            @TableField(value = "contact_tel")
        private String contactTel;
    
            @TableField(value = "way_from_id")
        private Integer wayFromId;
    
            @TableField(value = "way_channel_id")
        private Integer wayChannelId;
    
            @TableField(value = "follow")
        private Integer follow;
    
            @TableField(value = "create_by",fill = FieldFill.INSERT )
        private Integer createBy;
    
            @TableField(value = "create_time",fill = FieldFill.INSERT )
        private Date createTime;
    
}
