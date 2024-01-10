package com.cateyes.data.govern.datafill.service.impl;

    
    






import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Strram;
import java.io.Serializable;
import java.util.Optional;

import com.cateyes.base.ApiCode;
import com.cateyes.base.dto.ReqIdDto;
import com.cateyes.base.util.Assert;
import com.cateyes.base.util.BeanMapperUtil;
import com.cateyes.base.util.PageInfo;
import com.cateyes.base.util.PageUtils;
import com.cateyes.data.govern.datafill.dao.BiProjectMapper;
import com.cateyes.data.govern.datafill.service.IBiProjectService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;

import com.cateyes.data.govern.datafill.bean.dto.RspBiProjectDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqBiProjectQueryDto;
import com.cateyes.data.govern.datafill.bean.po.BiProject;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 项目(DgBiProject)impl
 *
 * @author CatEyes
 * @since 2023-12-12 18:24:48
 */
@Service
@AllArgsConstructor
public class BiProjectServiceImpl implements IBiProjectService {

    private BiProjectMapper biProjectMapper;

    @Override
    public int add(ReqBiProjectAddDto reqDto){
        // checkNameUnique(reqDto.getName());
        BiProject map = BeanMapperUtil.map(reqDto, BiProject.class);
        int insert = biProjectMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto){
        BiProject entity = biProjectMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return biProjectMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqBiProjectUpdateDto reqDto){
        BiProject biProject = biProjectMapper.selectById(reqDto.getId());
        Assert.notNull(biProject, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(biProject.getName(), reqDto.getName())) {
            // checkNameUnique(reqDto.getName());
        // }
        return biProjectMapper.updateById(BeanMapperUtil.map(reqDto, BiProject.class));
    }
    
    @Override
    public RspBiProjectDto detail(ReqIdDto reqDto){
        RspBiProjectDto rspDto = biProjectMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspBiProjectDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }
    
    @Override
    public PageInfo<RspBiProjectDto> queryPage(ReqBiProjectQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspBiProjectDto> queryPageConditions(ReqBiProjectQueryDto reqDto) {
        Page<RspBiProjectDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspBiProjectDto> pageInfo = biProjectMapper.queryByConditions(page, reqDto);
        PageInfo<RspBiProjectDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }
    
    private void listConverter(List<RspBiProjectDto> list) {
        list.forEach(a -> {

        });
    }
    
    // private void checkNameUnique(String name) {
    //     Integer count = biProjectMapper.selectCount(
    //         Wrappers.<BiProject>lambdaQuery().eq(StringUtils.isNotBlank(name),BiProject::getName, name);
    //     Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }
    
}
