package com.dfzl.material.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.jeecg.common.util.BeanMapperUtil;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.ApiCode;
import com.base.util.Assert;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyAddDto;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyQueryDto;
import com.dfzl.material.bean.dto.ReqAfMaterialApplyUpdateDto;
import com.dfzl.material.bean.dto.RspAfMaterialApplyDto;
import com.dfzl.material.bean.po.AfMaterialApply;
import com.dfzl.material.mapper.AfMaterialApplyMapper;
import com.dfzl.material.service.IAfMaterialApplyService;

import lombok.AllArgsConstructor;

/**
 * 物料申请(AfMaterialApply)impl
 *
 * @author makejava
 * @since 2025-01-14 18:52:12
 */
@Service
@AllArgsConstructor
public class AfMaterialApplyServiceImpl extends ServiceImpl<AfMaterialApplyMapper, AfMaterialApply> implements IAfMaterialApplyService{

    private AfMaterialApplyMapper afMaterialApplyMapper;

    @Override
    public String add(ReqAfMaterialApplyAddDto reqDto){
        // checkNameUnique(reqDto.getName());
        AfMaterialApply map = BeanMapperUtil.map(reqDto, AfMaterialApply.class);
        int insert = afMaterialApplyMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return map.getId();
    }

    @Override
    public int delete(String id){
        AfMaterialApply entity = afMaterialApplyMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return afMaterialApplyMapper.deleteById(id);
    }

    @Override
    public int update(ReqAfMaterialApplyUpdateDto reqDto){
        AfMaterialApply afMaterialApply = afMaterialApplyMapper.selectById(reqDto.getId());
        Assert.notNull(afMaterialApply, ApiCode.NOT_FOUND);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(afMaterialApply.getName(), reqDto.getName())) {
            // checkNameUnique(reqDto.getName());
        // }
        return afMaterialApplyMapper.updateById(BeanMapperUtil.map(reqDto, AfMaterialApply.class));
    }
    
    @Override
    public RspAfMaterialApplyDto detail(String id){
        RspAfMaterialApplyDto rspDto = afMaterialApplyMapper.detail(id);
        Assert.notNull(rspDto, ApiCode.NOT_FOUND);
        List<RspAfMaterialApplyDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }
                                        
    @Override
    public List<RspAfMaterialApplyDto> queryList(ReqAfMaterialApplyQueryDto reqDto) {
        List<RspAfMaterialApplyDto> list = afMaterialApplyMapper.queryByConditions(reqDto);
        // 数据转换
        listConverter(list);
        return list;                                   
    }
    
    @Override
    public IPage<RspAfMaterialApplyDto> queryPage(ReqAfMaterialApplyQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private IPage<RspAfMaterialApplyDto> queryPageConditions(ReqAfMaterialApplyQueryDto reqDto) {
        Page<RspAfMaterialApplyDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspAfMaterialApplyDto> pageResult = afMaterialApplyMapper.queryByConditions(page, reqDto);
        if (CollectionUtils.isEmpty(pageResult.getRecords())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getRecords());
        return pageResult;
    }
    
    private void listConverter(List<RspAfMaterialApplyDto> list) {
        list.forEach(a -> {

        });
    }
    
}
