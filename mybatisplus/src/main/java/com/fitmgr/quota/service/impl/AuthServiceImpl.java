package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.Auth;
import com.fitmgr.quota.mapper.AuthMapper;
import com.fitmgr.quota.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

}
