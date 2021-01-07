package com.helper.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
public class Producer {

    private static KafkaProducer KafkaProducer;

    private static Properties props;

    public static Properties getProps(String address) {
        props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, address);
        //重试次数
        props.put(ProducerConfig.RETRIES_CONFIG, KafkaConfig.PRODUCER_RETRIES_CONFIG);
        //数据包大小
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, KafkaConfig.PRODUCER_BATCH_SIZE_CONFIG);
        //等待时间
        props.put(ProducerConfig.LINGER_MS_CONFIG, KafkaConfig.PRODUCER_LINGER_MS_CONFIG);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    public static KafkaProducer<String, String> getProducer(String brokerAddress) {
        return new KafkaProducer<String, String>(Producer.getProps(brokerAddress));
    }


}
