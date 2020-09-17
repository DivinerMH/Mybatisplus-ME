package com.menghuan.tools.config;

/**
 **/
public class RedisKey {

    public static final String tcpServerChannidAndEidCache = "tcpServerCache:%s";
    //指令下发标识 eid
    public static final String sendFlag     = "sendFlag:%s";

    //采集报警数据key
    public static final String alarmOpenCollectValue           = "alarmOpenCollectValue:productId:%s:machineId:%s:attrId:%s";
    //采集报警数据key
    public static final String alarmEndCollectValue           = "alarmEndCollectValue:productId:%s:machineId:%s:attrId:%s";

    //工作时段报警开始时间
    public static final String alarmWorkStartTime           = "alarmWorkStartTime:productId:%s:machineId:%s";
    //工作时段报警持续时长
    public static final String alarmWorkTimeValue           = "alarmWorkTimeValue:productId:%s:machineId:%s";
    //按次按量统计数据
    public static final String alarmWorkSpecifiedCount     = "alarmWorkSpecifiedCount:productId:%s:machineId:%s:attrId:%s";
    //重复报警次数
    public static final String alarmRemindersTime     = "alarmRemindersTime:productId:%s:machineId:%s:bussinessId:%s";
    //打卡记录数据
    public static final String signInRecordData     = "signInRecordData:userId:%s:date:%s";
    //假日补休日 array
    public static final String holidaysWorkDay     = "holidaysWorkDay";
    //法定假日 array
    public static final String holidaysDay     = "holidaysDay";


    //设备上传数据时间戳
    public static final String machineUpStreamTimeMills     = "machineUpStreamTimeMills:machineId:%s";
    //设备在线状态集合
    public static final String machineOnlineStateKey     = "machineOnlineState";
    //设备运行数据集合 :proId:machineId
    public static final String machineWorkingData     = "machineWorkingData:%s:%s";

    //海康门禁绑定 设备ID 和设备登录ID
    public static final String hcEntranceLoginId     = "hcEntranceLoginId:machineId:%s";

    //海康门禁绑定 卡号  卡数据
    public static final String hcCardBindCardData     = "hcCardBindCardData:cardNo:%s";

    //海康门禁 布放标识
    public static final String hcAlarmHandleFlag     = "hcAlarmHandleFlag:machineId:%s";

    //海康门禁绑定 设备ID 和设备登录ID
    public static final String hcCardNoBindCardInfo     = "hcCardNoBindCardInfo:cardNo:%s";


}
