package com.fitmgr.admin.service.impl;

import com.fitmgr.admin.entity.Project;
import com.fitmgr.admin.mapper.ProjectMapper;
import com.fitmgr.admin.service.IProjectService;
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
