package com.helper.constant.enums;

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
    REVIEW_FAIL(105, "审核失败"),
    DATA_NULL(106, "获取数据为空"),
    PARAMETER_ID_NULL(107, "参数ID不能为空"),
    ILLEGAL_PARAMETER(108, "参数非法"),
    SUBMIT_REPEAT(109, "点击太快了,请勿重复提交"),
    QRCODE_NULL(110, "二维码生成为空"),

    /*国际化语言*/
    LANGUAGE_NULL(999, "获取目标语言为空"),


    /*菜单枚举  1001-1099*/
    MENU_SAVE(1001, "非系统菜单不可新增"),
    MENU_DELET(1002, "非系统菜单不可删除"),
    MENU_UPDATE(1001, "非系统菜单不可修改"),
    MENU(1099, "系统菜单"),

    /*功能枚举 1101-1199*/
    FUNCTION_DELET(1101, "该功能占用，无法删除！！！"),

    /*角色枚举 1201-1299*/
    ROLE_DELET(1201, "该角色占用，无法删除！！！"),
    ROLE_CODE_IS_NOT_NULL(1202, "角色code不允许为空"),

    CLIENT_ID_EXIST(1351, "终端编号已存在,请重新填写"),
    SOCIAL_TYPE_EXIST(1361, "社交类型已存在,请选择其他类型"),

    /* 账号/用户 2000-2099*/
    USER_IS_LOCK(2000, "该账号已被禁用"),
    USER_IS_EXIST(2001, "该账号已被注册，请重新输入"),
    ADMIN_USER_NULL(2002, "未查询到匹配的账号信息"),
    OLD_PASSWORD_IS_FAIL(2003, "原密码错误，修改失败"),
    ADMIN_USERINFO_NULL(2004, "未查询到匹配的用户信息"),
    ADMIN_TENANT_NULL(2005, "未查询到匹配的租户信息"),
    TENANT_NOT_IS_NULL(2007, "租户ID不允许为空"),
    USER_IDCODE_IS_EXIST(2008, "系统中已存在该身份证号, 请核对后再提交"),
    USER_IDCODE_IS_ILLEGAL(2009, "身份证号不允许包含中文字符, 请确认后再提交"),
    USER_ADD_MUST_ENTERED(2010, "新增正式用户必须录入账号信息"),
    USER_PHONE_IS_ILLEGAL(2011, "手机号格式不规范，请重新输入"),
    USER_PHONE_IS_EXIST(2012, "该手机号已被注册，请重新输入"),
    USER_EMAIL_IS_ILLEGAL(2013, "邮箱格式不规范，请重新输入"),
    USER_EMAIL_IS_EXIST(2014, "该邮箱已被注册，请重新输入"),
    USER_RELATED_IS_EXIST(2015, "该用户信息存在关联数据, 不允许删除"),
    USER_BINDING_IS_EXIST(2016, "该用户已有绑定账号, 绑定失败!"),

    /* 租户 2100-2199*/
    TENANT_IS_LOCK(2100, "该租户已被禁用"),
    TENANT_RELATED_USER_IS_EXIST(2101, "该租户存在已关联的账号信息, 不允许删除"),
    TENANT_SYSTEM_ERROR(2102, "不允许添加系统租户"),

    /* 人脸 2200-2299*/
    FACE_ERROR(2200, "调用人脸接口错误"),
    FACE_PATH_NULL(2201, "未查询到匹配的人脸信息"),
    FACE_RELATED_IS_EXIST(2202, "人脸信息已存在关联关系, 请确认后再提交"),
    FACE_RELATED_NOT_USERINFO(2203, "该人脸图片未关联用户信息"),
    FACE_RELATED_NOT_BE_DELETE(2204, "该人脸存在关联数据, 不允许删除"),

    /* 卡号 2300-2399*/
    CARD_FIND_FAIL(2300, "查询卡号错误"),
    CARD_FIND_NULL(2301, "未查询到匹配的卡号信息"),
    CARD_BIND_REPEAT_NULL(2302, "卡号绑定重复或未绑定访客"),
    CARD_BIND_EXIST(2303, "卡号已被绑定"),
    CARD_BIND_FAIL(2304, "卡号绑定失败"),
    CARD_RELATED_IS_EXIST(2305, "卡号信息已存在关联关系, 请确认后再提交"),
    CARD_IS_ILLEGAL(2306, "卡号不允许包含中文字符, 请确认后再提交"),
    CARD_RELATED_USERINFO_NULL(2307, "未查询到卡号关联的用户信息"),
    CARD_IS_EXIST(2308, "卡号已存在, 请勿重复添加"),
    CARD_RELATED_NOT_DELETE(2309, "卡号存在关联业务, 不允许删除"),

    /* 车牌号 2400-2499*/
    CAR_ADD_FAIL(2400, "存储车牌错误"),
    CAR_PARAMETER_IS_NULL(2401, "车牌号参数为空,请输入车牌号"),
    CAR_FIND_FAIL(2402, "查询车牌错误"),
    CAR_FIND_NULL(2403, "未查询到匹配的车牌号信息"),
    RELATED_IS_EXIST(2404, "存在关联业务, 不允许删除"),
    CAR_RELATED_IS_EXIST(2405, "车牌号信息已存在关联关系, 请确认后再提交"),
    CAR_USER_RELATED_NOT_EXIST(2406, "用户-车牌关联信息不存在"),
    CAR_IS_EXIST(2407, "车牌号已存在, 请勿重复添加"),

    /* 微信 2500-2599 */
    WECHAT_FIND_NULL(2500, "未查询到匹配的微信数据"),
    WECHAT_CODE_NULL(2501, "参数code不允许为空"),
    WECHAT_SYSTEM_CONFIG_NULL(2502, "系统缺少微信app_id和app_secret配置"),
    WECHAT_CALLBACK_NULL(2503, "获取微信响应报文为空"),

    /* 其他异常 2500-2599*/
    USERID_NOT_IS_NULL(2500, "userInfoId参数不允许为空"),
    ISBINDING_NOT_IS_NULL(2501, "isBinding参数不允许为空"),
    MGS_CONFIG_FAIL(2599, "消息服务配置失败"),

    VISITORS_OUTBOUND_NULL(5210, "当前外访申请未找到"),
    VISITORS_OUTBOUND_REVIEW(5211, "当前外访申请暂停审核"),
    VISITORS_OUTBOUND_DEP(5212, "外部预约需要选择外访部门"),
    VISITORS_OUTBOUND_NUMS_EXCEED(5213, "预约人数已满"),
    VISITORS_OUTBOUND_USER_FAIL(5214, "外访人员添加失败"),
    VISITORS_OUTBOUND_CARNO_FAIL(5215, "车牌操作失败"),
    VISITORS_OUTBOUND_FACE_FAIL(5216, "人脸操作失败"),
    VISITORS_OUTBOUND_ENTRANCE_FAIL(5217, "调用设备人脸错误"),
    VISITORS_INVITE_DETAIL_ADD(5230, "外部邀请详情新增失败"),
    VISITORS_INVITE_COUNT(5231, "您已提交过外访申请,请勿重复提交"),
    VISITORS_INVITE_NULL(5232, "未查询到内部邀请信息"),
    VISITORS_INVITE_USER_NULL(5233, "邀请人信息不可用"),
    VISITORS_INVITE_TIME_EXPIRED(5234, "邀请时间已到期，该邀请已失效"),
    VISITORS_INVITE_DETAIL_ZERO(5235, "邀请人员暂时为空"),
    VISITORS_INVITE_STATUS_EXIST(5236, "该邀请已提交"),
    VISITORS_RECORDING_NOT_FOUND(5240, "外访记录不存在"),
    VISITORS_RECORDING_NULL(5241, "外访记录获取为空"),
    VISITORS_RECORDING_DETAIL_ADD(5242, "外访记录详情新增失败"),

    PARKING_AREA_NO_EXIST(5300, "停车场编号已存在,请重新输入"),
    PARKING_REGION_ADD_FAIL(5310, "停车场区域新增失败"),
    PARKING_REGION_UPDATE_FAIL(5311, "停车场区域修改失败"),
    PARKING_REGION_DELETE_FAIL(5312, "停车场区域删除失败"),
    PARKING_REGION_SPACE_EXIST(5313, "该停车场区域下存在停车位,请先删除区域下的停车位"),

    PARKING_CAR_INOUT_ADD_FAIL(5331, "车辆进出新增失败"),
    PARKING_CAR_INOUT_UPDATE_FAIL(5332, "车辆进出修改失败"),
    PARKING_CAR_INOUT_NOT_FOUND(5333, "车辆进出信息未找到"),
    PARKING_CAR_INOUT_ADD_DETAIL(5341, "车辆进出新增详情失败"),
    PARKING_CAR_INOUT_UPDATE_DETAIL(5342, "车辆进出修改详情失败"),
    PARKING_CAR_INOUT_DELETE_DETAIL(5343, "车辆进出删除详情失败"),

    PARKING_ACCOUNT_ADD_FAIL(5350, "停车场关联计费失败"),
    PARKING_ACCOUNT_EMPTY(5351, "计量项为空, 至少选择一项计量项"),
    PARKING_ACCOUNT_FAIL(5352, "获取卡计费套餐失败"),
    PARKING_ACCOUNT_FEIGN_FAIL(5354, "计算价格出错,请重试"),

    PARKING_BILLING_EMPTY(5360, "缴费项为空"),
    PARKING_BILLING_DATE_ILLEGAL(5361, "续费日期不应小于到期时间"),
    PARKING_BILLING_UPDATE_FAIL(5362, "缴费失败"),
    PARKING_BILLING_DETAIL_FAIL(5363, "新增计费详情记录失败"),
    PARKING_BILLING_MONTH_NULL(5364, "缴费月份不能为空"),
    PARKING_BILLING_MONTH_LEAST_MON(5365, "缴费月份至少为1个月"),

    PARKING_PAY_LOG_ADD_FAIL(5370, "支付记录添加失败"),

    PARKING_CARD_EMPTY(5350, "卡为空"),

    PARKING_CARD_PRODUCT_EMPTY(5360, "卡套餐为空"),

    /**
     * Structure资产结构业务枚举 6000-6100
     */
    TENANT_ID_NULL(6000, "租户id不能为空"),
    PROVINCE_ID_NULL(6001, "省市区id不能为空"),
    TENANT_TYPE_EXCEPTION(6002, "租户类型应为平台租户，请核实后操作"),

    STRUCTURE_EXIST(6010, "该资产结构已存在，请核实后操作"),
    STRUCTURE_NO_EXIST(6011, "资产结构节点不存在，请核实后操作"),
    STRUCTURE_NAME_EXIST(6012, "该名称已存在，请核实后操作"),
    STRUCTURE_NAME_NO_EXIST(6013, "该名称不存在，请核实后操作"),
    STRUCTURE_ANCHORS_INFO_EXIST(6014, "当前资产结构节点存在锚点信息，请核实后操作"),
    STRUCTURE_LIST_EXCEPTION(6015, "资产结构List列表数据异常：当前无数据"),
    STRUCTURE_PATH_EXCEPTION(6016, "该资产结构路劲异常,请核实后操作"),

    PARENT_NODE_EXCEPTION(6030, "父级节点数据异常"),
    CHILDREN_NODE_EXCEPTION(6031, "子级节点数据异常"),
    CHILDREN_NODE_EXIST(6032, "当前节点存在子节点，请核实后操作"),

    ANCHORS_EXIST(6040, "存在锚点信息，请核实后操作"),
    ANCHORS_NO_EXIST(6041, "存在锚点信息，请核实后操作"),

    ANCHORS_TYPE_LIMIT(6042, "锚点Type参数为0或1，请核实后操作"),
    ANCHORS_TYPE_OR_MACHINE_NULL(6043, "锚点Type或machineId为空，请核实后操作"),


    /**
     * Meeting智慧会议业务枚举 6100-6200
     */
    MEETING_ACTIVITY_NULL(6120, "会议室审批资源不存在，请核实后操作"),
    MEETING_ACTIVITY_REVIEW(6121, "会议室资源未审核，请核实后操作"),

    /**
     * 7000-7099 支付业务枚举
     */
    PAY_FAIL(7000, "支付失败"),

    /**
     * 7100 - 7199 消息枚举
     */
    WEBPUSH_PRODUCT_LIST_NULL(7100, "产品套餐为空"),
    WEBPUSH_ORDER_NULL(7101, "订单为空"),
    WEBPUSH_ORDER_ADD_FAIL(7102, "订单创建失败"),
    WEBPUSH_ORDER_DETAIL_NULL(7110, "订单详情为空"),
    WEBPUSH_ORDER_DETAIL_ADD_FAIL(7111, "订单详情创建失败"),
    WEBPUSH_RECHARGE_TOP_FAIL(7120, "充值失败"),


    /**
     * JSON合并 9999
     **/
    JSON_Empty(9900, "json数据为空"),
    JSON_WRONG_FORMAT(9901, "json格式有误"),
    JSON_MERGE(9902, "(TF文件)JSON数据合并失败"),
    JSON_CONVERT_FAIL(9903, "JSON转换失败"),

    /* BIM */
    BIM_SERVER_ERROR(11180, "BimServer服务器未知错误"),
    BIM_IO_FAIL(11181, "BIM IO流错误"),
    BIM_CHECK_FAIL(11182, "ifc 上传文件失败"),
    BIM_DESERIALIZER_FAIL(11183, "反序列化器失败"),


    ACTIVITI_MODEL_NULL(13100, "模型图未找到，请添加并保存模型图"),
    ACTIVITI_MODEL_NAME_EXIST(13101, "模型名称已存在、请重新输入"),
    ACTIVITI_MODEL_KEY_EXIST(13102, "模型KEY已存在、请重新输入"),
    ACTIVITI_MODEL_MGS_ADD_FAIL(13103, "消息服务关联模型失败"),
    ACTIVITI_MODEL_MGS_DELETE_FAIL(13103, "删除消息服务关联模型失败"),
    ACTIVITI_PROCESS_START(13200, "流程实例挂起失败"),
    ACTIVITI_PROCESS_TASK_ALERADY(13201, "该流程实例下存在待办任务"),

    /* 应用设置 15000-15200 */
    APP_CLASSIFY_NAME_REPEAT(15000, "应用分类名称已存在"),
    APP_CLASSIFY_BINDING_ERROR(15001, "该分类已关联应用,请先解除应用关联"),
    APP_ACTIVERULE_REPEAT(15002, "应用路由已存在"),
    pass_platform_REPEAT(15003, "已配置用户信息,不可重复提交");


    /**
     * 错误编码
     */
    private int code;
    /**
     * 描述
     */
    private String description;


}
