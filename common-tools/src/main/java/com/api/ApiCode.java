package com.api;

/**
 * REST API 响应码
 */
public enum ApiCode {
    /** ---------------------------------------平台公共--start------------------------------------------- **/
    SUCCESS(200, "操作成功"), UNAUTHORIZED(401, "认证失败"), FORBIDDEN(403, "权限不足"), NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "方法不被允许"), TOO_MANY_REQUESTS(429, "服务忙，稍后再试"), FAIL(500, "操作失败"),
    RESOURCE_OVERFLOW_NOT_EXISTS(701, "今日编码已达最大值，请明日再试"),
    /** ---------------------------------------平台公共--end------------------------------------------- **/
    /** ---------------------------------------网关--start------------------------------------------- **/
    REQUEST_TIMEOUT(100001, "请求超时"), FEIGN_CALL_EXCEPTION(100002, "内部调用异常"), ARGUMENT_NOT_VALID(100003, "参数错误"),
    /** ---------------------------------------网关--end------------------------------------------- **/
    /** ---------------------------------------RBAC用户中心--start------------------------------------------- **/
    PARK_NOT_EXIST(110001, "园区不存在"), PARK_NAME_ALREADY_EXISTS(110002, "园区名称已存在"),
    APP_CONTAINS_MENU_AND_CANNOT_BE_DELETED(110003, "应用下含有菜单，无法删除"), ACCOUNT_NOT_EXISTS(110004, "账户不存在"),
    ACCOUNT_NOT_AVAILABLE(110005, "账户不可用"), PASSWORD_IS_INCORRECT(110006, "密码不正确"),
    ROLE_CODE_ALREADY_EXISTS(110007, "角色编码已存在"), USER_NAME_ALREADY_EXISTS(110008, "账户名称已存在"),
    USER_OLD_PASSWORD_ERROR(110009, "原密码错误"), USER_NOT_ASSIGNED_ROLE(1100010, "账户未分配角色"),
    ROLE_NOT_EXISTS(110007, "角色不存在"), ACCESS_TOKEN_INVALID(110110, "Access-Token 无效"),
    App_NAME_ALREADY_EXISTS(1100010, "应用名称已存在"), MENU_NOT_EXISTS(1100011, "菜单不存在"),
    MENU_NAME_ALREADY_EXISTS(1100010, "菜单名称已存在"), MENU_CODE_ALREADY_EXISTS(1100011, "菜单编码已存在"),
    MENU_CONTAINS_SUBMENUS(1100002, "菜单下含有子菜单,无法删除"), STRUCT_NAME_ALREADY_EXISTS(1100011, "组织名称已存在"),
    STRUCT_NOT_EXISTS(1100011, "组织不存在"), BUCKET_NOT_EXISTS(1200001, "bucket不存在"),
    SYSTEM_INNER_DATA_CAN_NOT_BE_OPERATED(1100012, "系统内置数据,禁止操作"),
    STRUCT_CONTAINS_MEMBER_AND_CANNOT_BE_DELETED(1100013, "组织下含有人员，无法删除"),
    BUILT_CONTAINS_FLOOR_AND_CANNOT_BE_DELETED(1100014, "楼栋下存在楼层，无法删除"),
    FLOOR_CONTAINS_ROOM_AND_CANNOT_BE_DELETED(1100015, "楼层下存在房间，无法删除"),
    ROOM_CONNECT_HOURSE_AND_CANNOT_BE_DELETED(1100016, "房间已关联房源，无法删除"),
    HOURSE_CONNECT_ENTERPRISE_AND_CANNOT_BE_DELETED(1100017, "房源已关联入驻企业，无法删除"),
    LAND_CONNECT_ENTERPRISE_AND_CANNOT_BE_DELETED(1100018, "土地已关联入驻企业，无法删除"),
    LAND_CONNECT_PROJECT_AND_CANNOT_BE_DELETED(1100019, "土地已关联工程项目，无法删除"), PARK_IS_DISABLED(1100020, "园区已被禁用"),
    BUILT_NAME_ALREADY_EXISTS(1100021, "楼栋名称已存在"), ROOM_NAME_ALREADY_EXISTS(1100022, "房间名称已存在"),
    LAND_NAME_ALREADY_EXISTS(1100023, "地块名称已存在"), LAND_NUM_ALREADY_EXISTS(1100024, "地块编号已存在"),
    ROLE_USED_BY_USER_AND_CANNOT_BE_DELETED(1100025, "角色已被用户使用，无法删除"),
    NOT_SUPER_ADMIN_OR_MACO_ADMIN_CANNOT_BE_DELETED(1100026, "非超管或管委会，无法删除"),
    PARK_DESC_EXCEED_MAX_LENGTH_LIMIT(1100028, "园区简介超过最大长度限制"),
    TEAM_DESC_EXCEED_MAX_LENGTH_LIMIT(1100029, "团队简介超过最大长度限制"),
    HOUSE_USE_TYPE_IS_APARTMENT_CANNOT_BE_SELECTED(1100030, "房源用途为公寓，无法选择"),
    HOUSE_IS_NOT_VACANCY_CANNOT_BE_SELECTED(1100031, "房源状态非空置，无法选择"),
    HOUSE_IS_USED_BY_CONTRACT_CANNOT_BE_SELECTED(1100032, "房源被合同占用，无法选择"),
    ENTERPRISE_AND_HOURSE_ARE_NOT_IN_THE_SAME_PARK(1100033, "企业和房源园区不一致"), PARENT_NOT_EXIST(1100034, "父节点不存在"),
    DEVICE_REGION_POSITION_CANNOT_HAVE_SUB(1100035, "位置不能存在下级"), RESOURCE_RESOURCE_NOT_EXISTS(1100036, "资源不存在"),
    RESOURCE_LAND_NEED(1100037, "根区域必须有地块"),
    /** ---------------------------------------RBAC用户中心--end------------------------------------------- **/
    /** ---------------------------------------文件--start------------------------------------------- **/
    // smart-park-file（12xxxx ~ 129999）
    FILE_ORIGINAL_NAME_TOO_LONG(120001, "文件名超长"),
    /** ---------------------------------------文件--end------------------------------------------- **/

    /** ---------------------------------------门户--start------------------------------------------- **/
    CATEGORY_NOT_EXISTS(150001, "栏目不存在"), CATEGORY_REPEAT(150002, "栏目重复"), ACTIVITY_NOT_EXISTS(150101, "活动不存在"),
    ACTIVITY_EXPIRE(150102, "活动已过期"), ACTIVITY_ENROLL_EXISTS(150103, "活动已报名"),
    ENTERPRISE_STAR_NOT_EXISTS(150201, "明星企业不存在"), GOV_LEADER_NOT_EXISTS(150301, "领导分工不存在"),
    ARTICLE_NOT_EXISTS(150401, "文章不存在"), ARTICLE_PUBLISH_STATUS_ERROR(150402, "文章发布状态异常"),
    GOV_PROFILE_NOT_EXISTS(150501, "机构简介不存在"), PORTAL_USER_NOT_EXISTS(150601, "用户不存在"),
    PORTAL_USER_PWD_ERROR(150602, "密码错误"), PORTAL_USER_ERROR(150603, "用户信息异常"),
    PORTAL_USERNAME_EXISTS(150604, "用户名已存在"), PORTAL_USER_LOGIN_ERROR(150605, "账号或密码错误"),
    PORTAL_USER_COMPANY_MATCH_ERROR(150606, "请正确填写企业信息"), PORTAL_USER_COMPANY_IN_PARK(150607, "请选择园区企业"),
    PORTAL_USER_PERSONAL_NOT_ALLOWED(150608, "此功能非个人服务"), PORTAL_USER_TYPE_IS_PERSONAL(150609, "请使用个人登录入口"),
    PORTAL_USER_TYPE_IS_ENT(150610, "请使用法人登录入口"), PORTAL_USER_PARK_COMPANY_MATCH_ERROR(150611, "请正确填写园区企业信息"),
    PORTAL_USER_COMPANY_DATA_ERROR(150612, "企业数据异常"), PORTAL_MOBILE_EXISTS(150613, "手机号已存在"),
    PORTAL_PWD_PATTERN_ERROR(150614, "密码格式不正确"), PORTAL_USER_COMPANY_REL_ERROR(150615, "园区企业关联失败"),
    PORTAL_COMPANY_NOT_EXISTS(150701, "企业信息不存在"), PORTAL_COMPANY_EXISTS(150702, "企业存在"),
    PORTAL_COMPANY_FIN_ALLOWED(150703, "仅金融企业允许操作"), PORTAL_COMPANY_FE_FIN_ALLOWED(150704, "仅非金融企业允许操作"),
    PORTAL_COMPANY_PAEK_ENT_ALLOWED(150705, "仅园区企业允许操作"), CAPTCHA_ERROR(150801, "验证码错误"),
    CAPTCHA_EXPIRE(150802, "验证码失效"), PARK_THROUGH_NOT_EXISTS(150901, "园企直通车事件不存在"),
    PARK_THROUGH_ITEM_STATUS_CHANGED(150902, "园企直通车事件状态已变更"), PARK_THROUGH_ITEM_FINISHED(150903, "园企直通车事件已处理"),
    PARK_THROUGH_ITEM_RECORD_UNCOMPLETE(150904, "园企直通车事件处理记录未填写"), PARK_THROUGH_ITEM_TYPE_ERROR(150905, "园企直通车事件类型异常"),
    PARK_THROUGH_ITEM_STATUS_NOT_ALLOWED(150906, "当前状态不支持此操作"), PROPERTY_SERVICE_NOT_EXISTS(151001, "物业服务事件不存在"),
    PROPERTY_SERVICE_ITEM_STATUS_CHANGED(151002, "物业服务事件状态已变更"), PROPERTY_SERVICE_ITEM_FINISHED(151003, "物业服务事件已处理"),
    PROPERTY_SERVICE_ITEM_RECORD_UNCOMPLETE(151004, "物业服务事件处理记录未填写"),
    PROPERTY_SERVICE_ITEM_TYPE_ERROR(151005, "物业服务事件类型异常"), PROPERTY_SERVICE_ONLY_DELETE_SELF(151006, "只能删除自己的物业服务事件"),
    PROPERTY_SERVICE_ITEM_STATUS_NOT_ALLOWED(151107, "当前状态不支持此操作"), APPLY_WORK_NOT_EXISTS(151101, "企业用工事件不存在"),
    APPLY_WORK_ITEM_STATUS_CHANGED(151102, "企业用工事件状态已变更"), APPLY_WORK_ITEM_FINISHED(151103, "企业用工事件已处理"),
    APPLY_WORK_ITEM_RECORD_UNCOMPLETE(151104, "企业用工事件处理记录未填写"), APPLY_WORK_ITEM_TYPE_ERROR(151105, "企业用工事件类型异常"),
    APPLY_WORK_ONLY_DELETE_SELF(151106, "只能删除自己的企业用工事件"), APPLY_WORK_ITEM_STATUS_NOT_ALLOWED(151107, "当前状态不支持此操作"),
    ADVICE_COLLECT_NOT_EXISTS(151201, "意见征集不存在"), ADVICE_COLLECT_DATE_IMPROPER(151202, "不在征集时效中"),
    ADVICE_COLLECT_ENROLL_EXISTS(151203, "意见征集已投递"), LOANS_APPLY_NOT_EXISTS(151301, "订单不存在"),
    LOANS_APPLY_FINISHED(151302, "订单已审批"), ENT_DATA_REPORT_TYPE_ERROR(151401, "企业数据类型异常"),
    ENT_DATA_REPORT_STATUS_ERROR(151402, "企业数据状态异常"), ENT_DATA_REPORT_AUDIT_FINISHED(151403, "企业数据审核已完成"),
    ENT_DATA_REPORT_NOT_EXISTS(151405, "企业数据不存"), ENT_DATA_REPORT_REPEAT(151406, "企业数据重复"),
    ENT_DATA_PRODUCT_DUPLICATE(151407, "产品重复"), ENT_DATA_PRODUCT_NOT_EXISTS(151408, "产品不存在"),
    ENT_DATA_REPORT_BEYOND_DATE_LIMIT_ERROR(151409, "已超过数据操作截止时间"),PORTAL_BUILD_ID_NOT_EXISTS(151410, "楼栋ID不存在"),
    /** ---------------------------------------门户--end------------------------------------------- **/
    /** ---------------------------------------招商--start------------------------------------------- **/
    INVEST_RESOURCE_NOT_EXISTS(160001, "资源不存在"), INVEST_RESOURCE_ID_NOT_EXISTS(160002, "资源ID不存在"),
    INVEST_REPEAT_UNIFIED_SOCIAL_CREDIT_CODE(160003, "重复统一社会信用代码"),
    INVEST_REPEAT_UNIFIED_LEAD_CODE(160004, "重复招商线索唯一编码"), INVEST_REPEAT_CONTRACT_TEMPLATE_NAME(160005, "重复合同模板名称"),
    INVEST_REPEAT_LEAD_NAME(160006, "重复招商线索名称"), INVEST_REPEAT_SOURCE_CHANNEL_NAME(160007, "重复招商线索名称"),
    INVEST_REPEAT_TRADE_NAME(160008, "重复行业名称"), INVEST_FORBID_CHANGE_OPERATION(160009, "非园外企业禁止当前操作"),
    INVEST_CONTRACT_INSERT_FALSE(160010, "合同信息新增失败"), INVEST_CONTRACT_INFO_INSERT_FALSE(160011, "合同基本信息新增失败"),
    INVEST_CONTRACT_BILL_DETAIL_INSERT_FALSE(160012, "合同账单详情新增失败"), INVEST_CONTRACT_REVIEW_FALSE(160013, "合同审批未通过"),
    INVEST_PLEASE_WAIT_REVIEW(160014, "请等待其他用户审核"), INVEST_INDUSTRY_DATA_ANOMALIES(160015, "普通产业数据存在重复记录，请联系管理员"),
    INVEST_COMMON_INDUSTRY_FORBID_CHILD_NODE(160016, "普通产业下禁止添加子节点产业"),
    INVEST_COMMON_INDUSTRY_FORBID_DELETE(160017, "普通产业禁止删除"), INVEST_SETTLE_REVIEW_FALSE(160018, "入驻审批未通过"),
    INVEST_COMPANY_NAME_REPEAT(160019, "重复企业名称"), INVEST_RESOURCE_OCCUPIED(160020, "资源被占用，禁止当前操作"),
    INVEST_NO_EXIST_FOLLOW(160021, "跟进人不能为空"), INVEST_INSERT_FALSE_BASE_INFO(160022, "企业基本信息新增失败"),
    INVEST_NO_EXIST_PARENT_NODE(160023, "父节点产业不存在"), INVEST_NO_EXIST_CURRENT_NODE(160024, "当前节点产业不存在"),
    INVEST_FORBID_UPDATE_PARENT_NODE(160025, "禁止修改父节点和路劲"), INVEST_INDUSTRY_NAME_REPEAT(160026, "重复企业名称"),
    INVEST_REPEAT_UNIFIED_PRODUCT_NAME(160027, "重复产品名称"), INVEST_REPEAT_UNIFIED_PLAN_TITLE(160028, "重复招商计划标题"),
    INVEST_NOT_EXISTS_PARK_ID(160029, "园区ID不存在"), INVEST_DATE_FORMAT_UNUSUAL(160030, "时间格式异常"),
    INVEST_NOT_INDUSTRY_CHAIN_RESOURCES(160031, "非主导产业链资源"),
    INVEST_NOT_INDUSTRY_CHAIN_RESOURCES_INDUSTRY(160032, "非主导产业链产业资源"),
    INVEST_INDUSTRIAL_CHAIN_LINK_OUT(160033, "超出产业链环节节点允许个数"), INVEST_COMMITTED_SETTLE_APPLY(160034, "当前企业已提交入驻申请"),
    INVEST_NOT_NULL_SETTLE(160035, "入驻信息不能为空"), INVEST_APPROVAL_PROCESS_HAS_CONCLUDED(160036, "审批流程已结束"),
    INVEST_FORBIDDEN_TO_ENTER(160037, "当前企业已入驻，禁止操作"), INVEST_ABNORMAL_PARAMETERS(160038, "参数异常:为非产业节点资源"),
    INVEST_ABNORMAL_PARAMETERS_CONTACT_STATE(160039, "合同状态参数异常:"), INVEST_TIME_INTERVAL_NOT_EMPTY(160040, "账单时间区间不能为空"),
    INVEST_EXIST_INDUSTRY_LINK(160041, "已存在以\"上游\",\"中游\",\"下游\"开头的产业环节"),
    INVEST_INDUSTRY_LINK_PREFIX_ERROR(160042, "产业环节只能以\"上游\",\"中游\",\"下游\"开头"),
    INVEST_INDUSTRY_DATA_LEAD(160043, "当前主导产业已存在"), INVEST_NO_EXIST_CONTRACT_ID(160044, "合同ID不能为空"),
    INVEST_NO_EXIST_INDUSTRY_ID(160045, "主导产业ID不能为空"), INVEST_NO_EXIST_TIME(160046, "时间不能为空"),
    INVEST_FOLLOW_NOT_EXISTS(160047, "跟进人不存在"), INVEST_RESOURCE_IS_OCCUPIED(160048, "资源已被占用，禁止当前操作"),
    INVEST_RESOURCE_ALREADY_EXISTS(160049, "当前房源/土地资源已被占用，请核实后操作"), INVEST_ABNORMAL_JWT(160050, "获取当前登录者信息异常"),
    INVEST_ABNORMAL_OPERATION_MATCH_OF_PERSONNEL(160051, "操作权限异常：非实际跟进人禁止当前操作"),
    INVEST_ABNORMAL_OPERATION_FORBIDDEN(160052, "当前企业已进入合同及入驻申请状态禁止分配/认领/转派/退回操作"),
    INVEST_FORBID_DELETE_NOT_INTENTIONAL(160053, "非意向企业/园外企业禁止删除"), INVEST_FORBID_DELETE_SETTLE(160054, "园区内/入驻企业禁止删除"),
    INVEST_FORBID_ROLLBACK_SETTLE(160055, "园区内/入驻企业禁止退回"),
    INVEST_RESOURCE_OCCUPIED_CHAIN_LINK(160056, "产业链资源被占用，禁止当前操作，请从底层操作"), INVEST_DUPLICATE_NAME(160057, "名称重复"),
    INVEST_FLOW_DELETE_ERROR(160058, "该流程存在审批未完成的数据，不能删除"), INVEST_SETTLE_NOT_SUBMIT(160059, "未提交入驻信息"),
    INVEST_NOT_EXIST_SOCIAL_CREDIT_CODE(160060, "唯一社会信用代码不能为空"),
    INVEST_HAS_SETTLE_PARK_OPERATION(160061, "当前企业在园区运营已入驻"),

    /** ---------------------------------------招商--end------------------------------------------- **/
    /** ---------------------------------------报表--start------------------------------------------- **/
    REPORT_RESOURCE_NOT_EXISTS(170001, "资源不存在"), REPORT_DUPLICATE_NAME(170002, "名称重复"),
    REPORT_DUPLICATE_EVENT_ID(170003, "事件Id重复"), REPORT_DUPLICATE_CAR_NO(170004, "车牌号重复"),
    REPORT_DUPLICATE_ITEM_NO(170005, "编号重复"), REPORT_UPDATE_MORE_ERROR(170006, "不允许的信息被修改"),
    REPORT_DUPLICATE_RECORD(170007, "记录重复"), REPORT_STRATEGY_NOT_EXIST(170008, "策略不存在"),
    REPORT_PARAM_ERROR(170008, "参数错误"), REPORT_INDUSTRY_LINK_ERROR(170009, "产业环节只能以\"上游\",\"中游\",\"下游\"开头"),
    REPORT_INDUSTRY_LINK_EXIST(170010, "已经存在该产业环节"), REPORT_DUPLICATE_DATE(170011, "重复日期统计"),
    REPORT_CURRENT_RECORD_HAS_EXISTS(170012, "当前园区本月已存在上报记录，请核实后操作"),
    REPORT_ABNORMAL_PARAMETERS_YEAR_NOT_EXISTS(160038, "参数异常:年度不能为空"),

    /** ---------------------------------------报表--end------------------------------------------- **/

    /** ---------------------------------------IOT--start------------------------------------------- **/
    IOT_RESOURCE_NOT_EXISTS(180001, "资源不存在"), IOT_ABNORMAL_PARAMETERS_OVERVIEW(180002, "统计概览参数异常：园区、当前时间不能为空"),
    IOT_ABNORMAL_INSERT_CAMERA_ALARM(180003, "摄像头告警事件新增异常"), IOT_ABNORMAL_POSITION_ID(180004, "位置ID入参异常"),
    IOT_RESOURCE_POSITION_ID_NOT_EXISTS(180005, "位置ID对应资源不存在"), IOT_PARAM_ERROR(180006, "参数错误"),
    IOT_DUPLICATE_ITEM_NO(180007, "编号重复"), IOT_ABNORMAL_INSERT_SMOKE(180009, "烟感新增异常"),
    IOT_ABNORMAL_INSERT_SMOKE_ALARM(180009, "烟感告警事件新增异常"), IOT_NOT_EXISTS_PARK_ID(180010, "园区ID不存在"),
    IOT_LAND_ALEADY_USED_BY_PLACE(180011, "地块已被停车场关联"), IOT_CAR_NUM_ALREADY_EXISTS(180012, "车牌号已存在"),
    IOT_CAR_DEVICE_NUM_ALREADY_EXISTS(180013, "设备编号已存在"), IOT_CHARGE_PILE_DEVICE_NUM_ALREADY_EXISTS(180014, "设备编号已存在"),

    /** ---------------------------------------IOT--end------------------------------------------- **/

    /** ---------------------------------------SAFE--start------------------------------------------- **/
    SAFE_RESOURCE_NOT_EXISTS(190001, "资源不存在"), SAFE_DUPLICATE_NAME(190002, "名称重复"), SAFE_PARAM_ERROR(190003, "参数错误"),
    SAFE_REPEAT_UNIFIED_CODE(190004, "编码重复"), SAFE_NO_EXIST_REMARK(190005, "请输入巡检记录信息"),
    SAFE_RESOURCE_BE_OCCUPIED(190006, "资源已被占用，禁止当前操作"), SAFE_STAFF_FIELD_OUT_OF_RANGE(190101, "领域节点超出限制个数"),
    /** ---------------------------------------SAFE--end------------------------------------------- **/

    // smart-park-job（13xxxx ~ 139999）
    // smart-park-resource（14xxxx ~ 149999）
    ENTERPRISE_NAME_EXISTS(140001, "企业名称已经存在"), ENTERPRISE_CREDIT_CODE_EXISTS(140002, "企业信用代码已经存在"),;

    private final int code;
    private final String msg;

    ApiCode(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiCode getApiCode(int code) {
        ApiCode[] ecs = ApiCode.values();
        for (ApiCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
