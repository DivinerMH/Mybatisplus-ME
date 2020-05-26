package com.fitmgr.quota.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户密码记录表
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserPasswordLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    /**
     * 密码日志记录（仅保留最近3次）
     */
    private String passwordLog;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
