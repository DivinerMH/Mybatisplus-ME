package com.helper.kafka;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {


    public final static String KAFKA_SERVER_ADDRESS = "192.168.1.176:9092";

    public final static String RECEIVE_NAME = "receiveHandle";

    /*生产者者配置*/
    //重试次数
    public final static int PRODUCER_RETRIES_CONFIG = 0;
    //最大发送数据包量
    public final static int PRODUCER_BATCH_SIZE_CONFIG = 1048576;
    //等待时间  0 即时发送
    public final static int PRODUCER_LINGER_MS_CONFIG = 0;


    /*消费者配置*/
    //设置自动提交偏移量
    public final static boolean CONSUMER_ENABLE_AUTO_COMMIT_CONFIG = true;
    public final static int CONSUMER_AUTO_COMMIT_INTERVAL_MS_CONFIG = 1000;
    //监听线程阻塞时间 1s
    public final static int CONSUMER_LICENCE_BLOCK_VALUE = 1000;


}
