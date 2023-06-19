package com.menghuan.common.core.constant;

/**
 * <p>
 * CommonConstants 通用常量
 * </p>
 *
 * @author dzl
 * @date 2017/10/29
 */
public interface CommonConstants {

    /**
     * header 中租户ID
     */
    String TENANT_ID = "TENANT_ID";
    /**
     * 删除(禁用)
     */
    String STATUS_DEL = "1";
    /**
     * 正常（启用）
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 菜单
     */
    String MENU = "0";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * 前端工程名
     */
    String FRONT_END_PROJECT = "fitmgr-ui";

    /**
     * 后端工程名
     */
    String BACK_END_PROJECT = "fitmgr";

    /**
     * 路由存放
     */
    String ROUTE_KEY = "gateway_route_key";

    /**
     * spring boot admin 事件key
     */
    String EVENT_KEY = "event_key";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;
    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 默认存储bucket
     */
    String BUCKET_NAME = "test";
    /**
     * 删除(禁用)
     */
    String ELASTICITY_YES = "1";
    /**
     * 正常（启用）
     */
    String ELASTICITY_NO = "0";

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
