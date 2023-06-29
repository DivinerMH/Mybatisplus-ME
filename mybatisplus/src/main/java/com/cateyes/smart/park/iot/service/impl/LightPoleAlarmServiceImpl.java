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
 * 灯杆告警(SpIotLightPoleAlarm)impl
 *
 * @author CatEyes
 * @since 2023-06-25 14:28:49
 */
@Service
@AllArgsConstructor
public class LightPoleAlarmServiceImpl extends SpBaseServiceImpl implements ILightPoleAlarmService {

    private LightPoleAlarmMapper lightPoleAlarmMapper;

    @Override
    public int saveLightPoleAlarm(ReqLightPoleAlarmDto reqDto) {
        List<LightPoleAlarm> list = lightPoleAlarmMapper.selectList(new LambdaQueryWrapper<LightPoleAlarm>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), LightPoleAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        LightPoleAlarm map = BeanMapperUtil.map(reqDto, LightPoleAlarm.class);
        int insert = lightPoleAlarmMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.IOT_ABNORMAL_INSERT_SMOKE_ALARM);
        return map.getId();
    }

    @Override
    public Boolean deleteLightPoleAlarm(Integer id) {
        LightPoleAlarm lightPoleAlarm = lightPoleAlarmMapper.selectById(id);
        Assert.notNull(lightPoleAlarm, ApiCode.NOT_FOUND);
        return lightPoleAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateLightPoleAlarm(ReqLightPoleAlarmDto reqDto) {
        LightPoleAlarm lightPoleAlarm = lightPoleAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(lightPoleAlarm, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(lightPoleAlarm.getName(), reqDto.getName())) {
            List<LightPoleAlarm> list = lightPoleAlarmMapper
                .selectList(Wrappers.<LightPoleAlarm>lambdaQuery().eq(LightPoleAlarm::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return lightPoleAlarmMapper.updateById(BeanMapperUtil.map(reqDto, LightPoleAlarm.class)) > 0;
    }

    @Override
    public RspLightPoleAlarmDto queryDetail(Integer id) {
        return lightPoleAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspLightPoleAlarmDto> queryList(ReqLightPoleAlarmDto reqDto) {
        List<RspLightPoleAlarmDto> list = lightPoleAlarmMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspLightPoleAlarmDto> queryPage(ReqLightPoleAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspLightPoleAlarmDto> queryPageConditions(ReqLightPoleAlarmDto reqDto) {
        Page<RspLightPoleAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspLightPoleAlarmDto> pageInfo = lightPoleAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspLightPoleAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspLightPoleAlarmDto> list) {
        list.forEach(a -> {

        });
    }

}
