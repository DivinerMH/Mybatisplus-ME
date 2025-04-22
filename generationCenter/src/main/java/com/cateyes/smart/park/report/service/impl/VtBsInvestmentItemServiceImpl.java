package com.cateyes.smart.park.report.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemAddDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemQueryDto;
import com.cateyes.smart.park.report.bean.dto.ReqVtBsInvestmentItemUpdateDto;
import com.cateyes.smart.park.report.bean.dto.RspVtBsInvestmentItemDto;
import com.cateyes.smart.park.report.bean.po.VtBsInvestmentItem;

/**
 * 智慧大屏-手工-招商项目(SpVtBsInvestmentItem)impl
 *
 * @author CatEyes
 * @since 2024-04-12 15:11:20
 */
@Service
@AllArgsConstructor
public class VtBsInvestmentItemServiceImpl implements IVtBsInvestmentItemService {

    private VtBsInvestmentItemMapper vtBsInvestmentItemMapper;

    @Override
    public int add(ReqVtBsInvestmentItemAddDto reqDto) {
        // checkNameUnique(reqDto.getName());
        VtBsInvestmentItem map = BeanMapperUtil.map(reqDto, VtBsInvestmentItem.class);
        int insert = vtBsInvestmentItemMapper.insert(map);
        Assert.isTrue(insert == 1, ApiCode.RECORD_NOT_EXIST);
        return map.getId();
    }

    @Override
    public int del(ReqIdDto reqDto) {
        VtBsInvestmentItem entity = vtBsInvestmentItemMapper.selectById(reqDto.getId());
        Assert.notNull(entity, ApiCode.RECORD_NOT_EXIST);
        return vtBsInvestmentItemMapper.deleteById(reqDto.getId());
    }

    @Override
    public int update(ReqVtBsInvestmentItemUpdateDto reqDto) {
        VtBsInvestmentItem vtBsInvestmentItem = vtBsInvestmentItemMapper.selectById(reqDto.getId());
        Assert.notNull(vtBsInvestmentItem, ApiCode.RECORD_NOT_EXIST);
        // if (StringUtils.isNotBlank(reqDto.getName()) && !StringUtils.equals(vtBsInvestmentItem.getName(),
        // reqDto.getName())) {
        // checkNameUnique(reqDto.getName());
        // }
        return vtBsInvestmentItemMapper.updateById(BeanMapperUtil.map(reqDto, VtBsInvestmentItem.class));
    }

    @Override
    public RspVtBsInvestmentItemDto detail(ReqIdDto reqDto) {
        RspVtBsInvestmentItemDto rspDto = vtBsInvestmentItemMapper.detail(reqDto.getId());
        Assert.notNull(rspDto, ApiCode.RECORD_NOT_EXIST);
        List<RspVtBsInvestmentItemDto> list = Stream.of(rspDto).collect(Collectors.toList());
        listConverter(list);
        return list.get(0);
    }

    @Override
    public PageInfo<RspVtBsInvestmentItemDto> queryPage(ReqVtBsInvestmentItemQueryDto reqDto) {
        return queryPageConditions(reqDto);
    }

    private PageInfo<RspVtBsInvestmentItemDto> queryPageConditions(ReqVtBsInvestmentItemQueryDto reqDto) {
        Page<RspVtBsInvestmentItemDto> page = new Page<>(reqDto.getPageNo(), reqDto.getPageSize());
        IPage<RspVtBsInvestmentItemDto> pageInfo = vtBsInvestmentItemMapper.queryByConditions(page, reqDto);
        PageInfo<RspVtBsInvestmentItemDto> pageResult = PageUtils.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        listConverter(pageResult.getList());
        return pageResult;
    }

    private void listConverter(List<RspVtBsInvestmentItemDto> list) {
        list.forEach(a -> {

        });
    }

    // private void checkNameUnique(String name) {
    // Integer count = vtBsInvestmentItemMapper.selectCount(
    // Wrappers.<VtBsInvestmentItem>lambdaQuery().eq(StringUtils.isNotBlank(name),VtBsInvestmentItem::getName, name));
    // Assert.isTrue(count < 1, ApiCode.REPORT_DUPLICATE_NAME)
    // }

}
