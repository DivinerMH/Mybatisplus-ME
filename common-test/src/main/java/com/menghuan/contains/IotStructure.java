package com.menghuan.contains;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资产结构表
 * </p>
 *
 * @author menghuan
 * @since 2020-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IotStructure implements Serializable {

    private static final long serialVersionUID = 1L;

    /* 主键id */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /* 资产结构名称 */
    // private String name;

    /* 层级 */
    private Integer level;

}
