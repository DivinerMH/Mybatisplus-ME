package com.cateyes.smart.park.service.impl;

    
    






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
 * (SpIotDeviceType)impl
 *
 * @author CatEyes
 * @since 2023-05-19 15:32:56
 */
@Service
@AllArgsConstructor
public class DeviceTypeServiceImpl extends ServiceImpl<DeviceTypeMapper, DeviceType> implements IDeviceTypeService{

	@Resource
    private DeviceTypeMapper deviceTypeMapper;
	
	@Override
    public int saveDeviceType(ReqDeviceTypeDto reqDto){
        List<DeviceType> list = deviceTypeMapper.selectList(
            new LambdaQueryWrapper<DeviceType>().eq(StringUtils.isNotBlank(reqDto.getName()), DeviceType::getName, reqDto.getName()));
        Assert.isTrue(CollectionUtils.isEmpty(list), "名称重复");
        return deviceTypeMapper.insert(BeanMapperUtil.map(reqDto, DeviceType.class));
    }

    @Override
    public Boolean deleteDeviceType(Integer id){
        DeviceType deviceType = deviceTypeMapper.selectById(id);
        Assert.notNull(deviceType, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        return deviceTypeMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateDeviceType(ReqDeviceTypeDto reqDto){
        DeviceType deviceType = deviceTypeMapper.selectById(reqDto.getId());
        Assert.notNull(deviceType, ApiCode.RESOURCE_NOT_EXISTS.getMsg());
        if (reqDto.getName() != null && !StringUtils.equals(deviceType.getName(), reqDto.getName())) {
            List<DeviceType> list =
                deviceTypeMapper.selectList(Wrappers.<DeviceType>lambdaQuery().eq(DeviceType::getName, reqDto.getName()));
            Assert.isTrue(CollectionUtils.isEmpty(list), ApiCode.INVEST_INDUSTRY_NAME_REPEAT);
        }
        return deviceTypeMapper.updateById(BeanMapperUtil.map(reqDto, DeviceType.class)) > 0;
    }
    
    @Override
    public RspDeviceTypeDto queryDetail(Integer id){
        return deviceTypeMapper.queryDetail(id);
    }

    @Override
    public List<RspDeviceTypeDto> queryList(ReqDeviceTypeDto reqDto) {
        return deviceTypeMapper.queryList(reqDto);
    }
    
    @Override
    public PageInfo<RspDeviceTypeDto> queryPage(ReqDeviceTypeDto reqDto) {
        return queryPageConditions(reqDto);
    }
    
    private PageInfo<RspDeviceTypeDto> queryPageConditions(ReqDeviceTypeDto reqDto) {
        Page<RspDeviceTypeDto> page = new Page<>();
        if (null != reqDto.getPageNo()) {
            page.setCurrent(reqDto.getPageNo());
        }
        if (null != reqDto.getPageSize()) {
            page.setSize(reqDto.getPageSize());
        }
        IPage<RspDeviceTypeDto> pageInfo = deviceTypeMapper.queryByConditions(page, reqDto);
        PageInfo<RspDeviceTypeDto> pageResult = PageUtil.build(Math.toIntExact(pageInfo.getCurrent()),
            Math.toIntExact(page.getSize()), pageInfo.getRecords(), Math.toIntExact(page.getTotal()));
        if (CollectionUtils.isEmpty(pageResult.getList())) {
            return pageResult;
        }
        // 数据转换
        return pageResult;
    }

}
