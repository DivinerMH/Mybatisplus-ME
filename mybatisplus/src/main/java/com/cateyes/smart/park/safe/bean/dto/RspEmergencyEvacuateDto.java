package com.cateyes.smart.park.safe.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 应急疏散表(SpSfEmergencyEvacuate)RspDto
 *
 * @author CatEyes
 * @since 2023-06-07 17:27:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspEmergencyEvacuateDto implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "路线名称")
    private String name;

    @ApiModelProperty(value = "路线数据")
    private String lineData;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "启用状态：1-启用；0-禁用；")
    private Boolean enable;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateBy;

    /*-----------------------------非数据库属性------------------------------*/

}
