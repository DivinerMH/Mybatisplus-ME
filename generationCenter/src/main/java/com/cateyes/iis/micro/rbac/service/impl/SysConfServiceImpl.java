package com.cateyes.iis.micro.rbac.service.impl;

    
    






import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cateyes.base.ApiCode;
import com.cateyes.base.dto.ReqIdDto;
import com.cateyes.base.util.Assert;
import com.cateyes.base.util.BeanMapperUtil;
import com.cateyes.base.util.PageInfo;
import com.cateyes.base.util.PageUtil;
import com.cateyes.iis.micro.rbac.dao.SysConfMapper;
import com.cateyes.iis.micro.rbac.service.ISysConfService;
import com.cateyes.base.service.SpBaseServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.cateyes.iis.micro.rbac.bean.dto.RspSysConfDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfAddDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfUpdateDto;
import com.cateyes.iis.micro.rbac.bean.dto.ReqSysConfQueryDto;
import com.cateyes.iis.micro.rbac.bean.po.SysConf;

/**
 * 系统配置表(IisSysConf)impl
 *
 * @author CatEyes
 * @since 2023-11-13 13:45:51
 */
@Service
@AllArgsConstructor
public class SysConfServiceImpl extends SpBaseServiceImpl implements ISysConfService {

    private SysConfMapper sysConfMapper;

    @Override
    public int add(ReqSysConfAddDto reqDto){
        // checkNameUnique(reqDto);
        SysConf map = BeanMapperUtil.map(reqDto, SysConf.class);
        int insert = sysConfMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto){
        SysConf entity = sysConfMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return sysConfMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqSysConfUpdateDto reqDto){
        SysConf sysConf = sysConfMapper.selectById(reqDto.getId());
        Assert.notNull(sysConf, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(sysConf.getName(), reqDto.getName())) {
            // checkNameUnique(reqDto);
        // }
        return sysConfMapper.updateById(BeanMapperUtil.map(reqDto, SysConf.class));
    }
    
    @Override
    public RspSysConfDto detail(ReqIdDto reqDto){
        RspSysConfDto rspDto = sysConfMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysConfDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }
    
    @Override
    public PageInfo<RspSysConfDto> queryPage(ReqSysConfQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspSysConfDto> queryPageConditions(ReqSysConfQueryDto reqDto) {
        Page<RspSysConfDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspSysConfDto> pageInfo = sysConfMapper.queryByConditions(page, reqDto);
        PageInfo<RspSysConfDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }
    
    private void listConverter(List<RspSysConfDto> list) {
        list.forEach(a -> {

        });
    }
    
}
