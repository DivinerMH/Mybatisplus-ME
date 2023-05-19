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
 * 企业库表(SpCompany)Po
 *
 * @author CatEyes
 * @since 2023-05-08 10:40:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_company")
public class Company implements Serializable  {



            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
    
            @TableField(value = "park_id")
        private Integer parkId;
    
            @TableField(value = "name")
        private String name;
    
            @TableField(value = "type")
        private Integer type;
    
            @TableField(value = "contact_person")
        private String contactPerson;
    
            @TableField(value = "contact_tel")
        private String contactTel;
    
            @TableField(value = "company_url")
        private String companyUrl;
    
            @TableField(value = "company_address")
        private String companyAddress;
    
            @TableField(value = "email")
        private String email;
    
            @TableField(value = "fax")
        private String fax;
    
            @TableField(value = "trade_id")
        private Integer tradeId;
    
            @TableField(value = "industry")
        private Integer industry;
    
            @TableField(value = "industry_second")
        private Integer industrySecond;
    
            @TableField(value = "industry_node")
        private Integer industryNode;
    
            @TableField(value = "land_area")
        private BigDecimal landArea;
    
            @TableField(value = "building_area")
        private BigDecimal buildingArea;
    
            @TableField(value = "is_buy")
        private Boolean isBuy;
    
            @TableField(value = "way_channel_id")
        private Integer wayChannelId;
    
            @TableField(value = "way_clue_id")
        private Integer wayClueId;
    
            @TableField(value = "scale")
        private Integer scale;
    
            @TableField(value = "qualification")
        private Integer qualification;
    
            @TableField(value = "stage")
        private Integer stage;
    
            @TableField(value = "gl_type")
        private Boolean glType;
    
            @TableField(value = "is_key")
        private Boolean isKey;
    
            @TableField(value = "is_ipo")
        private Boolean isIpo;
    
            @TableField(value = "is_scale_above")
        private Boolean isScaleAbove;
    
            @TableField(value = "scale_above_date")
        private Date scaleAboveDate;
    
            @TableField(value = "logo_file_id")
        private String logoFileId;
    
            @TableField(value = "pic_file_id")
        private String picFileId;
    
            @TableField(value = "info")
        private String info;
    
            @TableField(value = "longitude")
        private String longitude;
    
            @TableField(value = "latitude")
        private String latitude;
    
            @TableField(value = "follow")
        private Integer follow;
    
            @TableField(value = "create_by",fill = FieldFill.INSERT )
        private Integer createBy;
    
            @TableField(value = "create_time",fill = FieldFill.INSERT )
        private Date createTime;
    
            @TableField(value = "update_by",fill = FieldFill.INSERT )
        private Integer updateBy;
    
            @TableField(value = "update_time",fill = FieldFill.INSERT )
        private Date updateTime;
    
}
