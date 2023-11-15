package com.cateyes.iis.micro.resource.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cateyes.iis.micro.resource.bean.dto.RspparkIndexDto;
import com.cateyes.iis.micro.resource.bean.dto.ReqparkIndexDto;
import com.cateyes.iis.micro.resource.bean.po.parkIndex;

/**
 * (IisParkIndex)service
 *
 * @author CatEyes
 * @since 2023-10-17 11:11:53
 */

public interface IParkIndexService extends SpBaseService<RspParkIndexDto, ReqParkIndexDto> {

}
