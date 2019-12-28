package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.TbLog;
import com.fitmgr.quota.mapper.TbLogMapper;
import com.fitmgr.quota.service.ITbLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Service
public class TbLogServiceImpl extends ServiceImpl<TbLogMapper, TbLog> implements ITbLogService {

}
