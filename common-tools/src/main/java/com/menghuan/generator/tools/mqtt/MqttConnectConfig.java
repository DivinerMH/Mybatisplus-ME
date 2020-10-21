package com.menghuan.generator.tools.mqtt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author Administrator
 * @version Id: MqttConnectConfig, v 0.1 2020\3\23 0023 16:13 Administrator Exp $$
 **/
@Configuration
public class MqttConnectConfig {

    public static String address;
    @Value("${emqx.brokerAddress}")
    public  void setAddress(String address) {
        MqttConnectConfig.address = address;
    }
    public static String getAddress() {
        return address;
    }

    public final static String MQTT_BROKER_ADDRESS= "tcp://192.168.1.175:1883";
//public final static String MQTT_BROKER_ADDRESS= "tcp://127.0.0.1:1883";

    private final static String CLIENT_ID = "iot_mqtt_monito:";

    public final static String IOT_USERNAME = "iotMonito";

    public final static String IOT_PASSWORD = "linksame123456";

    public static String getClientId() {
        return CLIENT_ID + UUID.randomUUID();
    }
}
