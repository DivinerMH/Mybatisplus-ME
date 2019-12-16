package com.menghuan.admin.service.impl;

import com.menghuan.admin.entity.Tenant;
import com.menghuan.admin.mapper.TenantMapper;
import com.menghuan.admin.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
