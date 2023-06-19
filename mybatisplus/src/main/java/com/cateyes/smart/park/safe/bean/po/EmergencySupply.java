package com.cateyes.smart.park.safe.bean.po;

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
 * 应急物资(SpSfEmergencySupply)Po
 *
 * @author CatEyes
 * @since 2023-06-05 11:51:26
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_sf_emergency_supply")
public class EmergencySupply implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "enterprise_id")
    private Integer enterpriseId;

    @TableField(value = "supply_name")
    private String supplyName;

    @TableField(value = "supply_code")
    private String supplyCode;

    @TableField(value = "unit")
    private String unit;

    @TableField(value = "amount")
    private Integer amount;

    @TableField(value = "longitude")
    private Double longitude;

    @TableField(value = "latitude")
    private Double latitude;

    @TableField(value = "region_id")
    private Integer regionId;

    @TableField(value = "charge_person")
    private String chargePerson;

    @TableField(value = "charge_person_phone")
    private String chargePersonPhone;

    @TableField(value = "consume_status")
    private Integer consumeStatus;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

}
