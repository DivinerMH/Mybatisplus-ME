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
 * 人流管理-门禁设备(SpIotFlowEntrance)impl
 *
 * @author CatEyes
 * @since 2023-06-20 16:39:27
 */
@Service
@AllArgsConstructor
public class FlowEntranceServiceImpl extends SpBaseServiceImpl implements IFlowEntranceService {

    private FlowEntranceMapper flowEntranceMapper;

    @Override
    public int saveFlowEntrance(ReqFlowEntranceDto reqDto) {
        List<FlowEntrance> list = flowEntranceMapper.selectList(new LambdaQueryWrapper<FlowEntrance>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), FlowEntrance::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        FlowEntrance map = BeanMapperUtil.map(reqDto, FlowEntrance.class);
        flowEntranceMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteFlowEntrance(Integer id) {
        FlowEntrance flowEntrance = flowEntranceMapper.selectById(id);
        Assert.notNull(flowEntrance, ApiCode.NOT_FOUND);
        return flowEntranceMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateFlowEntrance(ReqFlowEntranceDto reqDto) {
        FlowEntrance flowEntrance = flowEntranceMapper.selectById(reqDto.getId());
        Assert.notNull(flowEntrance, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(flowEntrance.getName(), reqDto.getName())) {
            List<FlowEntrance> list = flowEntranceMapper
                .selectList(Wrappers.<FlowEntrance>lambdaQuery().eq(FlowEntrance::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return flowEntranceMapper.updateById(BeanMapperUtil.map(reqDto, FlowEntrance.class)) > 0;
    }

    @Override
    public RspFlowEntranceDto queryDetail(Integer id) {
        return flowEntranceMapper.queryDetail(id);
    }

    @Override
    public List<RspFlowEntranceDto> queryList(ReqFlowEntranceDto reqDto) {
        List<RspFlowEntranceDto> list = flowEntranceMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspFlowEntranceDto> queryPage(ReqFlowEntranceDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspFlowEntranceDto> queryPageConditions(ReqFlowEntranceDto reqDto) {
        Page<RspFlowEntranceDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspFlowEntranceDto> pageInfo = flowEntranceMapper.queryByConditions(page, reqDto);
        PageInfo<RspFlowEntranceDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspFlowEntranceDto> list) {
        list.forEach(a -> {

        });
    }

}
