package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单UUID
     */
    private String menuId;

    /**
     * 菜单英文名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 前端URL
     */
    private String path;

    /**
     * 展示或隐藏（true-展示 false-不展示）默认展示
     */
    private Boolean hidden;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 菜单类型 0-系统菜单  1-服务菜单
     */
    private String type;

    /**
     * VUE页面
     */
    private String component;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 路由缓冲 0-开启 1-关闭
     */
    private String keepAlive;

    /**
     * 0-开启，1- 关闭
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

    /**
     * 标题
     */
    private String title;


}
