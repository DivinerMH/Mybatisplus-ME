package com.base.service;

import java.io.Serializable;
import java.util.List;

import com.base.util.PageInfo;

/**
 * Description: 基础Service
 *
 * @author: CatEyes
 * @date: 2023/3/30 20:36
 */

// public interface BaseService<T, K extends BaseDto> {

public interface BaseService<T, K, M, N> {

    int add(K k) throws RuntimeException;

    int delete(Serializable id) throws RuntimeException;

    int update(M m) throws RuntimeException;

    T detail(Serializable id) throws RuntimeException;

    List<T> query(N n);

    PageInfo<T> queryPage(N n);

}
