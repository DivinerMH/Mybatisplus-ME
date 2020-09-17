package com.menghuan.tools.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author Administrator
 * @version Id: MqttProducer, v 0.1 2020\3\23 0023 16:26 Administrator Exp $$
 **/
public class MqttProducer {
    /**
     *
     * @param client MqttConnectUtils.getMqttClient()
     * @param topic  topic
     * @param payload 数据
     * @throws MqttException
     */
    public static void publish(MqttClient client,String topic,byte[] payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload);
        message.setQos(2);
        client.publish(topic, message);
        System.out.println("pushSuccess");
    }

}
