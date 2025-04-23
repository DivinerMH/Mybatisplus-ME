package com.menghuan.HuanTools.constants;

/**
 * 通用常量
 *
 * @author menghuan
 * @date 2025-01-24
 */
public interface CommonConstants {

    /*----------------------------------------------- 系统级 - 通用常量 ----------------------------------------------*/

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

    /**
     * {@code 500 Server Error} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**
     * {@code 200 OK} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_OK_200 = 200;

    /**
     * 访问权限认证未通过 510
     */
    Integer SC_JEECG_NO_AUTHZ = 510;

    /*----------------------------------------------- 业务级 - 通用常量 ----------------------------------------------*/

    /**
     * 自增编码 - 时间格式
     */
    String DATE_FORMAT = "yyyyMMdd";

    /**
     * 自增编码 - 初始化编码 - 长
     */
    String INIT_CODE = "00000001";

    /**
     * 自增编码 - 初始化编码 - 中
     */
    String INIT_CODE_MIDDLE = "000001";

    /**
     * 自增编码 - 初始化编码 - 短
     */
    String INIT_CODE_SHORT = "0001";



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
