package com.menghuan.HuanTools.constants;

/**
 * 通用常量
 *
 * @author menghuan
 * @date 2025-01-24
 */
public interface CommonConstants {

    /** 编码 */
    String UTF8 = "UTF-8";

    /** 前端工程名 */
    String PROJECT_FRONT_END = "menghuan-ui";

    /** 后端工程名 */
    String PROJECT_BACK_END = "menghuan";

    /** 路由存放 */
    String GATEWAY_ROUTE_KEY = "gateway_route_key";

    /** spring boot admin 事件 key */
    String EVENT_KEY = "event_key";

    /** 验证码前缀 */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

    /** 默认存储 bucket */
    String BUCKET_NAME = "test";

    /** 成功标记 */
    Integer SUCCESS = 0;

    /** 失败标记 */
    Integer FAIL = 1;

    /** 成功标记 */
    Boolean TRUE = true;

    /** 失败标记 */
    Boolean FALSE = false;

    /*----------------------------------------------- 系统级 - 通用常量 ----------------------------------------------*/

    /**
     * 服务模板
     */
    interface TemplateConstants {
        /**
         * 下架
         */
        String STATUS_DOWN = "0";

        /**
         * 上架
         */
        String STATUS_UP = "1";
    }

}
