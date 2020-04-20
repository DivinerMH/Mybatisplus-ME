package com.hzcloud.iot.house.service.impl;

import com.hzcloud.iot.house.entity.IotResources;
import com.hzcloud.iot.house.mapper.IotResourcesMapper;
import com.hzcloud.iot.house.service.IIotResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房源信息表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-04-01
 */
@Service
public class IotResourcesServiceImpl extends ServiceImpl<IotResourcesMapper, IotResources> implements IIotResourcesService {

}
