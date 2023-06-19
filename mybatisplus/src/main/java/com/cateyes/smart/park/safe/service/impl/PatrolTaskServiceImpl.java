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
 * 巡检任务(SpSfPatrolTask)impl
 *
 * @author CatEyes
 * @since 2023-06-12 16:26:48
 */
@Service
@AllArgsConstructor
public class PatrolTaskServiceImpl extends ServiceImpl<PatrolTaskMapper, PatrolTask> implements IPatrolTaskService {

    private PatrolTaskMapper patrolTaskMapper;

    @Override
    public int savePatrolTask(ReqPatrolTaskDto reqDto) {
        List<PatrolTask> list = patrolTaskMapper.selectList(new LambdaQueryWrapper<PatrolTask>()
            .eq(StringUtils.isNotBlank(reqDto.getName()), PatrolTask::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        PatrolTask map = BeanMapperUtil.map(reqDto, PatrolTask.class);
        patrolTaskMapper.insert(map);
        return map.getId();
    }

    @Override
    public Boolean deletePatrolTask(Integer id) {
        PatrolTask patrolTask = patrolTaskMapper.selectById(id);
        Assert.notNull(patrolTask, ApiCode.NOT_FOUND);
        return patrolTaskMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updatePatrolTask(ReqPatrolTaskDto reqDto) {
        PatrolTask patrolTask = patrolTaskMapper.selectById(reqDto.getId());
        Assert.notNull(patrolTask, ApiCode.NOT_FOUND);
        if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(patrolTask.getName(), reqDto.getName())) {
            List<PatrolTask> list = patrolTaskMapper
                .selectList(Wrappers.<PatrolTask>lambdaQuery().eq(PatrolTask::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        }
        return patrolTaskMapper.updateById(BeanMapperUtil.map(reqDto, PatrolTask.class)) > 0;
    }

    @Override
    public RspPatrolTaskDto queryDetail(Integer id) {
        return patrolTaskMapper.queryDetail(id);
    }

    @Override
    public List<RspPatrolTaskDto> queryList(ReqPatrolTaskDto reqDto) {
        List<RspPatrolTaskDto> list = patrolTaskMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public PageInfo<RspPatrolTaskDto> queryPage(ReqPatrolTaskDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspPatrolTaskDto> queryPageConditions(ReqPatrolTaskDto reqDto) {
        Page<RspPatrolTaskDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspPatrolTaskDto> pageInfo = patrolTaskMapper.queryByConditions(page, reqDto);
        PageInfo<RspPatrolTaskDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspPatrolTaskDto> list) {
        list.forEach(a -> {

        });
    }

}
