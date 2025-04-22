package com.cateyes.data.govern.datafill.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolDto;
import com.cateyes.data.govern.datafill.bean.po.DynamicFieldPool;

/**
 * 动态表单字段池(DgDynamicFieldPool)impl
 *
 * @author CatEyes
 * @since 2023-11-20 10:50:50
 */
@Service
@AllArgsConstructor
public class DynamicFieldPoolServiceImpl extends SpBaseServiceImpl implements IDynamicFieldPoolService {

    private DynamicFieldPoolMapper dynamicFieldPoolMapper;

    @Override
    public int add(ReqDynamicFieldPoolAddDto reqDto) {
        // checkNameUnique(reqDto);
        DynamicFieldPool map = BeanMapperUtil.map(reqDto, DynamicFieldPool.class);
        int insert = dynamicFieldPoolMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        DynamicFieldPool entity = dynamicFieldPoolMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return dynamicFieldPoolMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqDynamicFieldPoolUpdateDto reqDto) {
        DynamicFieldPool dynamicFieldPool = dynamicFieldPoolMapper.selectById(reqDto.getId());
        Assert.notNull(dynamicFieldPool, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(dynamicFieldPool.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto);
        // }
        return dynamicFieldPoolMapper.updateById(BeanMapperUtil.map(reqDto, DynamicFieldPool.class));
    }

    @Override
    public RspDynamicFieldPoolDto detail(ReqIdDto reqDto) {
        RspDynamicFieldPoolDto rspDto = dynamicFieldPoolMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspDynamicFieldPoolDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspDynamicFieldPoolDto> queryPage(ReqDynamicFieldPoolQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspDynamicFieldPoolDto> queryPageConditions(ReqDynamicFieldPoolQueryDto reqDto) {
        Page<RspDynamicFieldPoolDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspDynamicFieldPoolDto> pageInfo = dynamicFieldPoolMapper.queryByConditions(page, reqDto);
        PageInfo<RspDynamicFieldPoolDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspDynamicFieldPoolDto> list) {
        list.forEach(a -> {

        });
    }

}
