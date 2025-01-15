package com.base.valid;

import java.io.Serializable;
import java.util.List;

import com.base.dto.BaseDto;
import com.base.util.PageInfo;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/3/30 20:36
 */
public interface SpBaseService<T, K extends BaseDto> {

    int add(K k) throws RuntimeException;

    int delete(Serializable id) throws RuntimeException;

    int update(K k) throws RuntimeException;

    T detail(Serializable id) throws RuntimeException;

    List<T> query(K k);

    PageInfo<T> queryPage(K k);

}
