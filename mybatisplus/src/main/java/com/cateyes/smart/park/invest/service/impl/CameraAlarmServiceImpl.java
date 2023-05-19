package com.cateyes.smart.park.invest.service.impl;

    
    






import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.invest.bean.dto.ReqCameraAlarmDto;
import com.cateyes.smart.park.invest.bean.dto.RspCameraAlarmDto;
import com.cateyes.smart.park.invest.service.ICameraAlarmService;
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
 * @since 2023-05-17 09:59:54
 */
@Service
@AllArgsConstructor
public class CameraAlarmServiceImpl extends ServiceImpl<CameraAlarmMapper, CameraAlarm> implements ICameraAlarmService {

	@Resource
    private CameraAlarmMapper cameraAlarmMapper;
	
	@Override
    public int saveCameraAlarm(ReqCameraAlarmDto reqDto){
        List<CameraAlarm> list = cameraAlarmMapper.selectList(
            new LambdaQueryWrapper<CameraAlarm>().eq(StringUtils.isNotBlank(reqDto.getName()), CameraAlarm::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return cameraAlarmMapper.insert(BeanMapperUtil.map(reqDto, CameraAlarm.class));
    }

    @Override
    public Boolean deleteCameraAlarm(Integer id){
        CameraAlarm cameraAlarm = cameraAlarmMapper.selectById(id);
        Assert.notNull(cameraAlarm, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return cameraAlarmMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateCameraAlarm(ReqCameraAlarmDto reqDto){
        CameraAlarm cameraAlarm = cameraAlarmMapper.selectById(reqDto.getId());
        Assert.notNull(cameraAlarm, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        if (reqDto.getName() != null && !StringUtils.equals(cameraAlarm.getName(), reqDto.getName())) {
            List<CameraAlarm> list =
                cameraAlarmMapper.selectList(Wrappers.<CameraAlarm>lambdaQuery().eq(CameraAlarm::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return cameraAlarmMapper.updateById(BeanMapperUtil.map(reqDto, CameraAlarm.class)) > 0;
    }
    
    @Override
    public RspCameraAlarmDto queryDetail(Integer id){
        return cameraAlarmMapper.queryDetail(id);
    }

    @Override
    public List<RspCameraAlarmDto> queryList(ReqCameraAlarmDto reqDto) {
        return cameraAlarmMapper.queryList(reqDto);
    }
    
    @Override
    public PageInfo<RspCameraAlarmDto> queryPage(ReqCameraAlarmDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspCameraAlarmDto> queryPageConditions(ReqCameraAlarmDto reqDto) {
        Page<RspCameraAlarmDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspCameraAlarmDto> pageInfo = cameraAlarmMapper.queryByConditions(page, reqDto);
        PageInfo<RspCameraAlarmDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        return pageResult;
    }

}
