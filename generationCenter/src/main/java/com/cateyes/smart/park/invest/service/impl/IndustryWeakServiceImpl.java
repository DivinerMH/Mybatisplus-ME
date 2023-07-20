package com.cateyes.smart.park.invest.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * 产业链节点评价指标设置(SpInIndustryWeak)impl
 *
 * @author CatEyes
 * @since 2023-07-17 11:00:37
 */
@Service
@AllArgsConstructor
public class IndustryWeakServiceImpl extends SpBaseServiceImpl implements IIndustryWeakService {

    private IndustryWeakMapper industryWeakMapper;

    @Override
    public int add(ReqIndustryWeakDto reqDto) {
        List<IndustryWeak> list = industryWeakMapper.selectList(new LambdaQueryWrapper<IndustryWeak>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), IndustryWeak::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        IndustryWeak map = BeanMapperUtil.map(reqDto, IndustryWeak.class);
        int insert = industryWeakMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        IndustryWeak entity = industryWeakMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return industryWeakMapper.deleteById(id);
    }

    @Override
    public int update(ReqIndustryWeakDto reqDto) {
        IndustryWeak industryWeak = industryWeakMapper.selectById(reqDto.getId());
        Assert.notNull(industryWeak, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(industryWeak.getName(), reqDto.getName())) {
            List<IndustryWeak> list = industryWeakMapper
                .selectList(Wrappers.<IndustryWeak>lambdaQuery().eq(IndustryWeak::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return industryWeakMapper.updateById(BeanMapperUtil.map(reqDto, IndustryWeak.class));
    }

    @Override
    public RspIndustryWeakDto detail(Serializable id) throws RuntimeException {
        IndustryWeak entity = industryWeakMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return BeanMapperUtil.map(entity, RspIndustryWeakDto.class);
    }

    @Override
    public List<RspIndustryWeakDto> query(ReqIndustryWeakDto reqDto) {
        return null;
    }

    @Override
    public PageInfo<RspIndustryWeakDto> queryPage(ReqIndustryWeakDto reqDto) {
        LambdaQueryWrapper<IndustryWeak> wrapper = Wrappers.lambdaQuery();
        Page<IndustryWeak> page =
            industryWeakMapper.selectPage(new Page<>(reqDto.getPageNo(), reqDto.getPageSize()), wrapper);
        List<RspIndustryWeakDto> list = BeanMapperUtil.mapList(page.getRecords(), RspIndustryWeakDto.class);
        listConverter(list);
        return PageUtil.build(reqDto.getPageNo(), reqDto.getPageSize(), list, (int)page.getTotal());
    }

    private void listConverter(List<RspIndustryWeakDto> list) {
        list.forEach(a -> {

        });
    }

}
