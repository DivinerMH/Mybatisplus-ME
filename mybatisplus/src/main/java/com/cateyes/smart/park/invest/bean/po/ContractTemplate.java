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
 * 合同模板表(SpContractTemplate)Po
 *
 * @author CatEyes
 * @since 2023-05-08 10:04:26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_contract_template")
public class ContractTemplate implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "park_id")
        private Integer parkId;
    
            @TableField(value = "name")
        private String name;
    
            @TableField(value = "file_id")
        private String fileId;
    
            @TableField(value = "create_by",fill = FieldFill.INSERT )
        private Integer createBy;
    
            @TableField(value = "create_time",fill = FieldFill.INSERT )
        private Date createTime;
    
}
