package com.cateyes.data.govern.bi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqDgBiReportFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspDgBiReportFieldDto;
import com.cateyes.data.govern.bi.bean.po.DgBiReportField;

/**
 * 报表-字段管理(DgBiReportField)impl
 *
 * @author CatEyes
 * @since 2024-03-19 14:40:06
 */
@Service
@AllArgsConstructor
public class DgBiReportFieldServiceImpl implements IDgBiReportFieldService {

    private DgBiReportFieldMapper dgBiReportFieldMapper;

    @Override
    public int add(ReqDgBiReportFieldAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        DgBiReportField map = BeanMapperUtil.map(reqDto, DgBiReportField.class);
        int insert = dgBiReportFieldMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        DgBiReportField entity = dgBiReportFieldMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return dgBiReportFieldMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqDgBiReportFieldUpdateDto reqDto) {
        DgBiReportField dgBiReportField = dgBiReportFieldMapper.selectById(reqDto.getId());
        Assert.notNull(dgBiReportField, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(dgBiReportField.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return dgBiReportFieldMapper.updateById(BeanMapperUtil.map(reqDto, DgBiReportField.class));
    }

    @Override
    public RspDgBiReportFieldDto detail(ReqIdDto reqDto) {
        RspDgBiReportFieldDto rspDto = dgBiReportFieldMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspDgBiReportFieldDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspDgBiReportFieldDto> queryPage(ReqDgBiReportFieldQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspDgBiReportFieldDto> queryPageConditions(ReqDgBiReportFieldQueryDto reqDto) {
        Page<RspDgBiReportFieldDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspDgBiReportFieldDto> pageInfo = dgBiReportFieldMapper.queryByConditions(page, reqDto);
        PageInfo<RspDgBiReportFieldDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspDgBiReportFieldDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = dgBiReportFieldMapper.selectCount(
    // Wrappers.<DgBiReportField>lambdaQuery().eq(StringUtils.isNotBlank(name),DgBiReportField::getName, name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
