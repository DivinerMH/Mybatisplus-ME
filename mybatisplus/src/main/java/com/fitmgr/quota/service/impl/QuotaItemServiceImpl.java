package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.QuotaItem;
import com.fitmgr.quota.mapper.QuotaItemMapper;
import com.fitmgr.quota.service.IQuotaItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 配额项表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-12-09
 */
@Service
public class QuotaItemServiceImpl extends ServiceImpl<QuotaItemMapper, QuotaItem> implements IQuotaItemService {

}
