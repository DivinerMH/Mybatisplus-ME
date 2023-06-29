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
 * 智慧大屏-系统-重点投资类项目报表(SpBsProjectKey)impl
 *
 * @author CatEyes
 * @since 2023-06-29 10:51:46
 */
@Service
@AllArgsConstructor
public class BsProjectKeyServiceImpl extends SpBaseServiceImpl implements IBsProjectKeyService{

    private BsProjectKeyMapper bsProjectKeyMapper;
	
	@Override
    public int add(ReqBsProjectKeyDto reqDto){
        List<BsProjectKey> list = bsProjectKeyMapper.selectList(
            new LambdaQueryWrapper<BsProjectKey>().eq(StringUtils.isNotBlank(reqDto.getName()), BsProjectKey::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        BsProjectKey map = BeanMapperUtil.map(reqDto, BsProjectKey.class);
        int insert = bsProjectKeyMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.FAIL);
        return map.getId();
    }

    @Override
    public int delete(Serializable id){
        BsProjectKey entity = bsProjectKeyMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return bsProjectKeyMapper.deleteById(id);
    }

    @Override
    public int update(ReqBsProjectKeyDto reqDto){
        BsProjectKey bsProjectKey = bsProjectKeyMapper.selectById(reqDto.getId());
        Assert.notNull(bsProjectKey, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(bsProjectKey.getName(), reqDto.getName())) {
            List<BsProjectKey> list =
                bsProjectKeyMapper.selectList(Wrappers.<BsProjectKey>lambdaQuery().eq(BsProjectKey::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return bsProjectKeyMapper.updateById(BeanMapperUtil.map(reqDto, BsProjectKey.class));
    }
    
    @Override
    public RspBsProjectKeyDto detail(Serializable id) throws RuntimeException {
        BsProjectKey entity = bsProjectKeyMapper.selectById(id);
        Assert.notNull(entity, ApiCode.NOT_FOUND);
        return BeanMapperUtil.map(entity, RspBsProjectKeyDto.class);
    }

    @Override
    public List<RspBsProjectKeyDto> query(ReqBsProjectKeyDto reqDto) {
        return null;
    }
    
    @Override
    public PageInfo<RspBsProjectKeyDto> queryPage(ReqBsProjectKeyDto reqDto) {
        LambdaQueryWrapper<BsProjectKey> wrapper = Wrappers.<BsProjectKey>lambdaQuery();
        Page<BsProjectKey> page = bsProjectKeyMapper.selectPage(new Page<>(reqDto.getPageNo(), reqDto.getPageSize()), wrapper);
        List<RspBsProjectKeyDto> list = BeanMapperUtil.mapList(page.getRecords(), RspBsProjectKeyDto.class);
        listConverter(list);
        return PageUtil.build(reqDto.getPageNo(), reqDto.getPageSize(), list,
            (int)page.getTotal());
    }
    
    private void listConverter(List<RspBsProjectKeyDto> list) {
        list.forEach(a -> {

        });
    }

}
