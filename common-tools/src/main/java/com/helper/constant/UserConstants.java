package com.helper.constant;

/**
 * @author Ivan
 * @date 2020/07/15
 */
public interface UserConstants {

    /**
     * 租户类型(0=系统租户, 1=平台租户, 2=普通租户)
     */
    String SYSTEM_TENANT_TYPE = "0";

    String PLATFORM_TENANT_TYPE = "1";

    String ORDINARY_TENANT_TYPE = "2";

    /**
     * 用户类型(1=临时, 2=正式)
     */
    String TEMPORARY_USERINFO_TYPE = "1";

    String FORMAL_USERINFO_TYPE = "2";

    /**
     * 数据标识(0=未传, 1=即时, 2=选取)
     */
    Integer PARAM_NOT_PASSED = 0;

    Integer INSTANT_DELIVERY = 1;

    Integer LIBRARY_SELECTION = 2;

    /**
     * 业务类型(1=账号, 2=人脸, 3=卡号, 4=车牌, 5=微信)
     */
    String TYPES_OF_USER = "1";

    String TYPES_OF_FACE = "2";

    String TYPES_OF_CARD = "3";

    String TYPES_OF_CAR = "4";

    String TYPES_OF_WECHAT = "5";

    /**
     * AI对接参数
     */
    String AI_FACE_ATTRCODE = "faceImg";                //AI人脸监听attrCode

    String AI_FACE_CUTOUT_ATTRCODE = "cutoutImage";     //AI人脸抠图监听attrCode

    String MESSAGE_TOPIC = "iot_webpush_push";          //消息推送topic

    /**
     * WebPush 消息配置
     */
    String SEND_VERIFICATION_CODE = "send_verification_code";           //短信验证码(对应消息配置表的消息编码)

    String FACE_ILLEGAL_SEND_MSG = "face_illegal_remind";               //人脸不合法消息提醒编码


}
