package com.fitmgr.quota.service.impl;

import com.fitmgr.quota.entity.Project;
import com.fitmgr.quota.mapper.ProjectMapper;
import com.fitmgr.quota.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * project表 服务实现类
 * </p>
 *
 * @author menghuan
 * @since 2020-05-20
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
