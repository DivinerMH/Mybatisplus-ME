package com.fitmgr.admin.service.impl;

import com.fitmgr.admin.entity.User;
import com.fitmgr.admin.mapper.UserMapper;
import com.fitmgr.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
