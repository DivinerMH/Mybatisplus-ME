package com.cateyes.smart.park.invest.service.impl;

    
    






import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.BeanMapperUtil;

/**
 * 产业-产业环节-产业节点信息表(SpIndustry)impl
 *
 * @author CatEyes
 * @since 2023-04-19 14:23:51
 */
@Service
public class IndustryServiceImpl extends SpBaseServiceImpl implements IIndustryService {
	@Resource
    private IndustryMapper industryMapper;
	
	@Override
    public int add(ReqIndustryDto reqIndustryDto) throws RuntimeException {
        List<Industry> list = industryMapper.selectList(
            new LambdaQueryWrapper<Industry>().eq(StringUtils.isNotBlank(reqIndustryDto.getName()), Industry::getName, reqIndustryDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return industryMapper.insert(BeanMapperUtil.map(reqIndustryDto, Industry.class));
    }

    @Override
    public int delete(Serializable id) throws RuntimeException {
        Industry industry = industryMapper.selectById(id);
        Assert.notNull(industry, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return industryMapper.deleteById(id);
    }

    @Override
    public Industry detail(Serializable id) throws RuntimeException {
        return industryMapper.selectById(id);
    }

    @Override
    public int update(ReqIndustryDto reqIndustryDto) throws RuntimeException {
        Industry industry = industryMapper.selectById(reqIndustryDto.getId());
        Assert.notNull(industry, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return industryMapper.updateById(BeanMapperUtil.map(reqIndustryDto, Industry.class));
    }

    @Override
    public PageInfo<Industry> queryPage(ReqIndustryDto reqIndustryDto) {
        LambdaQueryWrapper<Industry> wrapper = new LambdaQueryWrapper<Industry>()
            .eq(StringUtils.isNotBlank(reqIndustryDto.getName()), Industry::getName, reqIndustryDto.getName()).orderByDesc(Industry::getCreateTime);
        return query(industryMapper, wrapper, reqIndustryDto);
    }

    @Override
    public List<Industry> query(ReqIndustryDto reqIndustryDto) {
        return null;
    }
}
