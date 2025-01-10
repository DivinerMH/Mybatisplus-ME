package com.cateyes.dis.micro.oper.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Strram;

import com.base.ApiCode;
import com.base.dto.ReqIdDto;
import com.base.util.BeanMapperUtil;
import com.base.util.PageInfo;
import com.base.util.PageUtils;
import com.cateyes.dis.micro.oper.dao.EnterpriseMuBenefitMapper;
import com.cateyes.dis.micro.oper.service.IEnterpriseMuBenefitService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseMuBenefitDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseMuBenefitQueryDto;
import com.cateyes.dis.micro.oper.bean.po.EnterpriseMuBenefit;

/**
 * 企业亩均效益(DisEnterpriseMuBenefit)impl
 *
 * @author CatEyes
 * @since 2024-02-01 18:31:33
 */
@Service
@AllArgsConstructor
public class EnterpriseMuBenefitServiceImpl implements IEnterpriseMuBenefitService {

    private EnterpriseMuBenefitMapper enterpriseMuBenefitMapper;

    @Override
    public int add(ReqEnterpriseMuBenefitAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        EnterpriseMuBenefit map = BeanMapperUtil.map(reqDto, EnterpriseMuBenefit.class);
        int insert = enterpriseMuBenefitMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        EnterpriseMuBenefit entity = enterpriseMuBenefitMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return enterpriseMuBenefitMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqEnterpriseMuBenefitUpdateDto reqDto) {
        EnterpriseMuBenefit enterpriseMuBenefit = enterpriseMuBenefitMapper.selectById(reqDto.getId());
        Assert.notNull(enterpriseMuBenefit, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(enterpriseMuBenefit.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return enterpriseMuBenefitMapper.updateById(BeanMapperUtil.map(reqDto, EnterpriseMuBenefit.class));
    }

    @Override
    public RspEnterpriseMuBenefitDto detail(ReqIdDto reqDto) {
        RspEnterpriseMuBenefitDto rspDto = enterpriseMuBenefitMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspEnterpriseMuBenefitDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspEnterpriseMuBenefitDto> queryPage(ReqEnterpriseMuBenefitQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEnterpriseMuBenefitDto> queryPageConditions(ReqEnterpriseMuBenefitQueryDto reqDto) {
        Page<RspEnterpriseMuBenefitDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspEnterpriseMuBenefitDto> pageInfo = enterpriseMuBenefitMapper.queryByConditions(page, reqDto);
        PageInfo<RspEnterpriseMuBenefitDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEnterpriseMuBenefitDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = enterpriseMuBenefitMapper.selectCount(
    // Wrappers.<EnterpriseMuBenefit>lambdaQuery().eq(StringUtils.isNotBlank(name),EnterpriseMuBenefit::getName, name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
