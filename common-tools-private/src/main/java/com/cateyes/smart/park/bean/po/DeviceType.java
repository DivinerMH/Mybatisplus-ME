package com.cateyes.smart.park.bean.po;

    
    






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
 * (SpIotDeviceType)Po
 *
 * @author CatEyes
 * @since 2023-05-19 15:32:47
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_iot_device_type")
public class DeviceType implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "park_id")
        private Integer parkId;
    
            @TableField(value = "parent_id")
        private Integer parentId;
    
            @TableField(value = "type_name")
        private String typeName;
    
            @TableField(value = "is_disabled")
        private Integer isDisabled;
    
            @TableField(value = "create_at")
        private Date createAt;
    
            @TableField(value = "create_by",fill = FieldFill.INSERT )
        private String createBy;
    
}
