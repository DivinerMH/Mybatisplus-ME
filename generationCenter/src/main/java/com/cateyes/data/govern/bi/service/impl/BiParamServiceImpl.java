package com.cateyes.data.govern.bi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.bi.bean.dto.ReqBiParamAddDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiParamQueryDto;
import com.cateyes.data.govern.bi.bean.dto.ReqBiParamUpdateDto;
import com.cateyes.data.govern.bi.bean.dto.RspBiParamDto;
import com.cateyes.data.govern.bi.bean.po.BiParam;

/**
 * 參數(DgBiParam)impl
 *
 * @author CatEyes
 * @since 2024-01-23 12:01:19
 */
@Service
@AllArgsConstructor
public class BiParamServiceImpl implements IBiParamService {

    private BiParamMapper biParamMapper;

    @Override
    public int add(ReqBiParamAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        BiParam map = BeanMapperUtil.map(reqDto, BiParam.class);
        int insert = biParamMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        BiParam entity = biParamMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return biParamMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqBiParamUpdateDto reqDto) {
        BiParam biParam = biParamMapper.selectById(reqDto.getId());
        Assert.notNull(biParam, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(biParam.getName(), reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return biParamMapper.updateById(BeanMapperUtil.map(reqDto, BiParam.class));
    }

    @Override
    public RspBiParamDto detail(ReqIdDto reqDto) {
        RspBiParamDto rspDto = biParamMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspBiParamDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspBiParamDto> queryPage(ReqBiParamQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspBiParamDto> queryPageConditions(ReqBiParamQueryDto reqDto) {
        Page<RspBiParamDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspBiParamDto> pageInfo = biParamMapper.queryByConditions(page, reqDto);
        PageInfo<RspBiParamDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspBiParamDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = biParamMapper.selectCount(
    // Wrappers.<BiParam>lambdaQuery().eq(StringUtils.isNotBlank(name),BiParam::getName, name);
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
