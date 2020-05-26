package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.Tenant;
import com.fitmgr.quota.mapper.TenantMapper;
import com.fitmgr.quota.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
