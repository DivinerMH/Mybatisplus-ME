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
 * 应急疏散表(SpSfEmergencyEvacuate)impl
 *
 * @author CatEyes
 * @since 2023-06-07 17:27:56
 */
@Service
@AllArgsConstructor
public class EmergencyEvacuateServiceImpl extends ServiceImpl<EmergencyEvacuateMapper, EmergencyEvacuate>
    implements IEmergencyEvacuateService {

    private EmergencyEvacuateMapper emergencyEvacuateMapper;

    @Override
    public int saveEmergencyEvacuate(ReqEmergencyEvacuateDto reqDto) {
        List<EmergencyEvacuate> list = emergencyEvacuateMapper.selectList(new LambdaQueryWrapper<EmergencyEvacuate>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), EmergencyEvacuate::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        EmergencyEvacuate map = BeanMapperUtil.map(reqDto, EmergencyEvacuate.class);
        emergencyEvacuateMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deleteEmergencyEvacuate(Integer id) {
        EmergencyEvacuate emergencyEvacuate = emergencyEvacuateMapper.selectById(id);
        Assert.notNull(emergencyEvacuate, ApiCode.NOT_FOUND);
        return emergencyEvacuateMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateEmergencyEvacuate(ReqEmergencyEvacuateDto reqDto) {
        EmergencyEvacuate emergencyEvacuate = emergencyEvacuateMapper.selectById(reqDto.getId());
        Assert.notNull(emergencyEvacuate, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(emergencyEvacuate.getName(), reqDto.getName())) {
            List<EmergencyEvacuate> list = emergencyEvacuateMapper
                .selectList(Wrappers.<EmergencyEvacuate>lambdaQuery().eq(EmergencyEvacuate::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return emergencyEvacuateMapper.updateById(BeanMapperUtil.map(reqDto, EmergencyEvacuate.class)) > 0;
    }

    @Override
    public RspEmergencyEvacuateDto queryDetail(Integer id) {
        return emergencyEvacuateMapper.queryDetail(id);
    }

    @Override
    public List<RspEmergencyEvacuateDto> queryList(ReqEmergencyEvacuateDto reqDto) {
        List<RspEmergencyEvacuateDto> list = emergencyEvacuateMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspEmergencyEvacuateDto> queryPage(ReqEmergencyEvacuateDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEmergencyEvacuateDto> queryPageConditions(ReqEmergencyEvacuateDto reqDto) {
        Page<RspEmergencyEvacuateDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspEmergencyEvacuateDto> pageInfo = emergencyEvacuateMapper.queryByConditions(page, reqDto);
        PageInfo<RspEmergencyEvacuateDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEmergencyEvacuateDto> list) {
        list.forEach(a -> {

        });
    }

}
