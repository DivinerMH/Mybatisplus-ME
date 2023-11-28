package com.cateyes.data.govern.datafill.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.cateyes.data.govern.datafill.bean.dto.RspFormInstFieldDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstFieldQueryDto;
import com.cateyes.data.govern.datafill.bean.po.FormInstField;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 表单实例数据(DgFormInstField)impl
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:35
 */
@Service
@AllArgsConstructor
public class FormInstFieldServiceImpl extends SpBaseServiceImpl implements IFormInstFieldService {

    private FormInstFieldMapper formInstFieldMapper;

    @Override
    public int add(ReqFormInstFieldAddDto reqDto) {
        // checkNameUnique(reqDto);
        FormInstField map = BeanMapperUtil.map(reqDto, FormInstField.class);
        int insert = formInstFieldMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        FormInstField entity = formInstFieldMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return formInstFieldMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqFormInstFieldUpdateDto reqDto) {
        FormInstField formInstField = formInstFieldMapper.selectById(reqDto.getId());
        Assert.notNull(formInstField, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(formInstField.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto);
        // }
        return formInstFieldMapper.updateById(BeanMapperUtil.map(reqDto, FormInstField.class));
    }

    @Override
    public RspFormInstFieldDto detail(ReqIdDto reqDto) {
        RspFormInstFieldDto rspDto = formInstFieldMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspFormInstFieldDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspFormInstFieldDto> queryPage(ReqFormInstFieldQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspFormInstFieldDto> queryPageConditions(ReqFormInstFieldQueryDto reqDto) {
        Page<RspFormInstFieldDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspFormInstFieldDto> pageInfo = formInstFieldMapper.queryByConditions(page, reqDto);
        PageInfo<RspFormInstFieldDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspFormInstFieldDto> list) {
        list.forEach(a -> {

        });
    }

}
