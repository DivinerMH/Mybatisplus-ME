package com.menghuan.rocketMQ;


import cn.hutool.core.collection.CollectionUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: menghuan
 * @Date: 2022/10/11 17:14
 */
public class PullConsumer {

    private static final Map<MessageQueue, Long> OFFSE_TABLE = new HashMap<MessageQueue, Long>();

    public static void main(String[] args) throws MQClientException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("please_rename_unique_group_name");
        consumer.setNamesrvAddr("192.168.1.175:9876");
        consumer.start();

        // Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("TopicTest");
        Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("162045694003131010topic");
        for (MessageQueue mq : mqs) {
            System.out.printf("Consume from the queue: %s%n", mq);
            SINGLE_MQ:
            while (true) {
                try {
                    PullResult pullResult =
                            consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
                    System.out.printf("信息：%s%n", pullResult);
                    putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                    List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                    if (CollectionUtil.isNotEmpty(msgFoundList)){
                        for (MessageExt messageExt : msgFoundList) {
                            byte[] body = messageExt.getBody();
                            String s = new String(body,"UTF-8");
                            System.out.println("解析后消息体：" + s);
                        }
                    }else {
                        System.out.println("消息List<MessageExt>为空，数据解析异常");
                    }

                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                            break SINGLE_MQ;
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        consumer.shutdown();
    }

    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = OFFSE_TABLE.get(mq);
        if (offset != null)
            return offset;

        return 0;
    }

    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        OFFSE_TABLE.put(mq, offset);
    }

}
