package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.Role;
import com.fitmgr.quota.mapper.RoleMapper;
import com.fitmgr.quota.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
