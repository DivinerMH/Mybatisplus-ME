package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.TenantType;
import com.fitmgr.quota.mapper.TenantTypeMapper;
import com.fitmgr.quota.service.ITenantTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户类型表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType> implements ITenantTypeService {

}
