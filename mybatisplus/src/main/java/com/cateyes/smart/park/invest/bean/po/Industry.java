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
import java.util.Date;

/**
 * 产业-产业环节-产业节点信息表(SpIndustry)Po
 *
 * @author CatEyes
 * @since 2023-04-19 14:23:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_industry")
public class Industry implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "parent")
        private Integer parent;
    
            @TableField(value = "name")
        private String name;
    
            @TableField(value = "info")
        private String info;
    
            @TableField(value = "path")
        private String path;
    
            @TableField(value = "is_lead")
        private Boolean isLead;
    
}
