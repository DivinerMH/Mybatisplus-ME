package com.cateyes.smart.park.report.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryQueryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemIndustryUpdateDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemIndustryDto;
import com.cateyes.smart.park.report.bean.po.VtBsInvestmentItemIndustry;

/**
 * 智慧大屏-手工-招商项目-产业项目分布(SpVtBsInvestmentItemIndustry)impl
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:39
 */
@Service
@AllArgsConstructor
public class VtBsInvestmentItemIndustryServiceImpl implements IVtBsInvestmentItemIndustryService {

    private VtBsInvestmentItemIndustryMapper vtBsInvestmentItemIndustryMapper;

    @Override
    public int add(ReqVtBsInvestmentItemIndustryAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        VtBsInvestmentItemIndustry map = BeanMapperUtil.map(reqDto, VtBsInvestmentItemIndustry.class);
        int insert = vtBsInvestmentItemIndustryMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        VtBsInvestmentItemIndustry entity = vtBsInvestmentItemIndustryMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return vtBsInvestmentItemIndustryMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqVtBsInvestmentItemIndustryUpdateDto reqDto) {
        VtBsInvestmentItemIndustry vtBsInvestmentItemIndustry =
            vtBsInvestmentItemIndustryMapper.selectById(reqDto.getId());
        Assert.notNull(vtBsInvestmentItemIndustry, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(vtBsInvestmentItemIndustry.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return vtBsInvestmentItemIndustryMapper
            .updateById(BeanMapperUtil.map(reqDto, VtBsInvestmentItemIndustry.class));
    }

    @Override
    public RspVtBsInvestmentItemIndustryDto detail(ReqIdDto reqDto) {
        RspVtBsInvestmentItemIndustryDto rspDto = vtBsInvestmentItemIndustryMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspVtBsInvestmentItemIndustryDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspVtBsInvestmentItemIndustryDto> queryPage(ReqVtBsInvestmentItemIndustryQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspVtBsInvestmentItemIndustryDto>
        queryPageConditions(ReqVtBsInvestmentItemIndustryQueryDto reqDto) {
        Page<RspVtBsInvestmentItemIndustryDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspVtBsInvestmentItemIndustryDto> pageInfo =
            vtBsInvestmentItemIndustryMapper.queryByConditions(page, reqDto);
        PageInfo<RspVtBsInvestmentItemIndustryDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspVtBsInvestmentItemIndustryDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = vtBsInvestmentItemIndustryMapper.selectCount(
    // Wrappers.<VtBsInvestmentItemIndustry>lambdaQuery().eq(StringUtils.isNotBlank(name),VtBsInvestmentItemIndustry::getName,
    // name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
