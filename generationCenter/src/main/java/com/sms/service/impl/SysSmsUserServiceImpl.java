package com.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sms.bean.dto.ReqSysSmsUserAddDto;
import com.sms.bean.dto.ReqSysSmsUserQueryDto;
import com.sms.bean.dto.ReqSysSmsUserUpdateDto;
import com.sms.bean.dto.RspSysSmsUserDto;
import com.sms.bean.po.SysSmsUser;
import com.sms.mapper.SysSmsUserMapper;
import com.sms.service.ISysSmsUserService;

import lombok.AllArgsConstructor;

/**
 * 短信发送用户表(SysSmsUser)impl
 *
 * @author makejava
 * @since 2025-01-15 15:48:28
 */
@Service
@AllArgsConstructor
public class SysSmsUserServiceImpl extends ServiceImpl<SysSmsUserMapper, SysSmsUser> implements ISysSmsUserService {

    private SysSmsUserMapper sysSmsUserMapper;

    @Override
    public String add(ReqSysSmsUserAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        SysSmsUser map = BeanMapperUtil.map(reqDto, SysSmsUser.class);
        int insert = sysSmsUserMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return map.getId();
    }

    @Override
    public int delete(String id) {
        SysSmsUser entity = sysSmsUserMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return sysSmsUserMapper.deleteById(id);
    }

    @Override
    public int update(ReqSysSmsUserUpdateDto reqDto) {
        SysSmsUser sysSmsUser = sysSmsUserMapper.selectById(reqDto.getId());
        Assert.notNull(sysSmsUser, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(sysSmsUser.getName(), reqDto.getName()))
        // {
        // checkNameUnique(reqDto.getName());
        // }
        return sysSmsUserMapper.updateById(BeanMapperUtil.map(reqDto, SysSmsUser.class));
    }

    @Override
    public RspSysSmsUserDto detail(String id) {
        RspSysSmsUserDto rspDto = sysSmsUserMapper.detail(id);
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysSmsUserDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspSysSmsUserDto> queryList(ReqSysSmsUserQueryDto reqDto) {
        List<RspSysSmsUserDto> list = sysSmsUserMapper.queryByConditions(reqDto);
        // 数据转换
        listConverter(list);
        return list;
    }

    @Override
    public IPage<RspSysSmsUserDto> queryPage(ReqSysSmsUserQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private IPage<RspSysSmsUserDto> queryPageConditions(ReqSysSmsUserQueryDto reqDto) {
        Page<RspSysSmsUserDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspSysSmsUserDto> pageResult = sysSmsUserMapper.queryByConditions(page, reqDto);
        if (CollectionUtils.isEmpty(pageResult.getRecords())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getRecords());
        return pageResult;
    }

    private void listConverter(List<RspSysSmsUserDto> list) {
        list.forEach(a -> {

        });
    }

}
