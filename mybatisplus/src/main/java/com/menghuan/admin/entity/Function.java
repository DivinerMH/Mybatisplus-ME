package com.menghuan.admin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 功能表
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Function implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 菜单id
     */
    private Integer menuId;

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 接口唯一编码
     */
    private String functionCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删：0-正常，1-删除
     */
    private String delFlag;


}
