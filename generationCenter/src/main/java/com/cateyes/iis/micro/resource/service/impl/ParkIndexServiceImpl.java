package com.cateyes.iis.micro.resource.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.util.BeanMapperUtil;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.ApiCode;
import com.base.service.SpBaseServiceImpl;
import com.base.util.Assert;
import com.base.util.PageInfo;
import com.base.util.PageUtil;
import com.cateyes.iis.micro.resource.bean.dto.ReqParkIndexDto;
import com.cateyes.iis.micro.resource.bean.dto.RspParkIndexDto;
import com.cateyes.iis.micro.resource.bean.po.ParkIndex;
import com.cateyes.iis.micro.resource.dao.ParkIndexMapper;
import com.cateyes.iis.micro.resource.service.IParkIndexService;

import lombok.AllArgsConstructor;

/**
 * (IisParkIndex)impl
 *
 * @author CatEyes
 * @since 2023-10-17 11:11:53
 */
@Service
@AllArgsConstructor
public class ParkIndexServiceImpl extends SpBaseServiceImpl implements IParkIndexService {

    private ParkIndexMapper parkIndexMapper;

    @Override
    public int add(ReqParkIndexDto reqDto) {
        checkNameUnique(reqDto);
        ParkIndex map = BeanMapperUtil.map(reqDto, ParkIndex.class);
        int insert = parkIndexMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        ParkIndex entity = parkIndexMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return parkIndexMapper.deleteById(id);
    }

    @Override
    public int update(ReqParkIndexDto reqDto) {
        ParkIndex parkIndex = parkIndexMapper.selectById(reqDto.getId());
        Assert.notNull(parkIndex, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getParkName())
            && !StringUtils.equals(parkIndex.getParkName(), reqDto.getParkName())) {
            checkNameUnique(reqDto);
        }
        return parkIndexMapper.updateById(BeanMapperUtil.map(reqDto, ParkIndex.class));
    }

    @Override
    public RspParkIndexDto detail(Serializable id) throws RuntimeException {
        List<RspParkIndexDto> list = parkIndexMapper.queryByConditions(ReqParkIndexDto.builder().build());
        Assert.isTrue(CollectionUtils.isNotEmpty(list), ApiCode.NOT_FOUND);
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspParkIndexDto> query(ReqParkIndexDto reqDto) {
        List<RspParkIndexDto> list = parkIndexMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspParkIndexDto> queryPage(ReqParkIndexDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspParkIndexDto> queryPageConditions(ReqParkIndexDto reqDto) {
        Page<RspParkIndexDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspParkIndexDto> pageInfo = parkIndexMapper.queryByConditions(page, reqDto);
        PageInfo<RspParkIndexDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspParkIndexDto> list) {
        list.forEach(a -> {

        });
    }

    /**
     * 校验：唯一企业档位
     *
     * @param reqDto 入参Dto
     */
    private void checkNameUnique(ReqParkIndexDto reqDto) {
        checkCollection(parkIndexMapper, Wrappers.<ParkIndex>lambdaQuery()
            .eq(StringUtils.isNotBlank(reqDto.getParkName()), ParkIndex::getParkName, reqDto.getParkName()),
            ApiCode.REPORT_DUPLICATE_NAME);
    }

}
