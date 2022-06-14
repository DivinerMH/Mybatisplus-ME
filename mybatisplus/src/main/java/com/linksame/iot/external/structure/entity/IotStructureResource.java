package com.linksame.iot.external.structure.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 资产结构与资源关系（深宝园-手动维护）(IotStructureResource)表实体类
 *
 * @author menghuan
 * @since 2022-03-11 16:14:06
 */
@Data
@ApiModel(value = "资产结构与资源关系（深宝园-手动维护）实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotStructureResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键 id", name = "id")
    private Integer id;
    /**
     * 资产结构 id
     */
    @ApiModelProperty(value = "资产结构 id", name = "structureId")
    private Integer structureId;
    /**
     * 资源类型：0-项目 1-项目模块（项目分期） 2-楼宇 3-楼层 4-房间（单元 / 房源）
     */
    @ApiModelProperty(value = "资源类型：0-项目 1-项目模块（项目分期） 2-楼宇 3-楼层 4-房间（单元 / 房源）", name = "type")
    private String type;
    /**
     * 资源 id
     */
    @ApiModelProperty(value = "资源 id", name = "resourceId")
    private String resourceId;

}
