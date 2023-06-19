package com.cateyes.smart.park.safe.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 应急物资(SpSfEmergencySupply)RspDto
 *
 * @author CatEyes
 * @since 2023-06-05 11:51:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspEmergencySupplyDto implements Serializable {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "所属企业ID")
    private Integer enterpriseId;

    @ApiModelProperty(value = "物资名称")
    private String supplyName;

    @ApiModelProperty(value = "物资编号")
    private String supplyCode;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "数量")
    private Integer amount;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "区域位置")
    private Integer regionId;

    @ApiModelProperty(value = "负责人")
    private String chargePerson;

    @ApiModelProperty(value = "负责人电话")
    private String chargePersonPhone;

    @ApiModelProperty(value = "消耗状态：1-未消耗 2-部分消耗 3-已消耗")
    private Integer consumeStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*-----------------------------非数据库属性------------------------------*/

}
