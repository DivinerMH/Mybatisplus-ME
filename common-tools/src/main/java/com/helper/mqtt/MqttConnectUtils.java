package com.helper.mqtt;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author Administrator
 * @version Id: MqttConnect, v 0.1 2020\3\23 0023 16:23 Administrator Exp $$
 **/
public class MqttConnectUtils {

    public static MqttClient getMqttClient(String address) throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        MqttClient client = new MqttClient(address, MqttConnectConfig.getClientId(), persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setUserName(MqttConnectConfig.IOT_USERNAME);
        connOpts.setPassword(MqttConnectConfig.IOT_PASSWORD.toCharArray());
        connOpts.setCleanSession(true);
        connOpts.setConnectionTimeout(10);
        connOpts.setKeepAliveInterval(30);
        //设置断开后重新连接
        connOpts.setAutomaticReconnect(true);
        if (!client.isConnected()) {
            client.connect(connOpts);
        }
        System.out.println("Connected");
        return client;
    }
}
