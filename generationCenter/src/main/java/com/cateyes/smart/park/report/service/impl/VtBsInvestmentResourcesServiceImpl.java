package com.cateyes.smart.park.report.service.impl;

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

import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentResourcesDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesUpdateDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentResourcesQueryDto;
import com.cateyes.smart.park.report.bean.po.VtBsInvestmentResources;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 智慧大屏-手工-招商资源(SpVtBsInvestmentResources)impl
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:48
 */
@Service
@AllArgsConstructor
public class VtBsInvestmentResourcesServiceImpl implements IVtBsInvestmentResourcesService {

    private VtBsInvestmentResourcesMapper vtBsInvestmentResourcesMapper;

    @Override
    public int add(ReqVtBsInvestmentResourcesAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        VtBsInvestmentResources map = BeanMapperUtil.map(reqDto, VtBsInvestmentResources.class);
        int insert = vtBsInvestmentResourcesMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        VtBsInvestmentResources entity = vtBsInvestmentResourcesMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return vtBsInvestmentResourcesMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqVtBsInvestmentResourcesUpdateDto reqDto) {
        VtBsInvestmentResources vtBsInvestmentResources = vtBsInvestmentResourcesMapper.selectById(reqDto.getId());
        Assert.notNull(vtBsInvestmentResources, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(vtBsInvestmentResources.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return vtBsInvestmentResourcesMapper.updateById(BeanMapperUtil.map(reqDto, VtBsInvestmentResources.class));
    }

    @Override
    public RspVtBsInvestmentResourcesDto detail(ReqIdDto reqDto) {
        RspVtBsInvestmentResourcesDto rspDto = vtBsInvestmentResourcesMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspVtBsInvestmentResourcesDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspVtBsInvestmentResourcesDto> queryPage(ReqVtBsInvestmentResourcesQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspVtBsInvestmentResourcesDto> queryPageConditions(ReqVtBsInvestmentResourcesQueryDto reqDto) {
        Page<RspVtBsInvestmentResourcesDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspVtBsInvestmentResourcesDto> pageInfo = vtBsInvestmentResourcesMapper.queryByConditions(page, reqDto);
        PageInfo<RspVtBsInvestmentResourcesDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspVtBsInvestmentResourcesDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = vtBsInvestmentResourcesMapper.selectCount(
    // Wrappers.<VtBsInvestmentResources>lambdaQuery().eq(StringUtils.isNotBlank(name),VtBsInvestmentResources::getName,
    // name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
