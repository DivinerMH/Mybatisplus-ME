package com.menghuan.generator.tools.kafka;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @create 2020/6/5 0005 14:27
 */
@Data
public class KafkaMsgEntity {

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 用户集合id
     */
    private List<String> userIds;

    /**
     * 用户id
     */
    private String userID;

    /**
     * 操作code
     */
    private String handlerCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 类型
     */
    private String types;

    /**
     * 邮件发送给谁
     */
    private String toEmail;

    /**
     * 消息类型
     */
    private String msgType;

    private Integer id;
}
