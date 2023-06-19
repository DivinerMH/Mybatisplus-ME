package com.menghuan.snowflakeworker;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: menghuan
 * @Date: 2022/10/9 15:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentTest implements Serializable {

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    private String name;

    private Integer age;

    private String sex;


}


