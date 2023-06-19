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
 * 巡检点(SpSfPatrolPoint)impl
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:15
 */
@Service
@AllArgsConstructor
public class PatrolPointServiceImpl extends ServiceImpl<PatrolPointMapper, PatrolPoint> implements IPatrolPointService {

    private PatrolPointMapper patrolPointMapper;

    @Override
    public int savePatrolPoint(ReqPatrolPointDto reqDto) {
        List<PatrolPoint> list = patrolPointMapper.selectList(new LambdaQueryWrapper<PatrolPoint>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), PatrolPoint::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        PatrolPoint map = BeanMapperUtil.map(reqDto, PatrolPoint.class);
        patrolPointMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deletePatrolPoint(Integer id) {
        PatrolPoint patrolPoint = patrolPointMapper.selectById(id);
        Assert.notNull(patrolPoint, ApiCode.NOT_FOUND);
        return patrolPointMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updatePatrolPoint(ReqPatrolPointDto reqDto) {
        PatrolPoint patrolPoint = patrolPointMapper.selectById(reqDto.getId());
        Assert.notNull(patrolPoint, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(patrolPoint.getName(), reqDto.getName())) {
            List<PatrolPoint> list = patrolPointMapper
                .selectList(Wrappers.<PatrolPoint>lambdaQuery().eq(PatrolPoint::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return patrolPointMapper.updateById(BeanMapperUtil.map(reqDto, PatrolPoint.class)) > 0;
    }

    @Override
    public RspPatrolPointDto queryDetail(Integer id) {
        return patrolPointMapper.queryDetail(id);
    }

    @Override
    public List<RspPatrolPointDto> queryList(ReqPatrolPointDto reqDto) {
        List<RspPatrolPointDto> list = patrolPointMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspPatrolPointDto> queryPage(ReqPatrolPointDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspPatrolPointDto> queryPageConditions(ReqPatrolPointDto reqDto) {
        Page<RspPatrolPointDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspPatrolPointDto> pageInfo = patrolPointMapper.queryByConditions(page, reqDto);
        PageInfo<RspPatrolPointDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspPatrolPointDto> list) {
        list.forEach(a -> {

        });
    }

}
