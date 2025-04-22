package com.dfzl.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTaskUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsTaskDto;
import com.dfzl.sms.bean.po.SysSmsTask;
import com.dfzl.sms.mapper.SysSmsTaskMapper;
import com.dfzl.sms.service.ISysSmsTaskService;

import lombok.AllArgsConstructor;

/**
 * 短信发送任务表(SysSmsTask)impl
 *
 * @author makejava
 * @since 2025-01-15 15:46:31
 */
@Service
@AllArgsConstructor
public class SysSmsTaskServiceImpl extends ServiceImpl<SysSmsTaskMapper, SysSmsTask> implements ISysSmsTaskService {

    private SysSmsTaskMapper sysSmsTaskMapper;

    @Override
    public String add(ReqSysSmsTaskAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        SysSmsTask map = BeanMapperUtil.map(reqDto, SysSmsTask.class);
        int insert = sysSmsTaskMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return map.getId();
    }

    @Override
    public int delete(String id) {
        SysSmsTask entity = sysSmsTaskMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return sysSmsTaskMapper.deleteById(id);
    }

    @Override
    public int update(ReqSysSmsTaskUpdateDto reqDto) {
        SysSmsTask sysSmsTask = sysSmsTaskMapper.selectById(reqDto.getId());
        Assert.notNull(sysSmsTask, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(sysSmsTask.getName(), reqDto.getName()))
        // {
        // checkNameUnique(reqDto.getName());
        // }
        return sysSmsTaskMapper.updateById(BeanMapperUtil.map(reqDto, SysSmsTask.class));
    }

    @Override
    public RspSysSmsTaskDto detail(String id) {
        RspSysSmsTaskDto rspDto = sysSmsTaskMapper.detail(id);
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysSmsTaskDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspSysSmsTaskDto> queryList(ReqSysSmsTaskQueryDto reqDto) {
        List<RspSysSmsTaskDto> list = sysSmsTaskMapper.queryByConditions(reqDto);
        // 数据转换
        listConverter(list);
        return list;
    }

    @Override
    public IPage<RspSysSmsTaskDto> queryPage(ReqSysSmsTaskQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private IPage<RspSysSmsTaskDto> queryPageConditions(ReqSysSmsTaskQueryDto reqDto) {
        Page<RspSysSmsTaskDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspSysSmsTaskDto> pageResult = sysSmsTaskMapper.queryByConditions(page, reqDto);
        if (CollectionUtils.isEmpty(pageResult.getRecords())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getRecords());
        return pageResult;
    }

    private void listConverter(List<RspSysSmsTaskDto> list) {
        list.forEach(a -> {

        });
    }

}
