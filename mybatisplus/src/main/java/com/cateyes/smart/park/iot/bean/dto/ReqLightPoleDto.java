package com.cateyes.smart.park.iot.bean.dto;

import com.cateyes.smart.park.base.bean.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 灯杆(SpIotLightPole)ReqDto
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqLightPoleDto extends BaseDto {

    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "园区ID")
    private Integer parkId;

    @ApiModelProperty(value = "设备类别")
    private Integer deviceTypeId;

    @ApiModelProperty(value = "设备细分类别")
    private Integer deviceTypeSubId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备属性：待定")
    private Integer deviceAttr;

    @ApiModelProperty(value = "设备编号（自动）")
    private String deviceNum;

    @ApiModelProperty(value = "区域ID")
    private Integer regionId;

    @ApiModelProperty(value = "位置ID")
    private Integer positionId;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "最新同步时间")
    private Date lastSyncTime;

    @ApiModelProperty(value = "是否启用：0-禁用 1-启用 ")
    private Boolean isDisabled;

    @ApiModelProperty(value = "设备状态：0-离线 1-在线")
    private Boolean status;

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
