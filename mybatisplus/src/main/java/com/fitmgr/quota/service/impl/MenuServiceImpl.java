package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.Menu;
import com.fitmgr.quota.mapper.MenuMapper;
import com.fitmgr.quota.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
