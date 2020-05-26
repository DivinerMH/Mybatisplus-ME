package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 归属类型：0-租户，1-project
     */
    private String affiliationType;

    /**
     * 租户id（为用户所属租户）（有对应租户表，id ！=0）
     */
    private Integer tenantId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 0-启用 1-禁用 2-初次登陆
     */
    private String status;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像(提供默认头像)
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信 openid
     */
    private String wxOpenid;

    /**
     * QQ openid
     */
    private String qqOpenid;

    /**
     * 默认角色
     */
    private Integer defaultRole;

    /**
     * 默认project
     */
    private Integer defaultProject;

    /**
     * 上一次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 0-正常，1-删除
     */
    private String delFlag;


}
