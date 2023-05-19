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
 * 企业库表(SpCompany)impl
 *
 * @author CatEyes
 * @since 2023-05-08 10:40:20
 */
@Service
public class CompanyServiceImpl extends SpBaseServiceImpl implements ICompanyService {
	@Resource
    private CompanyMapper companyMapper;
	
	@Override
    public int add(ReqCompanyDto reqCompanyDto) throws RuntimeException {
        List<Company> list = companyMapper.selectList(
            new LambdaQueryWrapper<Company>().eq(StringUtils.isNotBlank(reqCompanyDto.getName()), Company::getName, reqCompanyDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return companyMapper.insert(BeanMapperUtil.map(reqCompanyDto, Company.class));
    }

    @Override
    public int delete(Serializable id) throws RuntimeException {
        Company company = companyMapper.selectById(id);
        Assert.notNull(company, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return companyMapper.deleteById(id);
    }

    @Override
    public Company detail(Serializable id) throws RuntimeException {
        return companyMapper.selectById(id);
    }

    @Override
    public int update(ReqCompanyDto reqCompanyDto) throws RuntimeException {
        Company company = companyMapper.selectById(reqCompanyDto.getId());
        Assert.notNull(company, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return companyMapper.updateById(BeanMapperUtil.map(reqCompanyDto, Company.class));
    }

    @Override
    public PageInfo<Company> queryPage(ReqCompanyDto reqCompanyDto) {
        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<Company>()
            .eq(StringUtils.isNotBlank(reqCompanyDto.getName()), Company::getName, reqCompanyDto.getName()).orderByDesc(Company::getCreateTime);
        return query(companyMapper, wrapper, reqCompanyDto);
    }

    @Override
    public List<Company> query(ReqCompanyDto reqCompanyDto) {
        return null;
    }
}
