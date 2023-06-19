package com.cateyes.smart.park.iot.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cateyes.smart.park.iot.bean.dto.ReqSmokeDto;
import com.cateyes.smart.park.iot.bean.dto.RspSmokeDto;
import com.cateyes.smart.park.iot.bean.po.Smoke;
import com.cateyes.smart.park.iot.dao.SmokeMapper;
import com.cateyes.smart.park.iot.service.ISmokeService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import com.cateyes.smart.park.base.api.ApiCode;
import com.cateyes.smart.park.core.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.BeanMapperUtil;

/**
 * 烟感设备(SpIotSmoke)impl
 *
 * @author CatEyes
 * @since 2023-06-19 16:57:50
 */
@Service
@AllArgsConstructor
public class SmokeServiceImpl extends ServiceImpl<SmokeMapper, Smoke> implements ISmokeService {

    private SmokeMapper smokeMapper;

    @Override
    public int saveSmoke(ReqSmokeDto reqDto) {
        List<Smoke> list = smokeMapper.selectList(new LambdaQueryWrapper<Smoke>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), Smoke::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        Smoke map = BeanMapperUtil.map(reqDto, Smoke.class);
        smokeMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteSmoke(Integer id) {
        Smoke smoke = smokeMapper.selectById(id);
        Assert.notNull(smoke, ApiCode.NOT_FOUND);
        return smokeMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateSmoke(ReqSmokeDto reqDto) {
        Smoke smoke = smokeMapper.selectById(reqDto.getId());
        Assert.notNull(smoke, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(smoke.getName(), reqDto.getName())) {
            List<Smoke> list =
                smokeMapper.selectList(Wrappers.<Smoke>lambdaQuery().eq(Smoke::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return smokeMapper.updateById(BeanMapperUtil.map(reqDto, Smoke.class)) > 0;
    }

    @Override
    public RspSmokeDto queryDetail(Integer id) {
        return smokeMapper.queryDetail(id);
    }

    @Override
    public List<RspSmokeDto> queryList(ReqSmokeDto reqDto) {
        List<RspSmokeDto> list = smokeMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspSmokeDto> queryPage(ReqSmokeDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspSmokeDto> queryPageConditions(ReqSmokeDto reqDto) {
        Page<RspSmokeDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspSmokeDto> pageInfo = smokeMapper.queryByConditions(page, reqDto);
        PageInfo<RspSmokeDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspSmokeDto> list) {
        list.forEach(a -> {

        });
    }

}
