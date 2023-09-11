package com.cateyes.smart.park.report.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.base.ApiCode;
import com.cateyes.smart.park.base.utils.Assert;
import com.cateyes.smart.park.base.utils.BeanMapperUtil;
import com.cateyes.smart.park.base.utils.PageInfo;
import com.cateyes.smart.park.base.utils.PageUtil;
import com.cateyes.smart.park.invest.service.impl.SpBaseServiceImpl;
import com.cateyes.smart.park.report.bean.dto.ReqEnterpriseMuBenefitTargetDto;
import com.cateyes.smart.park.report.bean.dto.RspEnterpriseMuBenefitTargetDto;
import com.cateyes.smart.park.report.bean.po.EnterpriseMuBenefitTarget;
import com.cateyes.smart.park.report.dao.EnterpriseMuBenefitTargetMapper;
import com.cateyes.smart.park.report.service.IEnterpriseMuBenefitTargetService;

import lombok.AllArgsConstructor;

/**
 * 企业亩均效益指标设置(SpEnterpriseMuBenefitTarget)impl
 *
 * @author CatEyes
 * @since 2023-07-21 15:43:30
 */
@Service
@AllArgsConstructor
public class EnterpriseMuBenefitTargetServiceImpl extends SpBaseServiceImpl
    implements IEnterpriseMuBenefitTargetService {

    private EnterpriseMuBenefitTargetMapper enterpriseMuBenefitTargetMapper;

    @Override
    public int add(ReqEnterpriseMuBenefitTargetDto reqDto) {
        List<EnterpriseMuBenefitTarget> list = enterpriseMuBenefitTargetMapper.selectList(
            Wrappers.<EnterpriseMuBenefitTarget>lambdaQuery().eq(StringUtils.isNotBlank(reqDto.getTargetValue()),
                EnterpriseMuBenefitTarget::getTargetValue, reqDto.getTargetValue()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        EnterpriseMuBenefitTarget map = BeanMapperUtil.map(reqDto, EnterpriseMuBenefitTarget.class);
        int insert = enterpriseMuBenefitTargetMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        EnterpriseMuBenefitTarget entity = enterpriseMuBenefitTargetMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return enterpriseMuBenefitTargetMapper.deleteById(id);
    }

    @Override
    public int update(ReqEnterpriseMuBenefitTargetDto reqDto) {
        EnterpriseMuBenefitTarget enterpriseMuBenefitTarget =
            enterpriseMuBenefitTargetMapper.selectById(reqDto.getId());
        Assert.notNull(enterpriseMuBenefitTarget, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getTargetValue())
            && !StringUtils.equals(enterpriseMuBenefitTarget.getTargetValue(), reqDto.getTargetValue())) {
            List<EnterpriseMuBenefitTarget> list =
                enterpriseMuBenefitTargetMapper.selectList(Wrappers.<EnterpriseMuBenefitTarget>lambdaQuery()
                    .eq(EnterpriseMuBenefitTarget::getTargetValue, reqDto.getTargetValue()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return enterpriseMuBenefitTargetMapper.updateById(BeanMapperUtil.map(reqDto, EnterpriseMuBenefitTarget.class));
    }

    @Override
    public RspEnterpriseMuBenefitTargetDto detail(Serializable id) throws RuntimeException {
        EnterpriseMuBenefitTarget entity = enterpriseMuBenefitTargetMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return BeanMapperUtil.map(entity, RspEnterpriseMuBenefitTargetDto.class);
    }

    private LambdaQueryWrapper<EnterpriseMuBenefitTarget> queryWrapper(ReqEnterpriseMuBenefitTargetDto reqDto) {
        return Wrappers.<EnterpriseMuBenefitTarget>lambdaQuery().orderByDesc(EnterpriseMuBenefitTarget::getCreateTime);
    }

    @Override
    public List<RspEnterpriseMuBenefitTargetDto> query(ReqEnterpriseMuBenefitTargetDto reqDto) {
        List<EnterpriseMuBenefitTarget> enterpriseMuBenefitTargetList =
            enterpriseMuBenefitTargetMapper.selectList(queryWrapper(reqDto));
        List<RspEnterpriseMuBenefitTargetDto> list =
            BeanMapperUtil.mapList(enterpriseMuBenefitTargetList, RspEnterpriseMuBenefitTargetDto.class);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspEnterpriseMuBenefitTargetDto> queryPage(ReqEnterpriseMuBenefitTargetDto reqDto) {
        Page<EnterpriseMuBenefitTarget> page = enterpriseMuBenefitTargetMapper
            .selectPage(new Page<>(reqDto.getPageNo(), reqDto.getPageSize()), queryWrapper(reqDto));
        List<RspEnterpriseMuBenefitTargetDto> list =
            BeanMapperUtil.mapList(page.getRecords(), RspEnterpriseMuBenefitTargetDto.class);
        listConverter(list);
        return PageUtil.build(reqDto.getPageNo(), reqDto.getPageSize(), list, (int)page.getTotal());
    }

    private void listConverter(List<RspEnterpriseMuBenefitTargetDto> list) {
        list.forEach(a -> {

        });
    }

}
