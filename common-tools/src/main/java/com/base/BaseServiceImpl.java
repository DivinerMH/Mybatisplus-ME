package com.base;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.BaseDto;
import com.base.PageInfo;
import com.base.PageUtil;
import com.base.SerializableCodeUtil;
import com.google.common.collect.Maps;

/**
 * Description: 业务基类
 *
 * @author: CatEyes
 * @date: 2023/6/05 10:03
 */
@Component
public class BaseServiceImpl {
    /**
     * Description: 公共分页查询-单表
     *
     * @param mapper
     * @param wrapper
     * @param dto
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

    protected <T, M> Map<M, T> collectionToMap(BaseMapper<T> mapper, Function<T, M> key,
        Collection<? extends Serializable> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Maps.newHashMap();
        }
        List<T> ts = mapper.selectBatchIds(idList);
        return Optional.ofNullable(ts.stream().collect(Collectors.toMap(t -> key.apply(t), t -> t)))
            .orElse(Maps.newHashMap());
    }

    protected <T> T converterDate(T reqDto) {
        try {
            Method getDateMethod = reqDto.getClass().getMethod("getDate", Date.class);
            Method setYearMethod = reqDto.getClass().getMethod("setYear", Integer.class);
            Method setMonthMethod = reqDto.getClass().getMethod("setMonth", Integer.class);
            Object dateValue = getDateMethod.invoke(reqDto);
            if (dateValue != null) {
                Pair<Integer, Integer> pair = getCalendar((Date)dateValue);
                // 设置 year 和 month 属性
                setYearMethod.invoke(reqDto, pair.getLeft());
                setMonthMethod.invoke(reqDto, pair.getRight());
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // 处理反射异常
        }
        return reqDto;
    }

    Pair<Integer, Integer> getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        return Pair.of(year, month);
    }

    private static final String INIT_CODE = "0000";
    private static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * 自动构建唯一编码
     * 
     * @return 唯一编码
     */
    protected <T> String generateUniqueCode(BaseMapper<T> mapper, SFunction<T, String> codeExtractor, String prefix) {
        // 唯一编码：年月日（6位）+ 四位自增id
        String formatString = LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
        List<T> entities = mapper.selectList(Wrappers.<T>lambdaQuery().likeRight(codeExtractor, prefix + formatString));
        if (CollectionUtils.isEmpty(entities)) {
            return prefix + formatString + INIT_CODE;
        }
        String code = entities.stream().map(codeExtractor).max(Comparator.comparing(String::valueOf)).orElse(null);
        if (StringUtils.isNotBlank(code)) {
            return prefix
                + SerializableCodeUtil.incrementCode(Optional.ofNullable(code.substring(prefix.length())).orElse(null));
        }
        return prefix + formatString + INIT_CODE;
    }

    /*Map<Integer, String> userMap(RbacApiClient rbacApiClient, List<Integer> ids) {
        List<Map<String, Object>> maps = rbacApiClient.selectByIds(ReqSysUserIdsDto.builder().userIds(ids).build());
        if (CollectionUtils.isEmpty(maps)) {
            return Maps.newHashMap();
        }
        Map<Integer, String> map = Maps.newHashMapWithExpectedSize(16);
        maps.forEach(a -> map.put(Integer.parseInt(a.get(Cst.ID).toString()), a.get(Cst.NICKNAME).toString()));
        return map;
    }
    
    Map<Integer, String> parkMap(ResourceApiClient resourceApiClient, List<Integer> ids) {
        List<RspQueryParkDto> list = resourceApiClient.parkList(ReqQueryParkDto.builder().ids(ids).build());
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return Optional
            .ofNullable(list.stream().collect(Collectors.toMap(RspQueryParkDto::getId, RspQueryParkDto::getParkName)))
            .orElse(Maps.newHashMapWithExpectedSize(16));
    }*/

}
