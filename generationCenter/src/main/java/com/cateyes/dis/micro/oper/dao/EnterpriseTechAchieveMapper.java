package com.cateyes.dis.micro.oper.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.dis.micro.oper.bean.dto.RspEnterpriseTechAchieveDto;
import com.cateyes.dis.micro.oper.bean.dto.ReqEnterpriseTechAchieveQueryDto;
import com.cateyes.dis.micro.oper.bean.po.EnterpriseTechAchieve;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业科技成果(DisEnterpriseTechAchieve)Mapper
 *
 * @author CatEyes
 * @since 2024-02-01 19:22:45
 */
@Mapper
public interface EnterpriseTechAchieveMapper extends BaseMapper<EnterpriseTechAchieve> {

    /**
     * 详情查询
     * 
     * @param id 企业科技成果id
     * @return 企业科技成果展示对象RspEnterpriseTechAchieveDto
     */
    RspEnterpriseTechAchieveDto detail(@Param("id") Integer id);

    /**
     * 分页查询
     * 
     * @param page 分页参数
     * @param reqDto 入参DTO
     * @return 企业科技成果分页展示对象集合
     */
    IPage<RspEnterpriseTechAchieveDto> queryByConditions(@Param("page") Page page,
        @Param("reqDto") ReqEnterpriseTechAchieveQueryDto reqDto);

}
