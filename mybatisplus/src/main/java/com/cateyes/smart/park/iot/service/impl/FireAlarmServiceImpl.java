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
 * 消防告警(SpIotFireAlarm)impl
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:13
 */
@Service
@AllArgsConstructor
public class FireAlarmServiceImpl extends SpBaseServiceImpl implements IFireAlarmService {

    private FireAlarmMapper fireAlarmMapper;

    @Override
    public int saveFireAlarm(ReqFireAlarmDto reqDto) {
        List<FireAlarm> list = fireAlarmMapper.selectList(new LambdaQueryWrapper<FireAlarm>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), FireAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        FireAlarm map = BeanMapperUtil.map(reqDto, FireAlarm.class);
        int insert = fireAlarmMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.IOT_ABNORMAL_INSERT_SMOKE_ALARM);
        return map.getId();
    }

    @Override
    public Boolean deleteFireAlarm(Integer id) {
        FireAlarm fireAlarm = fireAlarmMapper.selectById(id);
        Assert.notNull(fireAlarm, ApiCode.NOT_FOUND);
        return fireAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateFireAlarm(ReqFireAlarmDto reqDto) {
        FireAlarm fireAlarm = fireAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(fireAlarm, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(fireAlarm.getName(), reqDto.getName())) {
            List<FireAlarm> list =
                fireAlarmMapper.selectList(Wrappers.<FireAlarm>lambdaQuery().eq(FireAlarm::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return fireAlarmMapper.updateById(BeanMapperUtil.map(reqDto, FireAlarm.class)) > 0;
    }

    @Override
    public RspFireAlarmDto queryDetail(Integer id) {
        return fireAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspFireAlarmDto> queryList(ReqFireAlarmDto reqDto) {
        List<RspFireAlarmDto> list = fireAlarmMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspFireAlarmDto> queryPage(ReqFireAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspFireAlarmDto> queryPageConditions(ReqFireAlarmDto reqDto) {
        Page<RspFireAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspFireAlarmDto> pageInfo = fireAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspFireAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspFireAlarmDto> list) {
        list.forEach(a -> {

        });
    }

}
