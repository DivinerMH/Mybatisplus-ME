package com.cateyes.smart.park.resource.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.api.ApiCode;
import com.base.bean.vo.PageInfo;
import com.base.service.SpBaseServiceImpl;
import com.base.util.BeanMapperUtil;
import com.base.util.PageUtil;
import com.cateyes.smart.park.core.util.Assert;
import com.cateyes.smart.park.resource.bean.dto.ReqEnterpriseMuBenefitAnalysisDto;
import com.cateyes.smart.park.resource.bean.dto.RspEnterpriseMuBenefitAnalysisDto;
import com.cateyes.smart.park.resource.bean.po.EnterpriseMuBenefitAnalysis;
import com.cateyes.smart.park.resource.dao.EnterpriseMuBenefitAnalysisMapper;
import com.cateyes.smart.park.resource.service.IEnterpriseMuBenefitAnalysisService;

import lombok.AllArgsConstructor;

/**
 * 企业亩均效益分析-企业得分(SpEnterpriseMuBenefitAnalysis)impl
 *
 * @author CatEyes
 * @since 2023-07-25 15:55:46
 */
@Service
@AllArgsConstructor
public class EnterpriseMuBenefitAnalysisServiceImpl extends SpBaseServiceImpl
    implements IEnterpriseMuBenefitAnalysisService {

    private EnterpriseMuBenefitAnalysisMapper enterpriseMuBenefitAnalysisMapper;

    @Override
    public int add(ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        checkNameUnique(reqDto);
        EnterpriseMuBenefitAnalysis map = BeanMapperUtil.map(reqDto, EnterpriseMuBenefitAnalysis.class);
        int insert = enterpriseMuBenefitAnalysisMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        EnterpriseMuBenefitAnalysis entity = enterpriseMuBenefitAnalysisMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return enterpriseMuBenefitAnalysisMapper.deleteById(id);
    }

    @Override
    public int update(ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        EnterpriseMuBenefitAnalysis enterpriseMuBenefitAnalysis =
            enterpriseMuBenefitAnalysisMapper.selectById(reqDto.getId());
        Assert.notNull(enterpriseMuBenefitAnalysis, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(enterpriseMuBenefitAnalysis.getName(), reqDto.getName())) {
            checkNameUnique(reqDto);
        }
        return enterpriseMuBenefitAnalysisMapper
            .updateById(BeanMapperUtil.map(reqDto, EnterpriseMuBenefitAnalysis.class));
    }

    @Override
    public RspEnterpriseMuBenefitAnalysisDto detail(Serializable id) throws RuntimeException {
        List<RspEnterpriseMuBenefitAnalysisDto> list = enterpriseMuBenefitAnalysisMapper
            .queryByConditions(ReqEnterpriseMuBenefitAnalysisDto.builder().id(id).build());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspEnterpriseMuBenefitAnalysisDto> query(ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        List<RspEnterpriseMuBenefitAnalysisDto> list = enterpriseMuBenefitAnalysisMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspEnterpriseMuBenefitAnalysisDto> queryPage(ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEnterpriseMuBenefitAnalysisDto> queryPageConditions(ReqEnterpriseMuBenefitAnalysisDto reqDto) {
        Page<RspEnterpriseMuBenefitAnalysisDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspEnterpriseMuBenefitAnalysisDto> pageInfo =
            enterpriseMuBenefitAnalysisMapper.queryByConditions(page, reqDto);
        PageInfo<RspEnterpriseMuBenefitAnalysisDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEnterpriseMuBenefitAnalysisDto> list) {
        list.forEach(a -> {

        });
    }

}
