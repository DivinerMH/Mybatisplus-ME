package com.menghuan.admin.service.impl;

import com.menghuan.admin.entity.Menu;
import com.menghuan.admin.mapper.MenuMapper;
import com.menghuan.admin.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
