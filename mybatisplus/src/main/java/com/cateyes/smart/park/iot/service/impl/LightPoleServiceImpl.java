package com.cateyes.smart.park.iot.service.impl;

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
import com.cateyes.smart.park.base.api.ApiCode;
import com.cateyes.smart.park.core.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.BeanMapperUtil;

/**
 * 灯杆(SpIotLightPole)impl
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:36
 */
@Service
@AllArgsConstructor
public class LightPoleServiceImpl extends SpBaseServiceImpl implements ILightPoleService {

    private LightPoleMapper lightPoleMapper;

    @Override
    public int saveLightPole(ReqLightPoleDto reqDto) {
        List<LightPole> list = lightPoleMapper.selectList(new LambdaQueryWrapper<LightPole>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), LightPole::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        LightPole map = BeanMapperUtil.map(reqDto, LightPole.class);
        int insert = lightPoleMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.IOT_ABNORMAL_INSERT_SMOKE_ALARM);
        return map.getId();
    }

    @Override
    public Boolean deleteLightPole(Integer id) {
        LightPole lightPole = lightPoleMapper.selectById(id);
        Assert.notNull(lightPole, ApiCode.NOT_FOUND);
        return lightPoleMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateLightPole(ReqLightPoleDto reqDto) {
        LightPole lightPole = lightPoleMapper.selectById(reqDto.getId());
        Assert.notNull(lightPole, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(lightPole.getName(), reqDto.getName())) {
            List<LightPole> list =
                lightPoleMapper.selectList(Wrappers.<LightPole>lambdaQuery().eq(LightPole::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return lightPoleMapper.updateById(BeanMapperUtil.map(reqDto, LightPole.class)) > 0;
    }

    @Override
    public RspLightPoleDto queryDetail(Integer id) {
        return lightPoleMapper.queryDetail(id);
    }

    @Override
    public List<RspLightPoleDto> queryList(ReqLightPoleDto reqDto) {
        List<RspLightPoleDto> list = lightPoleMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspLightPoleDto> queryPage(ReqLightPoleDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspLightPoleDto> queryPageConditions(ReqLightPoleDto reqDto) {
        Page<RspLightPoleDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspLightPoleDto> pageInfo = lightPoleMapper.queryByConditions(page, reqDto);
        PageInfo<RspLightPoleDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspLightPoleDto> list) {
        list.forEach(a -> {

        });
    }

}
