package com.cateyes.smart.park.safe.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cateyes.smart.park.safe.bean.dto.ReqPatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.dto.RspPatrolTaskWorkDto;
import com.cateyes.smart.park.safe.bean.po.PatrolTaskWork;
import com.cateyes.smart.park.safe.dao.PatrolTaskWorkMapper;
import com.cateyes.smart.park.safe.service.IPatrolTaskWorkService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import com.cateyes.smart.park.base.api.ApiCode;
import com.cateyes.smart.park.core.util.Assert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.BeanMapperUtil;

/**
 * 巡检任务工单(SpSfPatrolTaskWork)impl
 *
 * @author CatEyes
 * @since 2023-06-12 16:27:02
 */
@Service
@AllArgsConstructor
public class PatrolTaskWorkServiceImpl extends ServiceImpl<PatrolTaskWorkMapper, PatrolTaskWork>
    implements IPatrolTaskWorkService {

    private PatrolTaskWorkMapper patrolTaskWorkMapper;

    @Override
    public int savePatrolTaskWork(ReqPatrolTaskWorkDto reqDto) {
        List<PatrolTaskWork> list = patrolTaskWorkMapper.selectList(new LambdaQueryWrapper<PatrolTaskWork>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), PatrolTaskWork::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        PatrolTaskWork map = BeanMapperUtil.map(reqDto, PatrolTaskWork.class);
        patrolTaskWorkMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deletePatrolTaskWork(Integer id) {
        PatrolTaskWork patrolTaskWork = patrolTaskWorkMapper.selectById(id);
        Assert.notNull(patrolTaskWork, ApiCode.NOT_FOUND);
        return patrolTaskWorkMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updatePatrolTaskWork(ReqPatrolTaskWorkDto reqDto) {
        PatrolTaskWork patrolTaskWork = patrolTaskWorkMapper.selectById(reqDto.getId());
        Assert.notNull(patrolTaskWork, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName())
            && !StringUtils.equals(patrolTaskWork.getName(), reqDto.getName())) {
            List<PatrolTaskWork> list = patrolTaskWorkMapper
                .selectList(Wrappers.<PatrolTaskWork>lambdaQuery().eq(PatrolTaskWork::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return patrolTaskWorkMapper.updateById(BeanMapperUtil.map(reqDto, PatrolTaskWork.class)) > 0;
    }

    @Override
    public RspPatrolTaskWorkDto queryDetail(Integer id) {
        return patrolTaskWorkMapper.queryDetail(id);
    }

    @Override
    public List<RspPatrolTaskWorkDto> queryList(ReqPatrolTaskWorkDto reqDto) {
        List<RspPatrolTaskWorkDto> list = patrolTaskWorkMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspPatrolTaskWorkDto> queryPage(ReqPatrolTaskWorkDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspPatrolTaskWorkDto> queryPageConditions(ReqPatrolTaskWorkDto reqDto) {
        Page<RspPatrolTaskWorkDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspPatrolTaskWorkDto> pageInfo = patrolTaskWorkMapper.queryByConditions(page, reqDto);
        PageInfo<RspPatrolTaskWorkDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspPatrolTaskWorkDto> list) {
        list.forEach(a -> {

        });
    }

}
