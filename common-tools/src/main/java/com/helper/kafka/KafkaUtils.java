/*
package com.helper.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class KafkaUtils {

    private static final org.slf4j.Logger logger = (org.slf4j.Logger) LoggerFactory.getLogger(KafkaUtils.class);

    */
/**
     * 发送消息
     *
     * @param topic
     * @param massage
     * @return
     *//*

    public static boolean send(String topic, String massage, KafkaProducer kafkaProducer) {
        ProducerRecord<String, String> msgtar = new ProducerRecord<String, String>(topic, massage);
        try {
            kafkaProducer.send(msgtar);
            logger.info("消息发送成功 {}", massage);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("消息发送失败 {}", e.getStackTrace().toString());
        } finally {
            kafkaProducer.flush();
            kafkaProducer.close();
        }
        return true;
    }

    */
/**
     * 发送消息 此方法废弃
     *
     * @param topic
     * @param massage
     * @return
     *//*

    @Deprecated
    public static boolean send(String topic, String massage, String kafkaServerAddress) {
        ProducerRecord<String, String> msgtar = new ProducerRecord<String, String>(topic, massage);
        KafkaProducer kafkaProducer = Producer.getProducer(kafkaServerAddress);
        try {
            kafkaProducer.send(msgtar);
            logger.info("消息发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("消息发送失败 {}", e.getStackTrace().toString());
        } finally {
            kafkaProducer.flush();
            kafkaProducer.close();
        }
        return true;
    }


    */
/**
     * 获取topicList
     *
     * @return
     *//*

    public static Map<String, List<PartitionInfo>> getTopicList() {
        return Consumer.getConsumer("topicClient", "topicGroup").listTopics();
    }


}
*/
