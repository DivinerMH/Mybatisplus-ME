package com.menghuan.testcase;

import java.io.Serializable;

import lombok.Data;

/**
 * @Author:menghuan
 * @Date:2020/12/16 16:47
 */
@Data
public class TemporaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer configId;

    private String ruleType;

    private Integer ruleId;

}
