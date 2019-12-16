package com.menghuan.admin.service.impl;

import com.menghuan.admin.entity.Role;
import com.menghuan.admin.mapper.RoleMapper;
import com.menghuan.admin.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
