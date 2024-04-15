package com.cateyes.data.govern.bi.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Strram;
import java.io.Serializable;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;

import com.cateyes.data.govern.bi.bean.dto.RspBiReportFieldDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportFieldQueryDto;
import com.cateyes.data.govern.bi.bean.po.BiReportField;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 报表-字段管理(DgBiReportField)impl
 *
 * @author CatEyes
 * @since 2024-03-19 14:41:41
 */
@Service
@AllArgsConstructor
public class BiReportFieldServiceImpl implements IBiReportFieldService {

    private BiReportFieldMapper biReportFieldMapper;

    @Override
    public int add(ReqBiReportFieldAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        BiReportField map = BeanMapperUtil.map(reqDto, BiReportField.class);
        int insert = biReportFieldMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        BiReportField entity = biReportFieldMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return biReportFieldMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqBiReportFieldUpdateDto reqDto) {
        BiReportField biReportField = biReportFieldMapper.selectById(reqDto.getId());
        Assert.notNull(biReportField, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(biReportField.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return biReportFieldMapper.updateById(BeanMapperUtil.map(reqDto, BiReportField.class));
    }

    @Override
    public RspBiReportFieldDto detail(ReqIdDto reqDto) {
        RspBiReportFieldDto rspDto = biReportFieldMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspBiReportFieldDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspBiReportFieldDto> queryPage(ReqBiReportFieldQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspBiReportFieldDto> queryPageConditions(ReqBiReportFieldQueryDto reqDto) {
        Page<RspBiReportFieldDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspBiReportFieldDto> pageInfo = biReportFieldMapper.queryByConditions(page, reqDto);
        PageInfo<RspBiReportFieldDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspBiReportFieldDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = biReportFieldMapper.selectCount(
    // Wrappers.<BiReportField>lambdaQuery().eq(StringUtils.isNotBlank(name),BiReportField::getName, name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
