package com.cateyes.smart.park.resource.bean.po;

    
    






import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业产值(SpEnterpriseOutput)Po
 *
 * @author CatEyes
 * @since 2023-05-19 10:23:17
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_enterprise_output")
public class SpEnterpriseOutput implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "park_id")
        private Integer parkId;
    
            @TableField(value = "enterprise_id")
        private Integer enterpriseId;
    
            @TableField(value = "month")
        private Date month;
    
            @TableField(value = "out_put")
        private Double outPut;
    
            @TableField(value = "out_put_increase")
        private Double outPutIncrease;
    
            @TableField(value = "report_time")
        private Date reportTime;
    
            @TableField(value = "create_by",fill = FieldFill.INSERT )
        private Integer createBy;
    
            @TableField(value = "create_time",fill = FieldFill.INSERT )
        private Date createTime;
    
            @TableField(value = "update_by",fill = FieldFill.INSERT )
        private Integer updateBy;
    
            @TableField(value = "update_time",fill = FieldFill.INSERT )
        private Date updateTime;
    
}
