package com.hzcloud.iot.house.service.impl;

import com.hzcloud.iot.house.entity.IotType;
import com.hzcloud.iot.house.mapper.IotTypeMapper;
import com.hzcloud.iot.house.service.IIotTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房源类型表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-04-01
 */
@Service
public class IotTypeServiceImpl extends ServiceImpl<IotTypeMapper, IotType> implements IIotTypeService {

}
