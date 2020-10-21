package com.menghuan.generator.tools.kafka;



import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Properties;

@Configuration
public class Consumer {

    private static Properties props;
    static {
        props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.KAFKA_SERVER_ADDRESS);
        //设置自动提交偏移量
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, KafkaConfig.CONSUMER_ENABLE_AUTO_COMMIT_CONFIG);
        //提交偏移量的节奏
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, KafkaConfig.CONSUMER_AUTO_COMMIT_INTERVAL_MS_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    }

    public static org.apache.kafka.clients.consumer.Consumer<String,String> getConsumer(String clientId,String groupId) {
        //设置组id
        props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        //消费者实例ID
        props.put(ConsumerConfig.CLIENT_ID_CONFIG,clientId);

        org.apache.kafka.clients.consumer.Consumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
        return kafkaConsumer;
    }

    public static org.apache.kafka.clients.consumer.Consumer<String,String> getConsumer(String clientId,String groupId,String topic) {
        //设置组id
        props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        //消费者实例ID
        props.put(ConsumerConfig.CLIENT_ID_CONFIG,clientId);
        org.apache.kafka.clients.consumer.Consumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
        return kafkaConsumer;
    }

    public static void receive(Object object ,Class<?> cclass,String clientId, String groupId,String topic){
        org.apache.kafka.clients.consumer.Consumer<String,String> consumer= Consumer.getConsumer(clientId,groupId, topic);
        new Thread(){
            @Override
            public void run() {
                while (true){
                    ConsumerRecords<String, String> records = consumer.poll(KafkaConfig.CONSUMER_LICENCE_BLOCK_VALUE);
                    for(ConsumerRecord record : records) {
                        //do something
                        try {
                            Reflection(object,cclass,KafkaConfig.RECEIVE_NAME,record);

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }.start();
    }

    public static Object Reflection(Object object ,Class<?> cclass,String methodName,Object args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = cclass.getMethod(methodName, ConsumerRecord.class);
        return method.invoke(object, args);
    }






}
