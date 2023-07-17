package com.cateyes.smart.park.invest.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.cateyes.smart.park.base.utils.FunctionUtil;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.base.BaseDto;
import com.cateyes.smart.park.base.utils.PageInfo;
import com.cateyes.smart.park.base.utils.PageUtil;

/**
 * Description: 公共实现
 *
 * @author: CatEyes
 * @date: 2023/3/31 10:03
 */
public class SpBaseServiceImpl {
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
        return PageUtil.build(dto.getPageNo(), dto.getPageSize(), resultPage.getRecords(), (int)resultPage.getTotal());
    }

    protected <T, M, N> Map<M, N> collectionToMap(BaseMapper<T> mapper, Function<T, M> key, Function<T, N> item,
        Collection<? extends Serializable> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Maps.newHashMap();
        }
        List<T> ts = mapper.selectBatchIds(idList);
        return FunctionUtil.collectionToMap(ts, key, item);
    }

}
