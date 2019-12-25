package com.menghuan.common.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Classname BusinessEnum
 * @Description 业务枚举
 * @Date 2019/11/11 10:11
 * @Created by DZL
 */
@Getter
@AllArgsConstructor
public enum BusinessEnum {

    /**
     * 参数校验 101-199
     */
    PARAMETER_NULL(101, "参数不能为空"),

    ADD_FAIL(102, "新增失败"),

    UPDATE_FAIL(103, "修改失败"),

    DELETE_FAIL(104, "删除失败"),

    PARAMETER_FAULT(105, "参数异常"),

    /**
     * 登录校验 201-299
     */
    NOT_LOGIN(201, "用户未登录"),


    /*菜单枚举  1001-1099*/
    MENU_SAVE(1001, "非系统菜单不可新增"),

    MENU_DELET(1002, "非系统菜单不可删除"),

    MENU_UPDATE(1001, "非系统菜单不可修改"),
    SERVICE_MENU_ERROR(1002, "服务菜单获取异常"),

    /*功能枚举 1101-1199*/
    FUNCTION_DELET(1101, "该功能占用，无法删除！！！"),

    /*角色枚举 1201-1299*/
    ROLE_DELET(1201, "该角色占用，无法删除！！！"),
    /*权限枚举 1301-1399*/
    AUTH_NOT(1301, "权限不足"),

    /*租户类型枚举 1301-1399*/
    TENANT_TYPE_GET(1301, "获取租户类型为空"),

    /*服务模板 2001-2099*/
    MODEL_SAVE(2001, "服务模板新增失败"),

    MODEL_UPDATE(2002, "服务模板修改失败"),

    MODEL_DELETE(2003, "服务模板删除失败"),

    MODEL_STATUS_UP(2004, "服务模板上架失败"),

    MODEL_STATUS_DOWN(2005, "服务模板下架失败"),


    MODEL_ROLE_SAVE(2010, "服务模板-角色关联新增失败"),

    MODEL_ROLE_DELETE(2011, "服务模板-角色关联删除失败"),

    MODEL_ROLE_NULL(2012, "服务模板-角色关联集合为空"),

    MODEL_COMPONENT_NULL(2013, "服务模板-组件关联集合为空"),


    MODEL_TENANT_TYPE_SAVE(2020, "服务模板-租户类型关联新增失败"),

    MODEL_TENANT_TYPE_DELETE(2021, "服务模板-租户类型关联删除失败"),

    MODEL_TENANT_TYPE_NULL(2022, "服务模板-租户类型关联集合为空"),

    MODEL_IMAGE_SAVE(2030, "服务模板-镜像新增失败"),

    MODEL_IMAGE_DELETE(2031, "服务模板-镜像关联删除失败"),

    MODEL_IMAGE_NULL(2032, "服务模板-镜像关联集合为空"),

    MODEL_FLAVOR_SAVE(2040, "服务模板-规格新增失败"),

    MODEL_FLAVOR_DELETE(2041, "服务模板-规格关联删除失败"),

    MODEL_FLAVOR_NULL(2042, "服务模板-规格关联集合为空"),


    DEFINITION_STYLE_LIST_NULL(2060, "UI定义数据集合为空"),

    DEFINITION_STYLE_ID_NULL(2061, "UI定义ID集合为空"),

    DEFINITION_STYLE_BATCH_SAVE(2062, "UI定义批量插入失败"),

    DEFINITION_STYLE_BATCH_DELETE(2063, "UI定义批量删除失败"),

    DEFINITION_COMPONENT_LIST_NULL(2064, "UI定义-组件集合为空"),

    DEFINITION_COMPONENT_BATCH_SAVE(2065, "UI定义-组件批量插入失败"),

    DEFINITION_COMPONENT_BATCH_DELETE(2066, "UI定义-组件批量删除失败"),

    COMPONENT_CODE_EXIT(2067, "该组件已存在,请勿重复添加"),

    COMPONENT_DELETE(2068, "组件-组件属性删除失败"),

    COMPONENT_SAVE(2069, "组件添加失败"),

    COMPONENT_UPDATE(2070, "组件修改失败"),

    COMPONENT_NULL(2070, "未查询到该组件"),

    OPERAT_NULL(2080, "组件操作不能为空"),

    OPERAT_SAVE(2081, "组件操作新增失败"),

    OPERAT_UPDATE(2082, "组件操作修改失败"),

    OPERAT_DELETE(2083, "组件操作删除失败"),

    LIBRARY_NULL(2084, "组件库没有数据"),

    COMPONENT_BINDER_DELETE(2090, "组件绑定关系删除失败"),

    COMPONENT_DEPEND_RELATIONSHIP_DELETE(2100, "组件依赖关系删除失败"),

    COMPONENT_DEFINITION_DELETE(2110, "组件UI关系删除失败"),

    /**
     * 资源管理枚举  3001-3012
     */
    PRIMARY_KEY_NULL(3000, "主键为空"),

    RESOURCETYPE_ADD_FAIL(3001, "资源类型增加失败"),

    RESOURCETYPE_UPDATE_FAIL(3002, "资源类型修改失败"),

    RESOURCETYPE_DELETE_FAIL(3003, "资源类型删除失败"),

    RESOURCETYPE_RESOURCETYPECODE_EXIT(3004, "资源类型已存在，请勿重复添加"),

    RESOURCEPROVIDER_ADD_FAIL(3005, "provider增加失败"),

    RESOURCEPROVIDER_UPDATE_FAIL(3006, "provider修改失败"),

    RESOURCEPROVIDER_DELETE_FAIL(3007, "provider删除失败"),

    RESOURCEPROVIDER_EXIT(3008, "provider已存在，请勿重复添加"),

    RESOURCEPROVIDERATTRIBUTE_ADD_FAIL(3009, "provider属性增加失败"),

    RESOURCEPROVIDERATTRIBUTE_UPDATE_FAIL(3010, "provider属性修改失败"),

    RESOURCEPROVIDERATTRIBUTE_DELETE_FAIL(3011, "provider属性删除失败"),

    RESOURCEPROVIDERATTRIBUTE_EXIT(3012, "provider属性已存在，请勿重复添加"),

    RESOURCETYPE_NULL(3013, "资源类型查询为空"),
    /**
     * 对象转换Map ---- 远程接口获取key列表
     */
    REQUEST_PARSE_KEYS(9000, "获取远端数据api解析key失败"),

    /**
     * JSON解析 9100~9500
     */
    JSON_PARSE_EMPTY(9100, "解析出的数据为空"),

    /**
     * JSON合并 9501~9999
     **/
    JSON_PARSE_BY_KEY(9996, "解析出的key数量大于1"),

    JSON_EMPTY(9997, "json数据为空"),

    JSON_WRONG_FORMAT(9998, "json格式有误"),

    JSON_MERGE(9999, "(TF文件)JSON数据合并失败");

    /**
     * 错误编码
     */
    private int code;
    /**
     * 描述
     */
    private String description;

}
