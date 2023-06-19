package com.cateyes.smart.park.safe.service.impl;

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
 * 应急预案(SpSfEmergencyPlan)impl
 *
 * @author CatEyes
 * @since 2023-06-05 11:50:34
 */
@Service
@AllArgsConstructor
public class EmergencyPlanServiceImpl extends ServiceImpl<EmergencyPlanMapper, EmergencyPlan>
    implements IEmergencyPlanService {

    private EmergencyPlanMapper emergencyPlanMapper;

    @Override
    public int saveEmergencyPlan(ReqEmergencyPlanDto reqDto) {
        List<EmergencyPlan> list = emergencyPlanMapper.selectList(new LambdaQueryWrapper<EmergencyPlan>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), EmergencyPlan::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        EmergencyPlan map = BeanMapperUtil.map(reqDto, EmergencyPlan.class);
        emergencyPlanMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteEmergencyPlan(Integer id) {
        EmergencyPlan emergencyPlan = emergencyPlanMapper.selectById(id);
        Assert.notNull(emergencyPlan, ApiCode.NOT_FOUND);
        return emergencyPlanMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateEmergencyPlan(ReqEmergencyPlanDto reqDto) {
        EmergencyPlan emergencyPlan = emergencyPlanMapper.selectById(reqDto.getId());
        Assert.notNull(emergencyPlan, ApiCode.NOT_FOUND);
        if (reqDto.getName() != null && !StringUtils.equals(emergencyPlan.getName(), reqDto.getName())) {
            List<EmergencyPlan> list = emergencyPlanMapper
                .selectList(Wrappers.<EmergencyPlan>lambdaQuery().eq(EmergencyPlan::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return emergencyPlanMapper.updateById(BeanMapperUtil.map(reqDto, EmergencyPlan.class)) > 0;
    }

    @Override
    public RspEmergencyPlanDto queryDetail(Integer id) {
        return emergencyPlanMapper.queryDetail(id);
    }

    @Override
    public List<RspEmergencyPlanDto> queryList(ReqEmergencyPlanDto reqDto) {
        List<RspEmergencyPlanDto> list = emergencyPlanMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspEmergencyPlanDto> queryPage(ReqEmergencyPlanDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEmergencyPlanDto> queryPageConditions(ReqEmergencyPlanDto reqDto) {
        Page<RspEmergencyPlanDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspEmergencyPlanDto> pageInfo = emergencyPlanMapper.queryByConditions(page, reqDto);
        PageInfo<RspEmergencyPlanDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEmergencyPlanDto> list) {
        list.forEach(a -> {

        });
    }

}
