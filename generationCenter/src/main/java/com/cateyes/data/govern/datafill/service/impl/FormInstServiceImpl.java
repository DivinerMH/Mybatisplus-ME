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

import com.cateyes.data.govern.datafill.bean.dto.RspFormInstDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqFormInstQueryDto;
import com.cateyes.data.govern.datafill.bean.po.FormInst;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 表单实例(DgFormInst)impl
 *
 * @author CatEyes
 * @since 2023-11-21 10:16:01
 */
@Service
@AllArgsConstructor
public class FormInstServiceImpl extends SpBaseServiceImpl implements IFormInstService {

    private FormInstMapper formInstMapper;

    @Override
    public int add(ReqFormInstAddDto reqDto) {
        // checkNameUnique(reqDto);
        FormInst map = BeanMapperUtil.map(reqDto, FormInst.class);
        int insert = formInstMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        FormInst entity = formInstMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return formInstMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqFormInstUpdateDto reqDto) {
        FormInst formInst = formInstMapper.selectById(reqDto.getId());
        Assert.notNull(formInst, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(formInst.getName(), reqDto.getName())) {
        // checkNameUnique(reqDto);
        // }
        return formInstMapper.updateById(BeanMapperUtil.map(reqDto, FormInst.class));
    }

    @Override
    public RspFormInstDto detail(ReqIdDto reqDto) {
        RspFormInstDto rspDto = formInstMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspFormInstDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspFormInstDto> queryPage(ReqFormInstQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspFormInstDto> queryPageConditions(ReqFormInstQueryDto reqDto) {
        Page<RspFormInstDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspFormInstDto> pageInfo = formInstMapper.queryByConditions(page, reqDto);
        PageInfo<RspFormInstDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspFormInstDto> list) {
        list.forEach(a -> {

        });
    }

}
