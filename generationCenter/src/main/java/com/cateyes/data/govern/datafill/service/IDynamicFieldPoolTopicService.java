package com.cateyes.data.govern.datafill.service;


import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicAddDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicQueryDto;
import com.cateyes.data.govern.datafill.bean.dto.ReqDynamicFieldPoolTopicUpdateDto;
import com.cateyes.data.govern.datafill.bean.dto.RspDynamicFieldPoolTopicDto;

/**
 * 动态表单字段池主题关联(DgDynamicFieldPoolTopic)service
 *
 * @author CatEyes
 * @since 2023-12-04 19:36:11
 */

public interface IDynamicFieldPoolTopicService {

    /**
     * 新增
     * @param reqDto 入参DTO
     * @return 主键ID
     */
    int add(ReqDynamicFieldPoolTopicAddDto reqDto);

    /**
     * 删除
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int del(ReqIdDto reqDto);

    /**
     * 修改
     * @param reqDto 入参DTO
     * @return Affect rows
     */
    int update(ReqDynamicFieldPoolTopicUpdateDto reqDto);

    /**
     * 详情
     * @param reqDto 入参DTO
     * @return RspDynamicFieldPoolTopicDto展示对象
     */
    RspDynamicFieldPoolTopicDto detail(ReqIdDto reqDto);

    /**
     * 分页查询
     * @param reqDto 入参DTO
     * @return RspDynamicFieldPoolTopicDto展示对象 PageInfo
     */
    PageInfo<RspDynamicFieldPoolTopicDto> queryPage(ReqDynamicFieldPoolTopicQueryDto reqDto);
    
}
