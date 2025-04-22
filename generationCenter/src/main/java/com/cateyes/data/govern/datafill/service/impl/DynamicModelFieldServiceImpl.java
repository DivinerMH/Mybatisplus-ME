package com.cateyes.data.govern.datafill.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelFieldUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelFieldDto;
import com.cateyes.data.govern.datafill.bean.po.DynamicModelField;

/**
 * 动态表单字段(DgDynamicModelField)impl
 *
 * @author CatEyes
 * @since 2023-11-20 13:56:08
 */
@Service
@AllArgsConstructor
public class DynamicModelFieldServiceImpl extends SpBaseServiceImpl implements IDynamicModelFieldService {

    private DynamicModelFieldMapper dynamicModelFieldMapper;

    @Override
    public int add(ReqDynamicModelFieldAddDto reqDto) {
        // checkNameUnique(reqDto);
        DynamicModelField map = BeanMapperUtil.map(reqDto, DynamicModelField.class);
        int insert = dynamicModelFieldMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        DynamicModelField entity = dynamicModelFieldMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return dynamicModelFieldMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqDynamicModelFieldUpdateDto reqDto) {
        DynamicModelField dynamicModelField = dynamicModelFieldMapper.selectById(reqDto.getId());
        Assert.notNull(dynamicModelField, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(dynamicModelField.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto);
        // }
        return dynamicModelFieldMapper.updateById(BeanMapperUtil.map(reqDto, DynamicModelField.class));
    }

    @Override
    public RspDynamicModelFieldDto detail(ReqIdDto reqDto) {
        RspDynamicModelFieldDto rspDto = dynamicModelFieldMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspDynamicModelFieldDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspDynamicModelFieldDto> queryPage(ReqDynamicModelFieldQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspDynamicModelFieldDto> queryPageConditions(ReqDynamicModelFieldQueryDto reqDto) {
        Page<RspDynamicModelFieldDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspDynamicModelFieldDto> pageInfo = dynamicModelFieldMapper.queryByConditions(page, reqDto);
        PageInfo<RspDynamicModelFieldDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspDynamicModelFieldDto> list) {
        list.forEach(a -> {

        });
    }

}
