package com.cateyes.smart.park.invest.service.impl;

    
    






import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import com.cateyes.smart.park.base.api.ApiCode;
import com.cateyes.smart.park.core.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.BeanMapperUtil;

/**
 * 合同模板表(SpContractTemplate)impl
 *
 * @author CatEyes
 * @since 2023-05-08 10:04:27
 */
@Service
public class ContractTemplateServiceImpl extends SpBaseServiceImpl implements IContractTemplateService {
	@Resource
    private ContractTemplateMapper contractTemplateMapper;
	
	@Override
    public int add(ReqContractTemplateDto reqContractTemplateDto) throws RuntimeException {
        List<ContractTemplate> list = contractTemplateMapper.selectList(
            new LambdaQueryWrapper<ContractTemplate>().eq(StringUtils.isNotBlank(reqContractTemplateDto.getName()), ContractTemplate::getName, reqContractTemplateDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return contractTemplateMapper.insert(BeanMapperUtil.map(reqContractTemplateDto, ContractTemplate.class));
    }

    @Override
    public int delete(Serializable id) throws RuntimeException {
        ContractTemplate contractTemplate = contractTemplateMapper.selectById(id);
        Assert.notNull(contractTemplate, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return contractTemplateMapper.deleteById(id);
    }

    @Override
    public ContractTemplate detail(Serializable id) throws RuntimeException {
        return contractTemplateMapper.selectById(id);
    }

    @Override
    public int update(ReqContractTemplateDto reqContractTemplateDto) throws RuntimeException {
        ContractTemplate contractTemplate = contractTemplateMapper.selectById(reqContractTemplateDto.getId());
        Assert.notNull(contractTemplate, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return contractTemplateMapper.updateById(BeanMapperUtil.map(reqContractTemplateDto, ContractTemplate.class));
    }

    @Override
    public PageInfo<ContractTemplate> queryPage(ReqContractTemplateDto reqContractTemplateDto) {
        LambdaQueryWrapper<ContractTemplate> wrapper = new LambdaQueryWrapper<ContractTemplate>()
            .eq(StringUtils.isNotBlank(reqContractTemplateDto.getName()), ContractTemplate::getName, reqContractTemplateDto.getName()).orderByDesc(ContractTemplate::getCreateTime);
        return query(contractTemplateMapper, wrapper, reqContractTemplateDto);
    }

    @Override
    public List<ContractTemplate> query(ReqContractTemplateDto reqContractTemplateDto) {
        return null;
    }
}
