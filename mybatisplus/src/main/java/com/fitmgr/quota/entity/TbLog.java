package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作描述
     */
    private String operation;

    /**
     * 耗时(毫秒)
     */
    private Long time;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 操作参数
     */
    private String params;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 操作时间
     */
    private LocalDateTime createTime;

    /**
     * 操作地点
     */
    private String location;


}
