package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父级ID，给哪个留言进行回复
     */
    private Long pId;

    /**
     * 子级ID，给哪个留言下的回复进行评论
     */
    private Long cId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 昵称
     */
    private String name;

    /**
     * 给谁留言
     */
    private String cName;

    /**
     * 留言时间
     */
    private LocalDateTime time;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 网址
     */
    private String url;

    /**
     * 分类：0:默认，文章详情页，1:友链页，2:关于页
     */
    private Long sort;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 设备
     */
    private String device;

    /**
     * 地址
     */
    private String address;


}
