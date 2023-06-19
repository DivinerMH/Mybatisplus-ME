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
 * 应急物资(SpSfEmergencySupply)impl
 *
 * @author CatEyes
 * @since 2023-06-05 11:51:27
 */
@Service
@AllArgsConstructor
public class EmergencySupplyServiceImpl extends ServiceImpl<EmergencySupplyMapper, EmergencySupply>
    implements IEmergencySupplyService {

    private EmergencySupplyMapper emergencySupplyMapper;

    @Override
    public int saveEmergencySupply(ReqEmergencySupplyDto reqDto) {
        List<EmergencySupply> list = emergencySupplyMapper.selectList(new LambdaQueryWrapper<EmergencySupply>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), EmergencySupply::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        EmergencySupply map = BeanMapperUtil.map(reqDto, EmergencySupply.class);
        emergencySupplyMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteEmergencySupply(Integer id) {
        EmergencySupply emergencySupply = emergencySupplyMapper.selectById(id);
        Assert.notNull(emergencySupply, ApiCode.NOT_FOUND);
        return emergencySupplyMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateEmergencySupply(ReqEmergencySupplyDto reqDto) {
        EmergencySupply emergencySupply = emergencySupplyMapper.selectById(reqDto.getId());
        Assert.notNull(emergencySupply, ApiCode.NOT_FOUND);
        if (reqDto.getName() != null && !StringUtils.equals(emergencySupply.getName(), reqDto.getName())) {
            List<EmergencySupply> list = emergencySupplyMapper
                .selectList(Wrappers.<EmergencySupply>lambdaQuery().eq(EmergencySupply::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return emergencySupplyMapper.updateById(BeanMapperUtil.map(reqDto, EmergencySupply.class)) > 0;
    }

    @Override
    public RspEmergencySupplyDto queryDetail(Integer id) {
        return emergencySupplyMapper.queryDetail(id);
    }

    @Override
    public List<RspEmergencySupplyDto> queryList(ReqEmergencySupplyDto reqDto) {
        List<RspEmergencySupplyDto> list = emergencySupplyMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspEmergencySupplyDto> queryPage(ReqEmergencySupplyDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEmergencySupplyDto> queryPageConditions(ReqEmergencySupplyDto reqDto) {
        Page<RspEmergencySupplyDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspEmergencySupplyDto> pageInfo = emergencySupplyMapper.queryByConditions(page, reqDto);
        PageInfo<RspEmergencySupplyDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEmergencySupplyDto> list) {
        list.forEach(a -> {

        });
    }

}
