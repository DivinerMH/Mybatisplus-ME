package com.dfzl.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateAddDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateQueryDto;
import com.dfzl.sms.bean.dto.ReqSysSmsTemplateUpdateDto;
import com.dfzl.sms.bean.dto.RspSysSmsTemplateDto;
import com.dfzl.sms.bean.po.SysSmsTemplate;
import com.dfzl.sms.mapper.SysSmsTemplateMapper;
import com.dfzl.sms.service.ISysSmsTemplateService;

import lombok.AllArgsConstructor;

/**
 * 短信模版表(SysSmsTemplate)impl
 *
 * @author makejava
 * @since 2025-01-15 15:47:04
 */
@Service
@AllArgsConstructor
public class SysSmsTemplateServiceImpl extends ServiceImpl<SysSmsTemplateMapper, SysSmsTemplate>
    implements ISysSmsTemplateService {

    private SysSmsTemplateMapper sysSmsTemplateMapper;

    @Override
    public String add(ReqSysSmsTemplateAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        SysSmsTemplate map = BeanMapperUtil.map(reqDto, SysSmsTemplate.class);
        int insert = sysSmsTemplateMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return map.getId();
    }

    @Override
    public int delete(String id) {
        SysSmsTemplate entity = sysSmsTemplateMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return sysSmsTemplateMapper.deleteById(id);
    }

    @Override
    public int update(ReqSysSmsTemplateUpdateDto reqDto) {
        SysSmsTemplate sysSmsTemplate = sysSmsTemplateMapper.selectById(reqDto.getId());
        Assert.notNull(sysSmsTemplate, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(sysSmsTemplate.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return sysSmsTemplateMapper.updateById(BeanMapperUtil.map(reqDto, SysSmsTemplate.class));
    }

    @Override
    public RspSysSmsTemplateDto detail(String id) {
        RspSysSmsTemplateDto rspDto = sysSmsTemplateMapper.detail(id);
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysSmsTemplateDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspSysSmsTemplateDto> queryList(ReqSysSmsTemplateQueryDto reqDto) {
        List<RspSysSmsTemplateDto> list = sysSmsTemplateMapper.queryByConditions(reqDto);
        // 数据转换
        listConverter(list);
        return list;
    }

    @Override
    public IPage<RspSysSmsTemplateDto> queryPage(ReqSysSmsTemplateQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private IPage<RspSysSmsTemplateDto> queryPageConditions(ReqSysSmsTemplateQueryDto reqDto) {
        Page<RspSysSmsTemplateDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspSysSmsTemplateDto> pageResult = sysSmsTemplateMapper.queryByConditions(page, reqDto);
        if (CollectionUtils.isEmpty(pageResult.getRecords())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getRecords());
        return pageResult;
    }

    private void listConverter(List<RspSysSmsTemplateDto> list) {
        list.forEach(a -> {

        });
    }

}
