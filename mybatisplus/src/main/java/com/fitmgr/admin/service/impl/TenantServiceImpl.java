package com.fitmgr.admin.service.impl;

import com.fitmgr.admin.entity.Tenant;
import com.fitmgr.admin.mapper.TenantMapper;
import com.fitmgr.admin.service.ITenantService;
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
