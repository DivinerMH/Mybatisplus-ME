package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.User;
import com.fitmgr.quota.mapper.UserMapper;
import com.fitmgr.quota.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
