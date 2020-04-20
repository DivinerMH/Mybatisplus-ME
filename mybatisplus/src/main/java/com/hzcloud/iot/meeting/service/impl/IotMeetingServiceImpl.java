package com.hzcloud.iot.meeting.service.impl;

import com.hzcloud.iot.meeting.entity.IotMeeting;
import com.hzcloud.iot.meeting.mapper.IotMeetingMapper;
import com.hzcloud.iot.meeting.service.IIotMeetingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会议信息表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-04-20
 */
@Service
public class IotMeetingServiceImpl extends ServiceImpl<IotMeetingMapper, IotMeeting> implements IIotMeetingService {

}
