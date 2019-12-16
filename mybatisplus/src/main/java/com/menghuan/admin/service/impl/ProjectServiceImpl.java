package com.menghuan.admin.service.impl;

import com.menghuan.admin.entity.Project;
import com.menghuan.admin.mapper.ProjectMapper;
import com.menghuan.admin.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * project表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2019-11-16
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
