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
 * 合同基本信息表(SpContract)Po
 *
 * @author CatEyes
 * @since 2023-05-08 10:07:39
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_contract")
public class Contract implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "company_id")
    private Integer companyId;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "name")
    private String name;

    @TableField(value = "serial_number")
    private String serialNumber;

    @TableField(value = "state")
    private Integer state;

    @TableField(value = "file_id")
    private String fileId;

    @TableField(value = "file_signed_id")
    private String fileSignedId;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT)
    private Integer updateBy;

    @TableField(value = "update_time", fill = FieldFill.INSERT)
    private Date updateTime;

    @TableField(value = "filing_time")
    private Date filingTime;

}
