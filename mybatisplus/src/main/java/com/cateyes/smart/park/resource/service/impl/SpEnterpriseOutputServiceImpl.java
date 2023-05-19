package com.cateyes.smart.park.resource.service.impl;

    
    






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
 * 企业产值(SpEnterpriseOutput)impl
 *
 * @author CatEyes
 * @since 2023-05-19 10:23:20
 */
@Service
@AllArgsConstructor
public class SpEnterpriseOutputServiceImpl extends ServiceImpl<SpEnterpriseOutputMapper, SpEnterpriseOutput> implements ISpEnterpriseOutputService{

	@Resource
    private SpEnterpriseOutputMapper spEnterpriseOutputMapper;
	
	@Override
    public int saveSpEnterpriseOutput(ReqSpEnterpriseOutputDto reqDto){
        List<SpEnterpriseOutput> list = spEnterpriseOutputMapper.selectList(
            new LambdaQueryWrapper<SpEnterpriseOutput>().eq(StringUtils.isNotBlank(reqDto.getName()), SpEnterpriseOutput::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return spEnterpriseOutputMapper.insert(BeanMapperUtil.map(reqDto, SpEnterpriseOutput.class));
    }

    @Override
    public Boolean deleteSpEnterpriseOutput(Integer id){
        SpEnterpriseOutput spEnterpriseOutput = spEnterpriseOutputMapper.selectById(id);
        Assert.notNull(spEnterpriseOutput, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return spEnterpriseOutputMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateSpEnterpriseOutput(ReqSpEnterpriseOutputDto reqDto){
        SpEnterpriseOutput spEnterpriseOutput = spEnterpriseOutputMapper.selectById(reqDto.getId());
        Assert.notNull(spEnterpriseOutput, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        if (reqDto.getName() != null && !StringUtils.equals(spEnterpriseOutput.getName(), reqDto.getName())) {
            List<SpEnterpriseOutput> list =
                spEnterpriseOutputMapper.selectList(Wrappers.<SpEnterpriseOutput>lambdaQuery().eq(SpEnterpriseOutput::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return spEnterpriseOutputMapper.updateById(BeanMapperUtil.map(reqDto, SpEnterpriseOutput.class)) > 0;
    }
    
    @Override
    public RspSpEnterpriseOutputDto queryDetail(Integer id){
        return spEnterpriseOutputMapper.queryDetail(id);
    }

    @Override
    public List<RspSpEnterpriseOutputDto> queryList(ReqSpEnterpriseOutputDto reqDto) {
        return spEnterpriseOutputMapper.queryList(reqDto);
    }
    
    @Override
    public PageInfo<RspSpEnterpriseOutputDto> queryPage(ReqSpEnterpriseOutputDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspSpEnterpriseOutputDto> queryPageConditions(ReqSpEnterpriseOutputDto reqDto) {
        Page<RspSpEnterpriseOutputDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspSpEnterpriseOutputDto> pageInfo = spEnterpriseOutputMapper.queryByConditions(page, reqDto);
        PageInfo<RspSpEnterpriseOutputDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        return pageResult;
    }

}
