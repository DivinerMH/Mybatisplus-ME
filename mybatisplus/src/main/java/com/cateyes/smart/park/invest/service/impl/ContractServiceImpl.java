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
 * 合同基本信息表(SpContract)impl
 *
 * @author CatEyes
 * @since 2023-05-08 10:07:41
 */
@Service
public class ContractServiceImpl extends SpBaseServiceImpl implements IContractService {
    @Resource
    private ContractMapper contractMapper;

    @Override
    public int add(ReqContractDto reqContractDto) throws RuntimeException {
        List<Contract> list = contractMapper.selectList(new LambdaQueryWrapper<Contract>()
            .eq(StringUtils.isNotBlank(reqContractDto.getName()), Contract::getName, reqContractDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return contractMapper.insert(BeanMapperUtil.map(reqContractDto, Contract.class));
    }

    @Override
    public int delete(Serializable id) throws RuntimeException {
        Contract contract = contractMapper.selectById(id);
        Assert.notNull(contract, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return contractMapper.deleteById(id);
    }

    @Override
    public Contract detail(Serializable id) throws RuntimeException {
        return contractMapper.selectById(id);
    }

    @Override
    public int update(ReqContractDto reqContractDto) throws RuntimeException {
        Contract contract = contractMapper.selectById(reqContractDto.getId());
        Assert.notNull(contract, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return contractMapper.updateById(BeanMapperUtil.map(reqContractDto, Contract.class));
    }

    @Override
    public PageInfo<Contract> queryPage(ReqContractDto reqContractDto) {
        LambdaQueryWrapper<Contract> wrapper = new LambdaQueryWrapper<Contract>()
            .eq(StringUtils.isNotBlank(reqContractDto.getName()), Contract::getName, reqContractDto.getName())
            .orderByDesc(Contract::getCreateTime);
        return query(contractMapper, wrapper, reqContractDto);
    }

    @Override
    public List<Contract> query(ReqContractDto reqContractDto) {
        return null;
    }
}
