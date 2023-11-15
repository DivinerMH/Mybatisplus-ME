package com.cateyes.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.base.ApiCode;
import com.cateyes.base.dto.BaseDto;
import com.cateyes.base.util.Assert;
import com.cateyes.base.util.PageInfo;
import com.cateyes.base.util.PageUtils;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: 基础Impl
 *
 * @author: CatEyes
 * @date: 2023/3/31 10:03
 */
@Slf4j
public class BaseServiceImpl {
    /**
     * Description: 公共分页查询-单表
     *
     * @param mapper
     * @param wrapper
     * @param dto
     * @return PageInfo<T>
     * @throws @author CatEyes
     * @date 2023/4/3 11:13
     **/
    public <K extends BaseMapper<T>, T> PageInfo<T> query(K mapper, Wrapper<T> wrapper, BaseDto dto) {
        IPage<T> resultPage = mapper.selectPage(new Page<T>(dto.getPageNo(), dto.getPageSize()), wrapper);
        return PageUtils.build(dto.getPageNo(), dto.getPageSize(), resultPage.getRecords(), (int)resultPage.getTotal());
    }

    /**
     * 集合校验
     *
     * @param mapper Mapper
     * @param wrapper Wrapper
     * @param <K>
     * @param <T>
     */
    protected <K extends BaseMapper<T>, T> void checkCollection(K mapper, Wrapper<T> wrapper, ApiCode apiCode) {
        List<T> list = mapper.selectList(wrapper);
        Assert.isTrue(CollectionUtils.isEmpty(list), apiCode);
    }

    protected <T, M, N> Map<M, N> collectionToMap(BaseMapper<T> mapper, Function<T, M> key, Function<T, N> item,
        Collection<? extends Serializable> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Maps.newHashMap();
        }
        List<T> ts = mapper.selectBatchIds(idList);
        return Optional.ofNullable(ts.stream().collect(Collectors.toMap(t -> key.apply(t), t -> item.apply(t))))
            .orElse(Maps.newHashMap());
    }

    protected <T, M> Map<M, T> collectionToMap(BaseMapper<T> mapper, Function<T, M> key,
        Collection<? extends Serializable> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Maps.newHashMap();
        }
        List<T> ts = mapper.selectBatchIds(idList);
        return Optional.ofNullable(ts.stream().collect(Collectors.toMap(t -> key.apply(t), t -> t)))
            .orElse(Maps.newHashMap());
    }
}
