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
 * 烟感告警事件(SpIotSmokeAlarm)impl
 *
 * @author CatEyes
 * @since 2023-06-19 16:40:10
 */
@Service
@AllArgsConstructor
public class SmokeAlarmServiceImpl extends ServiceImpl<SmokeAlarmMapper, SmokeAlarm> implements ISmokeAlarmService {

    private SmokeAlarmMapper smokeAlarmMapper;

    @Override
    public int saveSmokeAlarm(ReqSmokeAlarmDto reqDto) {
        List<SmokeAlarm> list = smokeAlarmMapper.selectList(new LambdaQueryWrapper<SmokeAlarm>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), SmokeAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        SmokeAlarm map = BeanMapperUtil.map(reqDto, SmokeAlarm.class);
        smokeAlarmMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteSmokeAlarm(Integer id) {
        SmokeAlarm smokeAlarm = smokeAlarmMapper.selectById(id);
        Assert.notNull(smokeAlarm, ApiCode.NOT_FOUND);
        return smokeAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateSmokeAlarm(ReqSmokeAlarmDto reqDto) {
        SmokeAlarm smokeAlarm = smokeAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(smokeAlarm, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(smokeAlarm.getName(), reqDto.getName())) {
            List<SmokeAlarm> list = smokeAlarmMapper
                .selectList(Wrappers.<SmokeAlarm>lambdaQuery().eq(SmokeAlarm::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return smokeAlarmMapper.updateById(BeanMapperUtil.map(reqDto, SmokeAlarm.class)) > 0;
    }

    @Override
    public RspSmokeAlarmDto queryDetail(Integer id) {
        return smokeAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspSmokeAlarmDto> queryList(ReqSmokeAlarmDto reqDto) {
        List<RspSmokeAlarmDto> list = smokeAlarmMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspSmokeAlarmDto> queryPage(ReqSmokeAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspSmokeAlarmDto> queryPageConditions(ReqSmokeAlarmDto reqDto) {
        Page<RspSmokeAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspSmokeAlarmDto> pageInfo = smokeAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspSmokeAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspSmokeAlarmDto> list) {
        list.forEach(a -> {

        });
    }

}
