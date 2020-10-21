package com.menghuan.generator.tools.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：余川
 * @date ：Created in 2019/12/10 0010 下午 6:11
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaEntity {
  //容器domainName
  private String proDomainName;
  //下发指令的ID
  private String sendId;
  //重复下发业务  下发指令数据的ID
  private String paramsId;
  //设备表ID
  private String machineId;
  //协议表D
  private String protocolId;
  //产品ID
  private String productId;
  //通道ID
  private String socketId;
  //接口表ID
  private Integer interfaceId;

  //topic 以及 接口地址
  private String mqttTopic;
  //mqtt设备唯一标识
  private String deviceName;
  /*报文数据集合*/
  private Object data;

  /**业务数据集合*/
  /**
   * {"data":[{"attrId":120,"code":"carNo","val":"鄂A123456"},{"attrId":123,“code”:“type”，"val":"1"}],"machineId":"1234","productId":"43"}
   */
  private List<PropData> propDataList;
//{"machineId":"70","productId":"322","propDataList":[{"attrCode":"ZNDBCJDZ","attrId":999,"val":"85"},{"attrCode":"ZNDBDYZ","attrId":1001,"val":"20"}],"timeMills":"1592967130855"}


  //数据上送时的时间戳
  private String timeMills = System.currentTimeMillis()+"";


}
