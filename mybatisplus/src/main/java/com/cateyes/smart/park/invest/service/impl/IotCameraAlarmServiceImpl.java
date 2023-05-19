package com.cateyes.smart.park.invest.service.impl;

    
    






import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cateyes.smart.park.invest.bean.dto.ReqIotCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.dto.RspIotCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.po.IotCameraAlarm;
import com.cateyes.smart.park.invest.dao.IotCameraAlarmMapper;
import com.cateyes.smart.park.invest.service.IIotCameraAlarmService;
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
 * 视屏告警事件(SpIotCameraAlarm)impl
 *
 * @author CatEyes
 * @since 2023-05-16 14:56:23
 */
@Service
@AllArgsConstructor
public class IotCameraAlarmServiceImpl extends ServiceImpl<IotCameraAlarmMapper, IotCameraAlarm> implements IIotCameraAlarmService {

	@Resource
    private IotCameraAlarmMapper iotCameraAlarmMapper;
	
	@Override
    public int saveIotCameraAlarm(ReqIotCameraAlarmDto reqDto){
        List<IotCameraAlarm> list = iotCameraAlarmMapper.selectList(
            new LambdaQueryWrapper<IotCameraAlarm>().eq(StringUtils.isNotBlank(reqDto.getName()), IotCameraAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return iotCameraAlarmMapper.insert(BeanMapperUtil.map(reqDto, IotCameraAlarm.class));
    }

    @Override
    public Boolean deleteIotCameraAlarm(Integer id){
        IotCameraAlarm iotCameraAlarm = iotCameraAlarmMapper.selectById(id);
        Assert.notNull(iotCameraAlarm, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return iotCameraAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateIotCameraAlarm(ReqIotCameraAlarmDto reqDto){
        IotCameraAlarm iotCameraAlarm = iotCameraAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(iotCameraAlarm, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        if (reqDto.getName() != null && !StringUtils.equals(iotCameraAlarm.getName(), reqDto.getName())) {
            List<IotCameraAlarm> list =
                iotCameraAlarmMapper.selectList(Wrappers.<IotCameraAlarm>lambdaQuery().eq(IotCameraAlarm::getCameraId, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return iotCameraAlarmMapper.updateById(BeanMapperUtil.map(reqDto, IotCameraAlarm.class)) > 0;
    }
    
    @Override
    public RspIotCameraAlarmDto queryDetail(Integer id){
        return iotCameraAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspIotCameraAlarmDto> queryList(ReqIotCameraAlarmDto reqDto) {
        return iotCameraAlarmMapper.queryList(reqDto);
    }
    
    @Override
    public PageInfo<RspIotCameraAlarmDto> queryPage(ReqIotCameraAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspIotCameraAlarmDto> queryPageConditions(ReqIotCameraAlarmDto reqDto) {
        Page<RspIotCameraAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspIotCameraAlarmDto> pageInfo = iotCameraAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspIotCameraAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        return pageResult;
    }

}
