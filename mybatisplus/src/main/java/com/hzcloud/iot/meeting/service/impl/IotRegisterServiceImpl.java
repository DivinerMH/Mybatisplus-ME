package com.hzcloud.iot.meeting.service.impl;

import com.hzcloud.iot.meeting.entity.IotRegister;
import com.hzcloud.iot.meeting.mapper.IotRegisterMapper;
import com.hzcloud.iot.meeting.service.IIotRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会议签到表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-04-20
 */
@Service
public class IotRegisterServiceImpl extends ServiceImpl<IotRegisterMapper, IotRegister> implements IIotRegisterService {

}
