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
 * 智慧大屏-系统-技改投资类项目报表(SpBsProjectInnovate)impl
 *
 * @author CatEyes
 * @since 2023-06-29 10:52:13
 */
@Service
@AllArgsConstructor
public class BsProjectInnovateServiceImpl extends SpBaseServiceImpl implements IBsProjectInnovateService {

    private BsProjectInnovateMapper bsProjectInnovateMapper;

    @Override
    public int add(ReqBsProjectInnovateDto reqDto) {
        List<BsProjectInnovate> list = bsProjectInnovateMapper.selectList(new LambdaQueryWrapper<BsProjectInnovate>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), BsProjectInnovate::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        BsProjectInnovate map = BeanMapperUtil.map(reqDto, BsProjectInnovate.class);
        int insert = bsProjectInnovateMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id) {
        BsProjectInnovate entity = bsProjectInnovateMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return bsProjectInnovateMapper.deleteById(id);
    }

    @Override
    public int update(ReqBsProjectInnovateDto reqDto) {
        BsProjectInnovate bsProjectInnovate = bsProjectInnovateMapper.selectById(reqDto.getId());
        Assert.notNull(bsProjectInnovate, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(bsProjectInnovate.getName(), reqDto.getName())) {
            List<BsProjectInnovate> list = bsProjectInnovateMapper
                .selectList(Wrappers.<BsProjectInnovate>lambdaQuery().eq(BsProjectInnovate::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return bsProjectInnovateMapper.updateById(BeanMapperUtil.map(reqDto, BsProjectInnovate.class));
    }

    @Override
    public RspBsProjectInnovateDto detail(Serializable id) throws RuntimeException {
        BsProjectInnovate entity = bsProjectInnovateMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return BeanMapperUtil.map(entity, RspBsProjectInnovateDto.class);
    }

    @Override
    public List<RspBsProjectInnovateDto> query(ReqBsProjectInnovateDto reqDto) {
        return null;
    }

    @Override
    public PageInfo<RspBsProjectInnovateDto> queryPage(ReqBsProjectInnovateDto reqDto) {
        LambdaQueryWrapper<BsProjectInnovate> wrapper = Wrappers.lambdaQuery();
        Page<BsProjectInnovate> page =
            bsProjectInnovateMapper.selectPage(new Page<>(reqDto.getPageNo(), reqDto.getPageSize()), wrapper);
        List<RspBsProjectInnovateDto> list = BeanMapperUtil.mapList(page.getRecords(), RspBsProjectInnovateDto.class);
        listConverter(list);
        return PageUtil.build(reqDto.getPageNo(), reqDto.getPageSize(), list, (int)page.getTotal());
    }

    private void listConverter(List<RspBsProjectInnovateDto> list) {
        list.forEach(a -> {

        });
    }

}
