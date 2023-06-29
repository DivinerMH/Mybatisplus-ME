package com.cateyes.smart.park.report.dao;

    
    







import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.report.bean.dto.RspbsProjectKeyDto;
import com.cateyes.smart.park.report.bean.po.bsProjectKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 智慧大屏-系统-重点投资类项目报表(SpBsProjectKey)Mapper
 *
 * @author CatEyes
 * @since 2023-06-29 10:51:46
 */
@Mapper
public interface BsProjectKeyMapper extends BaseMapper<BsProjectKey> {

}
