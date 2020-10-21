package com.helper.common.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Classname BusinessEnum
 * @Description API枚举
 * @Date 2019/11/11 10:11
 * @Created by DZL
 */
@Getter
@AllArgsConstructor
public enum ApiEnum {

    ROLE_SELECT("role_select"),//角色查询唯一编码
    ROLE_DELET("role_delete"),//角色删除
    ROLE_UPDATE("role_update"),//角色修改

    /*租户编码*/
    Tenant_ADD("tenant_add"),//添加租户
    Tenant_DELETE("tenant_delete"),//删除租户
    Tenant_UPDATE("tenant_update"),//修改租户
    Tenant_SELECT("tenant_select"),//查询租户

    /*租户类型编码*/
    TenantType_ADD("tenantType_add"),//添加租户类型
    TenantType_DELETE("tenantType_delete"),//删除租户类型
    TenantType_UPDATE("tenantType_update"),//修改租户类型
    TenantType_SELECT("tenantType_select"),//查询租户类型

    /*project编码*/
    Project_ADD("project_add"),//添加project
    Project_DELETE("project_delete"),//删除project
    Project_UPDATE("project_update"),//修改project
    Project_SELECT("project_select"),//查询project

    SUPER_ADMIN("super_admin"),//超管
    TENANT_ADMIN("tenant_admin"),//租户管理员
    PROJECT_ADMIN("project_admin"),//project管理员
    ORDINARY_USER("ordinary_user"),//普通用户
    TENANT_QUOTA_ADMIN("tenant_quota_admin"),//租户配额管理员
    PROJECT_QUOTA_ADMIN("project_quota_admin"),//project配额管理员

    /**
     * 权限校验
     */
    AUTH_INSUFFICIENT("权限不足"),

    AUTH("auth");

    /**
     * 唯一编码
     */
    private String code;
}
