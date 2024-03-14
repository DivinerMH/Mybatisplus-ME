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

import com.cateyes.data.govern.bi.bean.dto.RspBiReportDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiReportQueryDto;
import com.cateyes.data.govern.bi.bean.po.BiReport;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 报表(DgBiReport)impl
 *
 * @author CatEyes
 * @since 2024-01-16 15:41:42
 */
@Service
@AllArgsConstructor
public class BiReportServiceImpl implements IBiReportService{

    private BiReportMapper biReportMapper;

    @Override
    public int add(ReqBiReportAddDto reqDto){
        // checkNameUnique(reqDto.getName());
        BiReport map = BeanMapperUtil.map(reqDto, BiReport.class);
        int insert = biReportMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto){
        BiReport entity = biReportMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return biReportMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqBiReportUpdateDto reqDto){
        BiReport biReport = biReportMapper.selectById(reqDto.getId());
        Assert.notNull(biReport, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(biReport.getName(), reqDto.getName())) {
            // checkNameUnique(reqDto.getName());
        // }
        return biReportMapper.updateById(BeanMapperUtil.map(reqDto, BiReport.class));
    }
    
    @Override
    public RspBiReportDto detail(ReqIdDto reqDto){
        RspBiReportDto rspDto = biReportMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspBiReportDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }
    
    @Override
    public PageInfo<RspBiReportDto> queryPage(ReqBiReportQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspBiReportDto> queryPageConditions(ReqBiReportQueryDto reqDto) {
        Page<RspBiReportDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspBiReportDto> pageInfo = biReportMapper.queryByConditions(page, reqDto);
        PageInfo<RspBiReportDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }
    
    private void listConverter(List<RspBiReportDto> list) {
        list.forEach(a -> {

        });
    }
    
    // private void checkNameUnique(String name) {
    //     Integer count = biReportMapper.selectCount(
    //         Wrappers.<BiReport>lambdaQuery().eq(StringUtils.isNotBlank(name),BiReport::getName, name);
    //     Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }
    
}
