package com.cateyes.data.govern.bi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiDatasetFieldUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiDatasetFieldDto;
import com.cateyes.data.govern.bi.bean.po.BiDatasetField;

/**
 * 数据集-字段管理(DgBiDatasetField)impl
 *
 * @author CatEyes
 * @since 2023-12-21 14:40:46
 */
@Service
@AllArgsConstructor
public class BiDatasetFieldServiceImpl implements IBiDatasetFieldService {

    private BiDatasetFieldMapper biDatasetFieldMapper;

    @Override
    public int add(ReqBiDatasetFieldAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        BiDatasetField map = BeanMapperUtil.map(reqDto, BiDatasetField.class);
        int insert = biDatasetFieldMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        BiDatasetField entity = biDatasetFieldMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return biDatasetFieldMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqBiDatasetFieldUpdateDto reqDto) {
        BiDatasetField biDatasetField = biDatasetFieldMapper.selectById(reqDto.getId());
        Assert.notNull(biDatasetField, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(biDatasetField.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return biDatasetFieldMapper.updateById(BeanMapperUtil.map(reqDto, BiDatasetField.class));
    }

    @Override
    public RspBiDatasetFieldDto detail(ReqIdDto reqDto) {
        RspBiDatasetFieldDto rspDto = biDatasetFieldMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspBiDatasetFieldDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspBiDatasetFieldDto> queryPage(ReqBiDatasetFieldQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspBiDatasetFieldDto> queryPageConditions(ReqBiDatasetFieldQueryDto reqDto) {
        Page<RspBiDatasetFieldDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspBiDatasetFieldDto> pageInfo = biDatasetFieldMapper.queryByConditions(page, reqDto);
        PageInfo<RspBiDatasetFieldDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspBiDatasetFieldDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = biDatasetFieldMapper.selectCount(
    // Wrappers.<BiDatasetField>lambdaQuery().eq(StringUtils.isNotBlank(name),BiDatasetField::getName, name);
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
