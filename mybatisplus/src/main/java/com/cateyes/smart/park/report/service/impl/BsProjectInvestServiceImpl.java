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
 * 智慧大屏-系统-工业投资类项目报表(SpBsProjectInvest)impl
 *
 * @author CatEyes
 * @since 2023-06-29 10:51:59
 */
@Service
@AllArgsConstructor
public class BsProjectInvestServiceImpl extends SpBaseServiceImpl implements IBsProjectInvestService {

    private BsProjectInvestMapper bsProjectInvestMapper;

    @Override
    public int add(ReqBsProjectInvestDto reqDto) {
        List<BsProjectInvest> list = bsProjectInvestMapper.selectList(new LambdaQueryWrapper<BsProjectInvest>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), BsProjectInvest::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        BsProjectInvest map = BeanMapperUtil.map(reqDto, BsProjectInvest.class);
        int insert = bsProjectInvestMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        BsProjectInvest entity = bsProjectInvestMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return bsProjectInvestMapper.deleteById(id);
    }

    @Override
    public int update(ReqBsProjectInvestDto reqDto) {
        BsProjectInvest bsProjectInvest = bsProjectInvestMapper.selectById(reqDto.getId());
        Assert.notNull(bsProjectInvest, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(bsProjectInvest.getName(), reqDto.getName())) {
            List<BsProjectInvest> list = bsProjectInvestMapper
                .selectList(Wrappers.<BsProjectInvest>lambdaQuery().eq(BsProjectInvest::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return bsProjectInvestMapper.updateById(BeanMapperUtil.map(reqDto, BsProjectInvest.class));
    }

    @Override
    public RspBsProjectInvestDto detail(Serializable id) throws RuntimeException {
        BsProjectInvest entity = bsProjectInvestMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return BeanMapperUtil.map(entity, RspBsProjectInvestDto.class);
    }

    @Override
    public List<RspBsProjectInvestDto> query(ReqBsProjectInvestDto reqDto) {
        return null;
    }

    @Override
    public PageInfo<RspBsProjectInvestDto> queryPage(ReqBsProjectInvestDto reqDto) {
        LambdaQueryWrapper<BsProjectInvest> wrapper = Wrappers.lambdaQuery();
        Page<BsProjectInvest> page =
            bsProjectInvestMapper.selectPage(new Page<>(reqDto.getPageNo(), reqDto.getPageSize()), wrapper);
        List<RspBsProjectInvestDto> list = BeanMapperUtil.mapList(page.getRecords(), RspBsProjectInvestDto.class);
        listConverter(list);
        return PageUtil.build(reqDto.getPageNo(), reqDto.getPageSize(), list, (int)page.getTotal());
    }

    private void listConverter(List<RspBsProjectInvestDto> list) {
        list.forEach(a -> {

        });
    }

}
