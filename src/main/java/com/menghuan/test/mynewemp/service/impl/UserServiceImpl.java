package com.menghuan.test.mynewemp.service.impl;

import com.menghuan.test.mynewemp.entity.User;
import com.menghuan.test.mynewemp.mapper.UserMapper;
import com.menghuan.test.mynewemp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-09-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
