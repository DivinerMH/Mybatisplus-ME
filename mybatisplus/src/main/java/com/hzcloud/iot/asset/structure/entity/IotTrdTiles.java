package com.hzcloud.iot.asset.structure.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 3d-tiles 文件数据表
 * </p>
 *
 * @author menghuan
 * @since 2020-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotTrdTiles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 3d-tiles 文件名称
     */
    private String name;

    /**
     * 3d-tiles 数据格式：0-3dTiles 1-其他
     */
    private String abbrDataFormat;

    /**
     * 3d-tiles 入口路劲
     */
    private String abbrUrl;

    /**
     * 3d-tiles 位置坐标（对象）
     */
    private String abbrCoordinates;

    /**
     * 状态：0-启用 1-禁用
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删：0-正常 1-删除
     */
    private String delFlag;


}
