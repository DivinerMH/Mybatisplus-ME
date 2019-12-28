package com.fitmgr.quota.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 友链表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 连接名称
     */
    private String name;

    /**
     * 连接URL
     */
    private String url;


}
