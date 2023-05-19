package com.cateyes.smart.park.invest.dao;

    
    







import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cateyes.smart.park.invest.bean.po.Industry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 产业-产业环节-产业节点信息表(SpIndustry)Mapper
 *
 * @author CatEyes
 * @since 2023-04-19 14:23:49
 */
@Mapper
public interface IndustryMapper extends BaseMapper<Industry> {

}
