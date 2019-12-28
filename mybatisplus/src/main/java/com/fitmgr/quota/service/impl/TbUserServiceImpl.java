package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.TbUser;
import com.fitmgr.quota.mapper.TbUserMapper;
import com.fitmgr.quota.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
