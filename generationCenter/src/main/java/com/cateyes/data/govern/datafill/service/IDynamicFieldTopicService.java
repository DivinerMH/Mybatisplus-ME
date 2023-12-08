package com.cateyes.data.govern.datafill.service;

import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldTopicDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldTopicQueryDto;

/**
 * 动态表单字段主题(DgDynamicFieldTopic)service
 *
 * @author CatEyes
 * @since 2023-12-05 09:30:07
 */

public interface IDynamicFieldTopicService {

    /**
     * 新增
     * 
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqDynamicFieldTopicAddDto reqDto);

    /**
     * 删除
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int del(ReqIdDto reqDto);

    /**
     * 修改
     * 
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqDynamicFieldTopicUpdateDto reqDto);

    /**
     * 详情
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicFieldTopicDto展示对象
     */
    RspDynamicFieldTopicDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * 
     * @param reqDto 入参DTO
     * @return RspDynamicFieldTopicDto展示对象 PageInfo
     */
    PageInfo<RspDynamicFieldTopicDto> queryPage(ReqDynamicFieldTopicQueryDto reqDto);

}
