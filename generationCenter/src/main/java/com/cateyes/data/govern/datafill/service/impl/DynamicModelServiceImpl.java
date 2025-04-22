package com.cateyes.data.govern.datafill.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicModelUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicModelDto;
import com.cateyes.data.govern.datafill.bean.po.DynamicModel;

/**
 * 动态表单模型(DgDynamicModel)impl
 *
 * @author CatEyes
 * @since 2023-11-20 13:55:44
 */
@Service
@AllArgsConstructor
public class DynamicModelServiceImpl extends SpBaseServiceImpl implements IDynamicModelService {

    private DynamicModelMapper dynamicModelMapper;

    @Override
    public int add(ReqDynamicModelAddDto reqDto) {
        // checkNameUnique(reqDto);
        DynamicModel map = BeanMapperUtil.map(reqDto, DynamicModel.class);
        int insert = dynamicModelMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        DynamicModel entity = dynamicModelMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return dynamicModelMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqDynamicModelUpdateDto reqDto) {
        DynamicModel dynamicModel = dynamicModelMapper.selectById(reqDto.getId());
        Assert.notNull(dynamicModel, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(dynamicModel.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto);
        // }
        return dynamicModelMapper.updateById(BeanMapperUtil.map(reqDto, DynamicModel.class));
    }

    @Override
    public RspDynamicModelDto detail(ReqIdDto reqDto) {
        RspDynamicModelDto rspDto = dynamicModelMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspDynamicModelDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspDynamicModelDto> queryPage(ReqDynamicModelQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspDynamicModelDto> queryPageConditions(ReqDynamicModelQueryDto reqDto) {
        Page<RspDynamicModelDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspDynamicModelDto> pageInfo = dynamicModelMapper.queryByConditions(page, reqDto);
        PageInfo<RspDynamicModelDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspDynamicModelDto> list) {
        list.forEach(a -> {

        });
    }

}
