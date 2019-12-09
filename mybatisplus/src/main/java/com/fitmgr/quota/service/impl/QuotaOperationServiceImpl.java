package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.QuotaOperation;
import com.fitmgr.quota.mapper.QuotaOperationMapper;
import com.fitmgr.quota.service.IQuotaOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 配额操作表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-12-09
 */
@Service
public class QuotaOperationServiceImpl extends ServiceImpl<QuotaOperationMapper, QuotaOperation> implements IQuotaOperationService {

}
