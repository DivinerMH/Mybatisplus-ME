package com.cateyes.smart.park.iot.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.base.bean.dto.BaseDto;
import com.cateyes.base.bean.vo.PageInfo;
import com.cateyes.base.util.PageUtil;
import com.cateyes.smart.park.core.common.Cst;
import com.cateyes.smart.park.feign.bean.dto.ReqQueryParkDto;
import com.cateyes.smart.park.feign.bean.dto.ReqSysUserIdsDto;
import com.cateyes.smart.park.feign.bean.dto.RspQueryParkDto;
import com.cateyes.smart.park.feign.client.RbacApiClient;
import com.cateyes.smart.park.feign.client.ResourceApiClient;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/3/31 10:03
 */
@Slf4j
@AllArgsConstructor
public class SpBaseServiceImpl {

    /**
     * Description: 公共分页查询-单表
     * 
     * @param mapper
     * @param wrapper
     * @return PageInfo<T>
     * @throws @author
     *             CatEyes
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
        return Optional.ofNullable(ts.stream().collect(Collectors.toMap(t -> key.apply(t), t -> item.apply(t))))
            .orElse(Maps.newHashMap());
    }

    Map<Integer, String> userMap(RbacApiClient rbacApiClient, List<Integer> ids) {
        Map<Integer, String> map = Maps.newHashMapWithExpectedSize(16);
        try {
            List<Map<String, Object>> maps = rbacApiClient.selectByIds(ReqSysUserIdsDto.builder().userIds(ids).build());
            if (CollectionUtils.isEmpty(maps)) {
                return Maps.newHashMap();
            }
            maps.forEach(a -> map.put(Integer.parseInt(a.get(com.cateyes.smart.park.core.common.Cst.ID).toString()),
                a.get(Cst.NICKNAME).toString()));
        } catch (Exception e) {
            log.info("rbacApiClient.selectByIds() 异常");
        }
        return map;
    }

    Map<Integer, String> parkMap(ResourceApiClient resourceApiClient, List<Integer> ids) {
        try {
            List<RspQueryParkDto> list = resourceApiClient.parkList(ReqQueryParkDto.builder().ids(ids).build());
            if (CollectionUtils.isEmpty(list)) {
                return Maps.newHashMap();
            }
            return Optional
                .ofNullable(
                    list.stream().collect(Collectors.toMap(RspQueryParkDto::getId, RspQueryParkDto::getParkName)))
                .orElse(Maps.newHashMapWithExpectedSize(16));
        } catch (Exception e) {
            log.info("resourceApiClient.parkList() 异常");
        }
        return Maps.newHashMapWithExpectedSize(16);
    }

}
