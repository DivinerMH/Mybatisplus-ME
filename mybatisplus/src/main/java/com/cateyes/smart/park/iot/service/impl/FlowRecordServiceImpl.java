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
 * 人流管理-人流记录(SpIotFlowRecord)impl
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:52
 */
@Service
@AllArgsConstructor
public class FlowRecordServiceImpl extends SpBaseServiceImpl implements IFlowRecordService {

    private FlowRecordMapper flowRecordMapper;

    @Override
    public int saveFlowRecord(ReqFlowRecordDto reqDto) {
        List<FlowRecord> list = flowRecordMapper.selectList(new LambdaQueryWrapper<FlowRecord>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), FlowRecord::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        FlowRecord map = BeanMapperUtil.map(reqDto, FlowRecord.class);
        flowRecordMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteFlowRecord(Integer id) {
        FlowRecord flowRecord = flowRecordMapper.selectById(id);
        Assert.notNull(flowRecord, ApiCode.NOT_FOUND);
        return flowRecordMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateFlowRecord(ReqFlowRecordDto reqDto) {
        FlowRecord flowRecord = flowRecordMapper.selectById(reqDto.getId());
        Assert.notNull(flowRecord, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(flowRecord.getName(), reqDto.getName())) {
            List<FlowRecord> list = flowRecordMapper
                .selectList(Wrappers.<FlowRecord>lambdaQuery().eq(FlowRecord::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return flowRecordMapper.updateById(BeanMapperUtil.map(reqDto, FlowRecord.class)) > 0;
    }

    @Override
    public RspFlowRecordDto queryDetail(Integer id) {
        return flowRecordMapper.queryDetail(id);
    }

    @Override
    public List<RspFlowRecordDto> queryList(ReqFlowRecordDto reqDto) {
        List<RspFlowRecordDto> list = flowRecordMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspFlowRecordDto> queryPage(ReqFlowRecordDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspFlowRecordDto> queryPageConditions(ReqFlowRecordDto reqDto) {
        Page<RspFlowRecordDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspFlowRecordDto> pageInfo = flowRecordMapper.queryByConditions(page, reqDto);
        PageInfo<RspFlowRecordDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspFlowRecordDto> list) {
        list.forEach(a -> {

        });
    }

}
