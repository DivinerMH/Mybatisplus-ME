package com.dfzl.system.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jeecg.common.constant.ApiCode;
import org.jeecg.common.util.BeanMapperUtil;
import org.jeecg.common.util.BusinessValidator;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dfzl.system.bean.dto.ReqSysAnnouncementAddDto;
import com.dfzl.system.bean.dto.ReqSysAnnouncementQueryDto;
import com.dfzl.system.bean.dto.ReqSysAnnouncementUpdateDto;
import com.dfzl.system.bean.dto.RspSysAnnouncementDto;
import com.dfzl.system.bean.po.SysAnnouncement;
import com.dfzl.system.mapper.SysAnnouncementMapper;
import com.dfzl.system.service.ISysAnnouncementService;

import lombok.AllArgsConstructor;

/**
 * 系统通告表(SysAnnouncement)impl
 *
 * @author menghuan
 * @since 2025-09-11 15:01:58
 */
@Service
@AllArgsConstructor
public class SysAnnouncementServiceImpl extends ServiceImpl<SysAnnouncementMapper, SysAnnouncement>
    implements ISysAnnouncementService {

    private SysAnnouncementMapper sysAnnouncementMapper;

    @Override
    public String add(ReqSysAnnouncementAddDto reqDto) {
        // checkUniqueName(reqDto.getName(), "");
        SysAnnouncement entity = BeanMapperUtil.map(reqDto, SysAnnouncement.class);
        int insert = sysAnnouncementMapper.insert(entity);
        BusinessValidator.isTrue(insert == 1, ApiCode.NOT_FOUND);
        return entity.getId();
    }

    @Override
    public int delete(String id) {
        // 资源占用校验
        SysAnnouncement entity = sysAnnouncementMapper.selectById(id);
        BusinessValidator.isNotNull(entity, ApiCode.NOT_FOUND);
        return sysAnnouncementMapper.deleteById(id);
    }

    @Override
    public int update(ReqSysAnnouncementUpdateDto reqDto) {
        SysAnnouncement entity = sysAnnouncementMapper.selectById(reqDto.getId());
        BusinessValidator.isNotNull(entity, ApiCode.NOT_FOUND);
        // checkUniqueName(reqDto.getName(), reqDto.getId());
        return sysAnnouncementMapper.updateById(BeanMapperUtil.map(reqDto, SysAnnouncement.class));
    }

    /* 
    @Override
    public void updateStatus(ReqIdsTypeDto reqDto) {
        List<SysAnnouncement> list =
            sysAnnouncementMapper.selectBatchIds(reqDto.getIds());
        BusinessValidator.isNotEmpty(list, ApiCode.NOT_FOUND.getMsg());
        BusinessValidator.isTrue(Arrays.asList("1", "2", "3", "4").contains(reqDto.getType()), "状态参数异常，请核实后操作");
        // 批处理
        List<SysAnnouncement> collect = list.stream().map(entity -> {
            SysAnnouncement build =
                SysAnnouncement.builder().status(reqDto.getType()).build();
            build.setId(entity.getId());
            return build;
        }).collect(Collectors.toList());
        this.updateBatchById(collect);
    }
    */

    @Override
    public RspSysAnnouncementDto detail(String id) {
        RspSysAnnouncementDto rspDto = sysAnnouncementMapper.detail(id);
        BusinessValidator.isNotNull(rspDto, ApiCode.NOT_FOUND);
        List<RspSysAnnouncementDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public List<RspSysAnnouncementDto> queryList(ReqSysAnnouncementQueryDto reqDto) {
        List<RspSysAnnouncementDto> list = sysAnnouncementMapper.queryByConditions(reqDto);
        listConverter(list);
        return list;
    }

    @Override
    public IPage<RspSysAnnouncementDto> queryPage(ReqSysAnnouncementQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private IPage<RspSysAnnouncementDto> queryPageConditions(ReqSysAnnouncementQueryDto reqDto) {
        Page<RspSysAnnouncementDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspSysAnnouncementDto> pageResult = sysAnnouncementMapper.queryByConditions(page, reqDto);
        listConverter(pageResult.getRecords());
        return pageResult;
    }

    private void listConverter(List<RspSysAnnouncementDto> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        list.forEach(a -> {

        });
    }

    /**
     * 校验：唯一名称
     * 
     * @param name 名称
     * @param id 主键ID
     */
    /*private void checkUniqueName(String name, String id) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        Long count = sysAnnouncementMapper
            .selectCount(Wrappers.<SysAnnouncement>lambdaQuery().eq(SysAnnouncement::getName, name)
                .ne(StringUtils.isNotBlank(id), SysAnnouncement::getId, id));
        BusinessValidator.isTrue(count < 1, ApiCode.REPEAT_NAME);
    }*/

}
