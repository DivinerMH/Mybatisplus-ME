package com.cateyes.smart.park.report.service.impl;

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
 * 智慧大屏-系统-工程项目总览(SpBsProjectOverview)impl
 *
 * @author CatEyes
 * @since 2023-06-29 10:41:08
 */
@Service
@AllArgsConstructor
public class BsProjectOverviewServiceImpl extends SpBaseServiceImpl implements IBsProjectOverviewService {

    private BsProjectOverviewMapper bsProjectOverviewMapper;

    @Override
    public int add(ReqBsProjectOverviewDto reqDto) {
        List<BsProjectOverview> list = bsProjectOverviewMapper.selectList(new LambdaQueryWrapper<BsProjectOverview>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), BsProjectOverview::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        BsProjectOverview map = BeanMapperUtil.map(reqDto, BsProjectOverview.class);
        int insert = bsProjectOverviewMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        BsProjectOverview entity = bsProjectOverviewMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return bsProjectOverviewMapper.deleteById(id);
    }

    @Override
    public int update(ReqBsProjectOverviewDto reqDto) {
        BsProjectOverview bsProjectOverview = bsProjectOverviewMapper.selectById(reqDto.getId());
        Assert.notNull(bsProjectOverview, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(bsProjectOverview.getName(), reqDto.getName())) {
            List<BsProjectOverview> list = bsProjectOverviewMapper
                .selectList(Wrappers.<BsProjectOverview>lambdaQuery().eq(BsProjectOverview::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return bsProjectOverviewMapper.updateById(BeanMapperUtil.map(reqDto, BsProjectOverview.class));
    }

    @Override
    public RspBsProjectOverviewDto detail(Serializable id) throws RuntimeException {
        BsProjectOverview entity = bsProjectOverviewMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return BeanMapperUtil.map(entity, RspBsProjectOverviewDto.class);
    }

    @Override
    public List<RspBsProjectOverviewDto> query(ReqBsProjectOverviewDto reqDto) {
        return null;
    }

    @Override
    public PageInfo<RspBsProjectOverviewDto> queryPage(ReqBsProjectOverviewDto reqDto) {
        LambdaQueryWrapper<BsProjectOverview> wrapper = Wrappers.lambdaQuery();
        Page<BsProjectOverview> page =
            bsProjectOverviewMapper.selectPage(new Page<>(reqDto.getPageNo(), reqDto.getPageSize()), wrapper);
        List<RspBsProjectOverviewDto> list = BeanMapperUtil.mapList(page.getRecords(), RspBsProjectOverviewDto.class);
        listConverter(list);
        return PageUtil.build(reqDto.getPageNo(), reqDto.getPageSize(), list, (int)page.getTotal());
    }

    private void listConverter(List<RspBsProjectOverviewDto> list) {
        list.forEach(a -> {

        });
    }

}
