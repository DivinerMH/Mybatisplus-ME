package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ${table.comment!} Mapper 接口
 * @author ${author}
 * @since ${date}
 */
@Mapper
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    /**
    * 根据id查询${table.comment!}详情(跨服务)
    * @param id ${table.comment!}id
    * @return ${table.comment!}展示对象${entity}VO
    */
    ${entity}VO query${entity}Detail(@Param("id") Integer id);

    /**
    * 无参查询${table.comment!}List
    * @return ${table.comment!}展示对象集合${entity}VOList
    */
    List<${entity}VO> query${entity}List();

    /**
    * 条件查询${table.comment!}List
    * @param ${(entity?substring(0))?uncap_first}DTO ${table.comment!}接收入参DTO
    * @return ${table.comment!}展示对象集合${entity}VOList
    */
    List<${entity}VO> queryByConditions(@Param("${(entity?substring(0))?uncap_first}DTO") ${entity}DTO ${(entity?substring(0))?uncap_first}DTO);

    /**
    * 条件查询${table.comment!}Page
    * @param page 分页参数
    * @param ${(entity?substring(0))?uncap_first}DTO ${table.comment!}接收入参DTO
    * @return ${table.comment!}展示对象集合${entity}VOList
    */
    IPage<${entity}VO> queryByConditions(@Param("page")Page page, @Param("${(entity?substring(0))?uncap_first}DTO") ${entity}DTO ${(entity?substring(0))?uncap_first}DTO);

}
</#if>

