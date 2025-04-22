package com.cateyes.dis.micro.oper.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerAddDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerQueryDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseWorkerUpdateDto;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseWorkerDto;
import com.cateyes.dis.micro.oper.bean.po.EnterpriseWorker;

/**
 * 企业用工(DisEnterpriseWorker)impl
 *
 * @author CatEyes
 * @since 2024-02-01 19:30:35
 */
@Service
@AllArgsConstructor
public class EnterpriseWorkerServiceImpl implements IEnterpriseWorkerService {

    private EnterpriseWorkerMapper enterpriseWorkerMapper;

    @Override
    public int add(ReqEnterpriseWorkerAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        EnterpriseWorker map = BeanMapperUtil.map(reqDto, EnterpriseWorker.class);
        int insert = enterpriseWorkerMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        EnterpriseWorker entity = enterpriseWorkerMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return enterpriseWorkerMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqEnterpriseWorkerUpdateDto reqDto) {
        EnterpriseWorker enterpriseWorker = enterpriseWorkerMapper.selectById(reqDto.getId());
        Assert.notNull(enterpriseWorker, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(enterpriseWorker.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return enterpriseWorkerMapper.updateById(BeanMapperUtil.map(reqDto, EnterpriseWorker.class));
    }

    @Override
    public RspEnterpriseWorkerDto detail(ReqIdDto reqDto) {
        RspEnterpriseWorkerDto rspDto = enterpriseWorkerMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspEnterpriseWorkerDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspEnterpriseWorkerDto> queryPage(ReqEnterpriseWorkerQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspEnterpriseWorkerDto> queryPageConditions(ReqEnterpriseWorkerQueryDto reqDto) {
        Page<RspEnterpriseWorkerDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspEnterpriseWorkerDto> pageInfo = enterpriseWorkerMapper.queryByConditions(page, reqDto);
        PageInfo<RspEnterpriseWorkerDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspEnterpriseWorkerDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = enterpriseWorkerMapper.selectCount(
    // Wrappers.<EnterpriseWorker>lambdaQuery().eq(StringUtils.isNotBlank(name),EnterpriseWorker::getName, name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
