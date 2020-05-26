package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.UserPasswordLog;
import com.fitmgr.quota.mapper.UserPasswordLogMapper;
import com.fitmgr.quota.service.IUserPasswordLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户密码记录表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class UserPasswordLogServiceImpl extends ServiceImpl<UserPasswordLogMapper, UserPasswordLog> implements IUserPasswordLogService {

}
