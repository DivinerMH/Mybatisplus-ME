package com.menghuan.HuanTools.enums;

/**
 * REST API 响应码
 */
public enum ApiCode {
    /** ---------------------------------------平台公共--start------------------------------------------- **/
    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "认证失败"),
    FORBIDDEN(403, "权限不足"),
    NOT_FOUND(404, "资源不存在"),
    NOT_FOUND_FORM(404, "表单资源不存在"),
    NOT_FOUND_PARENT(405, "父级资源不存在"),
    NOT_FOUND_PARAM(406, "参数不存在"),
    METHOD_NOT_ALLOWED(407, "方法不被允许"),
    TOO_MANY_REQUESTS(429, "服务忙，稍后再试"),
    FAIL(500, "操作失败"),
    RESOURCE_OVERFLOW_NOT_EXISTS(701, "今日编码已达最大值，请明日再试"),
    RESOURCE_OVERFLOW_LIMIT_APPLY_DATA(702,"提交数据申请超过限定最大值，请拆分后操作"),
    RESOURCE_OVERFLOW_LIMIT_NUM_APPLY_DATA(703,"提交数据申请超过限定最大值[1000]，请拆分后操作"),

    REPEAT_NAME(10001, "名称重复"),
    REPEAT_CODE(10002, "编码重复"),
    REPEAT_PHONE(10003, "手机号码重复"),
    RESOURCES_OCCUPANCY_FORBIDDEN_OPERATION(10003, "资源已被占用，禁止当前操作"),

    DISABLES_HAVING_ITSELF_PARENT(10004, "禁止以自己作为父节点"),
    /** ---------------------------------------平台公共--end------------------------------------------- **/

    RESOURCES_OCCUPANCY_MATERIAL(210001, "资源已被物料占用，禁止当前操作"),
    RESOURCES_CLEAN_IS_EMPTY(210002, "物料信息清洗后为空，请核实后操作"),
    RESOURCES_ALREADY_EXISTS(210003, "物料信息提交数据已存在，请核实后操作"),
    RESOURCES_RELATION_ERROR_NOT_FINAL(210004, "关联物料分类为非末级分类，请核实后操作"),
    RESOURCES_RELATION_PARENT_ERROR_NOT_FINAL(210004, "关联的父级物料分类为末级分类，请核实后操作"),
    RESOURCES_RELATION_ERROR_IS_FINAL(210005, "关联物料分类为末级分类，请核实后操作"),
    PARAM_IS_BLACK_CATEGORY_CODE_RULE(210006, "物料编码构建规则为空"),
    RESOURCES_FORBID_OPERATE_REMOVE_HAS_CHILD(210007, "当前资源存在子集数据，禁止当前操作"),
    NOT_FOUND_MATERIAL_CATEGORY(210008, "物料分类资源不存在，请核实后操作"),
    NOT_FOUND_MATERIAL_CATEGORY_PURCHASE(210008, "物料分类集采资源不存在，请核实后操作"),
    REPEAT_MATERIAL_CODE(210009, "物料编码重复，请联系管理员"),
    REPEAT_MATERIAL_FOUR_KEYS(210012, "物料四要素（名称+型号+规格+计量单位）重复，请修改后提交！"),

    RESOURCES_ERROR_RELATION_MATERIAL_CODE(210011,"物料CODE对应的物料信息数据异常，请联系管理员"),
    RESOURCES_ERROR_RELATION_MATERIAL_CODE_CATEGORY(210011,"物料CODE对应的物料信息数据异常，请联系管理员"),
    APPROVAL_INITIATION_PROCESS_FAIL_MATERIAL(210009,    "发起物料申请审核流程失败!"),
    APPROVAL_INITIATION_PROCESS_FAIL_PUBLISH(210010,    "发起公告发文申请审核流程失败!"),
    APPROVAL_INITIATION_PROCESS_FAIL_PRICE_APPLY(210011,    "发起集采物料-集采价格申请审核流程失败!"),
    APPROVAL_INITIATION_PROCESS_FAIL_SKU_PRICE_APPLY(210012,    "发起集采SKU-集采价格申请审核流程失败!"),
    APPROVAL_INITIATION_PROCESS_FAIL_JUDGE_APPLY(210013,    "发起评委申请审核流程失败!"),
    APPROVAL_INITIATION_PROCESS_FAIL_ADVANCE_NOTICE_APPLY(210013,    "发起批前公示申请审核流程失败!"),

    REPEAT_CODE_CATEGORY_CODE_RULE(210009, "同层级物料编码规则重复，请核实后操作"),

    RESOURCE_OVERFLOW_LIMIT_CATEGORY_CODE(210010, "当前分类编码编码已达最大值999，，禁止当前操作"),

    DATA_OUT_OF_BOUNDS_SCORE(210011, "数据越界：得分禁止超过设定值，请核实后操作"),

    CONTRACT_NOT_FOUND(220001, "资源不存在"),
    RESOURCES_STATUS_OUT_OF_DRAFT(220002, "合同状态非草稿，禁止当前操作"),

    RESOURCES_OCCUPANCY_JUDGE_USER(210004, "已存在绑定当前用户的评委，禁止当前操作"),

    RESOURCES_ERROR_RELATION_GROUP_ID(210011,"集采价格ID对应数据异常，请联系管理员"),
    RESOURCES_ERROR_RELATION_GROUP_PRICE_START(210012,"集采价格采购价-开始采购数量数据异常，请联系管理员"),
    ;
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
