package com.menghuan.admin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色类型 0-超管 1-租户管理员 2-项目管理员 3-普通用户
     */
    private String roleType;

    /**
     * 上级id 默认有四个一级角色，id为0
     */
    private Integer parentId;

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
