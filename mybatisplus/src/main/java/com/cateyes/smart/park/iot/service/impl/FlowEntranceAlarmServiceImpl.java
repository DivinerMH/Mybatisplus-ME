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
 * 视屏告警事件(SpIotFlowEntranceAlarm)impl
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:40
 */
@Service
@AllArgsConstructor
public class FlowEntranceAlarmServiceImpl extends SpBaseServiceImpl implements IFlowEntranceAlarmService {

    private FlowEntranceAlarmMapper flowEntranceAlarmMapper;

    @Override
    public int saveFlowEntranceAlarm(ReqFlowEntranceAlarmDto reqDto) {
        List<FlowEntranceAlarm> list = flowEntranceAlarmMapper.selectList(new LambdaQueryWrapper<FlowEntranceAlarm>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), FlowEntranceAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        FlowEntranceAlarm map = BeanMapperUtil.map(reqDto, FlowEntranceAlarm.class);
        flowEntranceAlarmMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteFlowEntranceAlarm(Integer id) {
        FlowEntranceAlarm flowEntranceAlarm = flowEntranceAlarmMapper.selectById(id);
        Assert.notNull(flowEntranceAlarm, ApiCode.NOT_FOUND);
        return flowEntranceAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateFlowEntranceAlarm(ReqFlowEntranceAlarmDto reqDto) {
        FlowEntranceAlarm flowEntranceAlarm = flowEntranceAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(flowEntranceAlarm, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(flowEntranceAlarm.getName(), reqDto.getName())) {
            List<FlowEntranceAlarm> list = flowEntranceAlarmMapper
                .selectList(Wrappers.<FlowEntranceAlarm>lambdaQuery().eq(FlowEntranceAlarm::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return flowEntranceAlarmMapper.updateById(BeanMapperUtil.map(reqDto, FlowEntranceAlarm.class)) > 0;
    }

    @Override
    public RspFlowEntranceAlarmDto queryDetail(Integer id) {
        return flowEntranceAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspFlowEntranceAlarmDto> queryList(ReqFlowEntranceAlarmDto reqDto) {
        List<RspFlowEntranceAlarmDto> list = flowEntranceAlarmMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspFlowEntranceAlarmDto> queryPage(ReqFlowEntranceAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspFlowEntranceAlarmDto> queryPageConditions(ReqFlowEntranceAlarmDto reqDto) {
        Page<RspFlowEntranceAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspFlowEntranceAlarmDto> pageInfo = flowEntranceAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspFlowEntranceAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspFlowEntranceAlarmDto> list) {
        list.forEach(a -> {

        });
    }

}
