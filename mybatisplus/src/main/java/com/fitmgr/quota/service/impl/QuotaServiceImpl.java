package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.Quota;
import com.fitmgr.quota.mapper.QuotaMapper;
import com.fitmgr.quota.service.IQuotaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 配额表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-12-16
 */
@Service
public class QuotaServiceImpl extends ServiceImpl<QuotaMapper, Quota> implements IQuotaService {

}
