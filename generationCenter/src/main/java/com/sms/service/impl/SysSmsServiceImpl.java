package com.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sms.bean.dto.ReqSysSmsAddDto;
import com.sms.bean.dto.ReqSysSmsQueryDto;
import com.sms.bean.dto.ReqSysSmsUpdateDto;
import com.sms.bean.dto.RspSysSmsDto;
import com.sms.bean.po.SysSms;
import com.sms.mapper.SysSmsMapper;
import com.sms.service.ISysSmsService;

import lombok.AllArgsConstructor;

/**
 * 短信表(SysSms)impl
 *
 * @author menghuan
 * @since 2025-01-22 09:49:09
 */
@Service
@AllArgsConstructor
public class SysSmsServiceImpl extends ServiceImpl<SysSmsMapper, SysSms> implements ISysSmsService {

    private SysSmsMapper sysSmsMapper;

    @Override
    public String add(ReqSysSmsAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        SysSms map = BeanMapperUtil.map(reqDto, SysSms.class);
        int insert = sysSmsMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return map.getId();
    }

    @Override
    public int delete(String id) {
        SysSms entity = sysSmsMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return sysSmsMapper.deleteById(id);
    }

    @Override
    public int update(ReqSysSmsUpdateDto reqDto) {
        SysSms sysSms = sysSmsMapper.selectById(reqDto.getId());
        Assert.notNull(sysSms, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(sysSms.getName(), reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return sysSmsMapper.updateById(BeanMapperUtil.map(reqDto, SysSms.class));
    }

    @Override
    public RspSysSmsDto detail(String id) {
        RspSysSmsDto rspDto = sysSmsMapper.detail(id);
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysSmsDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspSysSmsDto> queryList(ReqSysSmsQueryDto reqDto) {
        List<RspSysSmsDto> list = sysSmsMapper.queryByConditions(reqDto);
        // 数据转换
        listConverter(list);
        return list;
    }

    @Override
    public IPage<RspSysSmsDto> queryPage(ReqSysSmsQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private IPage<RspSysSmsDto> queryPageConditions(ReqSysSmsQueryDto reqDto) {
        Page<RspSysSmsDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspSysSmsDto> pageResult = sysSmsMapper.queryByConditions(page, reqDto);
        if (CollectionUtils.isEmpty(pageResult.getRecords())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getRecords());
        return pageResult;
    }

    private void listConverter(List<RspSysSmsDto> list) {
        list.forEach(a -> {

        });
    }

}
