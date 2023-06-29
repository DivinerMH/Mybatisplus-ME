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
 * 粉尘监测仪告警(SpIotMonitorDustAlarm)impl
 *
 * @author CatEyes
 * @since 2023-06-25 11:13:07
 */
@Service
@AllArgsConstructor
public class MonitorDustAlarmServiceImpl extends SpBaseServiceImpl implements IMonitorDustAlarmService {

    private MonitorDustAlarmMapper monitorDustAlarmMapper;

    @Override
    public int saveMonitorDustAlarm(ReqMonitorDustAlarmDto reqDto) {
        List<MonitorDustAlarm> list = monitorDustAlarmMapper.selectList(new LambdaQueryWrapper<MonitorDustAlarm>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), MonitorDustAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        MonitorDustAlarm map = BeanMapperUtil.map(reqDto, MonitorDustAlarm.class);
        int insert = monitorDustAlarmMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.IOT_ABNORMAL_INSERT_SMOKE_ALARM);
        return map.getId();
    }

    @Override
    public Boolean deleteMonitorDustAlarm(Integer id) {
        MonitorDustAlarm monitorDustAlarm = monitorDustAlarmMapper.selectById(id);
        Assert.notNull(monitorDustAlarm, ApiCode.NOT_FOUND);
        return monitorDustAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateMonitorDustAlarm(ReqMonitorDustAlarmDto reqDto) {
        MonitorDustAlarm monitorDustAlarm = monitorDustAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(monitorDustAlarm, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(monitorDustAlarm.getName(), reqDto.getName())) {
            List<MonitorDustAlarm> list = monitorDustAlarmMapper
                .selectList(Wrappers.<MonitorDustAlarm>lambdaQuery().eq(MonitorDustAlarm::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return monitorDustAlarmMapper.updateById(BeanMapperUtil.map(reqDto, MonitorDustAlarm.class)) > 0;
    }

    @Override
    public RspMonitorDustAlarmDto queryDetail(Integer id) {
        return monitorDustAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspMonitorDustAlarmDto> queryList(ReqMonitorDustAlarmDto reqDto) {
        List<RspMonitorDustAlarmDto> list = monitorDustAlarmMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspMonitorDustAlarmDto> queryPage(ReqMonitorDustAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspMonitorDustAlarmDto> queryPageConditions(ReqMonitorDustAlarmDto reqDto) {
        Page<RspMonitorDustAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspMonitorDustAlarmDto> pageInfo = monitorDustAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspMonitorDustAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspMonitorDustAlarmDto> list) {
        list.forEach(a -> {

        });
    }

}
