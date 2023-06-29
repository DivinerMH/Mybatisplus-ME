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
 * 粉尘监测仪(SpIotMonitorDust)impl
 *
 * @author CatEyes
 * @since 2023-06-21 18:12:30
 */
@Service
@AllArgsConstructor
public class MonitorDustServiceImpl extends SpBaseServiceImpl implements IMonitorDustService {

    private MonitorDustMapper monitorDustMapper;

    @Override
    public int saveMonitorDust(ReqMonitorDustDto reqDto) {
        List<MonitorDust> list = monitorDustMapper.selectList(new LambdaQueryWrapper<MonitorDust>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), MonitorDust::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        MonitorDust map = BeanMapperUtil.map(reqDto, MonitorDust.class);
        int insert = monitorDustMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.IOT_ABNORMAL_INSERT_SMOKE_ALARM);
        return map.getId();
    }

    @Override
    public Boolean deleteMonitorDust(Integer id) {
        MonitorDust monitorDust = monitorDustMapper.selectById(id);
        Assert.notNull(monitorDust, ApiCode.NOT_FOUND);
        return monitorDustMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateMonitorDust(ReqMonitorDustDto reqDto) {
        MonitorDust monitorDust = monitorDustMapper.selectById(reqDto.getId());
        Assert.notNull(monitorDust, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(monitorDust.getName(), reqDto.getName())) {
            List<MonitorDust> list = monitorDustMapper
                .selectList(Wrappers.<MonitorDust>lambdaQuery().eq(MonitorDust::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return monitorDustMapper.updateById(BeanMapperUtil.map(reqDto, MonitorDust.class)) > 0;
    }

    @Override
    public RspMonitorDustDto queryDetail(Integer id) {
        return monitorDustMapper.queryDetail(id);
    }

    @Override
    public List<RspMonitorDustDto> queryList(ReqMonitorDustDto reqDto) {
        List<RspMonitorDustDto> list = monitorDustMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspMonitorDustDto> queryPage(ReqMonitorDustDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspMonitorDustDto> queryPageConditions(ReqMonitorDustDto reqDto) {
        Page<RspMonitorDustDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspMonitorDustDto> pageInfo = monitorDustMapper.queryByConditions(page, reqDto);
        PageInfo<RspMonitorDustDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspMonitorDustDto> list) {
        list.forEach(a -> {

        });
    }

}
