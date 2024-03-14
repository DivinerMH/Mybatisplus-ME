package com.cateyes.dis.micro.oper.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Strram;
import java.io.Serializable;
import java.util.Optional;

import com.cateyes.base.ApiCode;
import com.cateyes.base.dto.ReqIdDto;
import com.cateyes.base.util.BeanMapperUtil;
import com.cateyes.base.util.PageInfo;
import com.cateyes.base.util.PageUtils;
import com.cateyes.dis.micro.oper.dao.EnterpriseTechAchieveMapper;
import com.cateyes.dis.micro.oper.service.IEnterpriseTechAchieveService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;

import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseTechAchieveDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveQueryDto;
import com.cateyes.dis.micro.oper.bean.po.EnterpriseTechAchieve;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 企业科技成果(DisEnterpriseTechAchieve)impl
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:46
 */
@Service
@AllArgsConstructor
public class EnterpriseTechAchieveServiceImpl implements IEnterpriseTechAchieveService {

    private EnterpriseTechAchieveMapper enterpriseTechAchieveMapper;

    @Override
    public int add(ReqEnterpriseTechAchieveAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        EnterpriseTechAchieve map = BeanMapperUtil.map(reqDto, EnterpriseTechAchieve.class);
        int insert = enterpriseTechAchieveMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        EnterpriseTechAchieve entity = enterpriseTechAchieveMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return enterpriseTechAchieveMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqEnterpriseTechAchieveUpdateDto reqDto) {
        EnterpriseTechAchieve enterpriseTechAchieve = enterpriseTechAchieveMapper.selectById(reqDto.getId());
        Assert.notNull(enterpriseTechAchieve, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(enterpriseTechAchieve.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return enterpriseTechAchieveMapper.updateById(BeanMapperUtil.map(reqDto, EnterpriseTechAchieve.class));
    }

    @Override
    public RspEnterpriseTechAchieveDto detail(ReqIdDto reqDto) {
        RspEnterpriseTechAchieveDto rspDto = enterpriseTechAchieveMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspEnterpriseTechAchieveDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspEnterpriseTechAchieveDto> queryPage(ReqEnterpriseTechAchieveQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEnterpriseTechAchieveDto> queryPageConditions(ReqEnterpriseTechAchieveQueryDto reqDto) {
        Page<RspEnterpriseTechAchieveDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspEnterpriseTechAchieveDto> pageInfo = enterpriseTechAchieveMapper.queryByConditions(page, reqDto);
        PageInfo<RspEnterpriseTechAchieveDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEnterpriseTechAchieveDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = enterpriseTechAchieveMapper.selectCount(
    // Wrappers.<EnterpriseTechAchieve>lambdaQuery().eq(StringUtils.isNotBlank(name),EnterpriseTechAchieve::getName,
    // name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
