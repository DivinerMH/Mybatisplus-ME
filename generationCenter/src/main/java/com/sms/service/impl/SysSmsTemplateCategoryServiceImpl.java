package com.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sms.bean.dto.ReqSysSmsTemplateCategoryAddDto;
import com.sms.bean.dto.ReqSysSmsTemplateCategoryQueryDto;
import com.sms.bean.dto.ReqSysSmsTemplateCategoryUpdateDto;
import com.sms.bean.dto.RspSysSmsTemplateCategoryDto;
import com.sms.bean.po.SysSmsTemplateCategory;
import com.sms.mapper.SysSmsTemplateCategoryMapper;
import com.sms.service.ISysSmsTemplateCategoryService;

import lombok.AllArgsConstructor;

/**
 * 短信模板分类(SysSmsTemplateCategory)impl
 *
 * @author makejava
 * @since 2025-01-15 15:47:55
 */
@Service
@AllArgsConstructor
public class SysSmsTemplateCategoryServiceImpl extends ServiceImpl<SysSmsTemplateCategoryMapper, SysSmsTemplateCategory>
    implements ISysSmsTemplateCategoryService {

    private SysSmsTemplateCategoryMapper sysSmsTemplateCategoryMapper;

    @Override
    public String add(ReqSysSmsTemplateCategoryAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        SysSmsTemplateCategory map = BeanMapperUtil.map(reqDto, SysSmsTemplateCategory.class);
        int insert = sysSmsTemplateCategoryMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return map.getId();
    }

    @Override
    public int delete(String id) {
        SysSmsTemplateCategory entity = sysSmsTemplateCategoryMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return sysSmsTemplateCategoryMapper.deleteById(id);
    }

    @Override
    public int update(ReqSysSmsTemplateCategoryUpdateDto reqDto) {
        SysSmsTemplateCategory sysSmsTemplateCategory = sysSmsTemplateCategoryMapper.selectById(reqDto.getId());
        Assert.notNull(sysSmsTemplateCategory, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(sysSmsTemplateCategory.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return sysSmsTemplateCategoryMapper.updateById(BeanMapperUtil.map(reqDto, SysSmsTemplateCategory.class));
    }

    @Override
    public RspSysSmsTemplateCategoryDto detail(String id) {
        RspSysSmsTemplateCategoryDto rspDto = sysSmsTemplateCategoryMapper.detail(id);
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysSmsTemplateCategoryDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspSysSmsTemplateCategoryDto> queryList(ReqSysSmsTemplateCategoryQueryDto reqDto) {
        List<RspSysSmsTemplateCategoryDto> list = sysSmsTemplateCategoryMapper.queryByConditions(reqDto);
        // 数据转换
        listConverter(list);
        return list;
    }

    @Override
    public IPage<RspSysSmsTemplateCategoryDto> queryPage(ReqSysSmsTemplateCategoryQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private IPage<RspSysSmsTemplateCategoryDto> queryPageConditions(ReqSysSmsTemplateCategoryQueryDto reqDto) {
        Page<RspSysSmsTemplateCategoryDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspSysSmsTemplateCategoryDto> pageResult = sysSmsTemplateCategoryMapper.queryByConditions(page, reqDto);
        if (CollectionUtils.isEmpty(pageResult.getRecords())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getRecords());
        return pageResult;
    }

    private void listConverter(List<RspSysSmsTemplateCategoryDto> list) {
        list.forEach(a -> {

        });
    }

}
