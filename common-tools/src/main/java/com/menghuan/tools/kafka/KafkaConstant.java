package com.menghuan.tools.kafka;

public class KafkaConstant {
    //用户注册人脸信息上传 topic
    public static final String SEND_FACE_REGISTERED_TOPIC = "iot_entrance_sendCardFail_admin_entrance";

    // 外访申请后人脸信息上传 topic
    public static final String SEND_FACE_REGISTERED_VISITORS_TOPIC = "iot_entrance_sendCardFail_visitors_entrance";

    //协议解析模块 上行数据topic
    public static final String UP_UPSTREAM_TOPIC = "iot_protocol_hex_upstream_topic";

    //协议解析模块 下发数据topic
    public static final String SEND_TOPIC = "iot_protocol_send_topic";

    //协议解析模块 异常下发数据 topic
    public static final String SEND_FAIL_TOPIC = "iot_protocol_send_fail_topic";

    //协议解析模块 属性数据实时推送
    public static final String SEND_PROPERTY_DATA_TOPIC = "iot_protocol_property_push";

    //协议解析模块 异步组装下发应答指令topic
    public static final String SEND_ASK_DATA_TOPIC = "iot_protocol_send_ask_push";

    //协议解析模块 pgsql数据异步存储
    public static final String SEND_PGSQL_DATA_TOPIC = "iot_protocol_pgsql_insert";

    //协议解析模块 pgsql数据异步存储
    public static final String Analysis_Data_Push = "iot_protocol_analysisdata_push";


    //业务引擎模块 上行报警数据topic
    public static final String SEND_TO_ALARM = "iot_engine_alarm_topic";
    //报警业务模块  上行报警数据topic
    public static final String SEND_TO_ALARM_BUSSINESS = "iot_engine_alarm_bussiness_topic";
    //业务引擎模块 消息topic
    public static final String SEND_TO_MESSAGE_BUS = "iot_engine_message_topic";

    //业务引擎模块 工单topic
    public static final String SEND_TO_WORK_ORDER = "iot_engine_work_order_topic";

    //业务引擎模块 大屏topic
    public static final String SEND_TO_SCREEN = "iot_engine_screen_topic";

    //协议解析 mqttJson数据上送主题
    public static final String UP_UPSTREAM_MQ_JSON_TOPIC = "iot_protocol_mq_json_upstream_topic";

    //协议解析 mqtt进制数据上送主题
    public static final String UP_UPSTREAM_MQ_HEX_TOPIC = "iot_protocol_mq_hex_upstream_topic";

    //考勤模块 考勤数据上送主题
    public static final String UP_UPSTREAM_ATTENDANCE_TOPIC = "iot_attendance_upstream_topic";

    // 外访管理模块 新增人脸topic
    public static final String SEND_TO_VISITORS_FACE_ADD = "iot_visitors_send_face_topic";

    // 外访管理模块 新增车牌topic
    public static final String SEND_TO_VISITORS_CAR_ADD = "iot_visitors_send_car_topic";

    // 外访记录topic
    public static final String SEND_RECORDING_VISITORS_TOPIC = "iot_visitors_recording_topic_visitors_entrance";

    //门禁模块 下发卡数据到门禁业务主题
    public static final String SEND_ENTRANCE_CARD_TOPIC = "iot_entrance_send_card_topic";

    //门禁模块 海康门禁一体机SDK服务使用  下发卡到海康设备主题
    public static final String SEND_ENTRANCE_HC_CARD_TOPIC = "iot_entrance_hc_send_card_topic";

    //门禁模块 与 海康门禁一体机SDK服务使用  下发卡到海康设备异常主题
    public static final String SEND_ENTRANCE_HC_CARD_FAIL_TOPIC = "iot_entrance_hc_send_card_fail_topic";

    // Activiti 回调topic
    public static final String SEND_TO_ACTIVITI_BACK = "iot_activiti_back_topic";

    //支付回调 用于在调用支付接口后成功后的通知调用方
    public static final String IOT_PAY_CALLBACK_MESSAGE="iot_pay_callback_message";

    public static final String UP_UPSTREAM_TOPIC_CONSUMER_GROUP_1 = "UP_UPSTREAM_TOPIC_CONSUMER_GROUP_1";

    public static final String GROUP_1 = "group_1";

    /**
     * 停车场组
     */
    public static final String GROUP_PARKING = "group_parking";

    /**
     * webpush组
     */
    public static final String GROUP_WEBPUSH = "group_webpush";

    public static final String CLIENT_1 = "client_1";

    public static final String TEST = "test";

    //消息模块  消息主题
    public static final String SEND_TO_WEBPUSH_PUSH = "iot_webpush_push";

    public static final String SEND_TO_WEBPUSH_MESSAGE = "iot_webpush_message";

    public static final String IOT_WEBPUSH_SMS_PUSH = "iot_webpush_sms_push";

    public static final String IOT_WEBPUSH_MESSAGE_PUSH = "iot_webpush_message_push";

    public static final String IOT_WEBPUSH_MESSAGE_PUSH_ALL = "iot_webpush_message_push_all";

    public static final String IOT_WEBPUSH_EMIL_PUSH = "iot_webpush_emil_push";

    public static final String IOT_PROTOCOL_BILL_PUSH = "iot_protocol_bill_push";

    public static final String IOT_TRACK_DEVICE_MESSAGE = "iot_track_device_message";

    //协议解析数据监听topic路由键  iot_protocol_data_(消费者appKey)_(生产者appKey)
    public static final String IOT_PROTOCOL_DATA_KEY= "iot_protocol_data_";
    //报警业务监听协议解析上行数据
    public static final String ALARM_RECIVE_PROTOCOL_DATA= "alarm_protocol";
    //自动化业务监听协议解析上行数据
    public static final String AUTO_RECIVE_PROTOCOL_DATA= "auto_protocol";
    //门禁业务监听协议解析上行数据
    public static final String ENTRANCE_RECIVE_PROTOCOL_DATA= "entrance_protocol";
    //轨迹追踪业务监听协议解析上行数据
    public static final String TRACK_RECIVE_PROTOCOL_DATA= "track_protocol";
    //停车场监听协议解析上行数据
    public static final String PARKING_RECIVE_PROTOCOL_DATA= "parking_protocol";
    //用户业务监听协议解析上行数据
    public static final String ADMIN_RECIVE_PROTOCOL_DATA= "admin_protocol";
    //设备数据监听协议解析上行数据
    public static final String  DEVICEDATA_RECIVE_PROTOCOL_DATA = "devicedata_protocol";

    //设备离线告警队列
    public static final String  IOT_DEVICE_OFFLINE_ALARM = "iot_device_offline_alarm";

    //摄像头告警队列
    public static final String  IOT_CAMERA_ALARM = "iot_camera_alarm";

    //应用间消息主题 应用名_路由键_(消费者appKey)_(生产者appKey)

    //门禁下发卡失败主题key
    public static final String SEND_CARD_FAIL_KEY= "iot_entrance_sendCardFail_";

}
