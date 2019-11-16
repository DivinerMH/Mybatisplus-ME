package com.fitmgr.admin.service.impl;

import com.fitmgr.admin.entity.TenantType;
import com.fitmgr.admin.mapper.TenantTypeMapper;
import com.fitmgr.admin.service.ITenantTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户类型表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Service
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType> implements ITenantTypeService {

}
