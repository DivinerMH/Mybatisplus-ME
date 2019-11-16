package com.menghuan.test.mynewemp.entity;

import com.baomidou.ant.common.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author menghuan
 * @since 2019-09-26
 */
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
        "name=" + name +
        ", age=" + age +
        ", email=" + email +
        "}";
    }
}
