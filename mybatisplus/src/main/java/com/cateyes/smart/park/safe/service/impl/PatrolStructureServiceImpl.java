package com.cateyes.smart.park.safe.service.impl;

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
 * 构筑物(SpSfPatrolStructure)impl
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:31
 */
@Service
@AllArgsConstructor
public class PatrolStructureServiceImpl extends ServiceImpl<PatrolStructureMapper, PatrolStructure>
    implements IPatrolStructureService {

    private PatrolStructureMapper patrolStructureMapper;

    @Override
    public int savePatrolStructure(ReqPatrolStructureDto reqDto) {
        List<PatrolStructure> list = patrolStructureMapper.selectList(new LambdaQueryWrapper<PatrolStructure>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), PatrolStructure::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        PatrolStructure map = BeanMapperUtil.map(reqDto, PatrolStructure.class);
        patrolStructureMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deletePatrolStructure(Integer id) {
        PatrolStructure patrolStructure = patrolStructureMapper.selectById(id);
        Assert.notNull(patrolStructure, ApiCode.NOT_FOUND);
        return patrolStructureMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updatePatrolStructure(ReqPatrolStructureDto reqDto) {
        PatrolStructure patrolStructure = patrolStructureMapper.selectById(reqDto.getId());
        Assert.notNull(patrolStructure, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(patrolStructure.getName(), reqDto.getName())) {
            List<PatrolStructure> list = patrolStructureMapper
                .selectList(Wrappers.<PatrolStructure>lambdaQuery().eq(PatrolStructure::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return patrolStructureMapper.updateById(BeanMapperUtil.map(reqDto, PatrolStructure.class)) > 0;
    }

    @Override
    public RspPatrolStructureDto queryDetail(Integer id) {
        return patrolStructureMapper.queryDetail(id);
    }

    @Override
    public List<RspPatrolStructureDto> queryList(ReqPatrolStructureDto reqDto) {
        List<RspPatrolStructureDto> list = patrolStructureMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspPatrolStructureDto> queryPage(ReqPatrolStructureDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspPatrolStructureDto> queryPageConditions(ReqPatrolStructureDto reqDto) {
        Page<RspPatrolStructureDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspPatrolStructureDto> pageInfo = patrolStructureMapper.queryByConditions(page, reqDto);
        PageInfo<RspPatrolStructureDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspPatrolStructureDto> list) {
        list.forEach(a -> {

        });
    }

}
