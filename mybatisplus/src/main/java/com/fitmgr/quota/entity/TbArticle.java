package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 作者
     */
    private String author;

    /**
     * 内容
     */
    private String content;

    /**
     * 内容-Markdown
     */
    private String contentMd;

    /**
     * 分类
     */
    private String category;

    /**
     * 来源
     */
    private String origin;

    /**
     * 状态
     */
    private String state;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 上次修改时间
     */
    private LocalDateTime editTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 类型， 0原创 1转载
     */
    private Integer type;


}
