package ${package.Controller};

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??> import ${superControllerClassPackage};
</#if>

/**
* ${table.comment!} 前端控制器
* @author ${author}
* @since ${date}
* @version v1.0
*/
@Slf4j
<#if restControllerStyle>
    @Api(tags = {"${table.comment!}"})
    @RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(value = "${table.entityPath}", tags = "${table.comment!} 模块")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>


    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    /**
    * 分页条件查询${table.comment!}列表
    */
    @ApiOperation(value = "分页条件查询${table.comment!}列表")
    @RequestMapping(value = "/lists/conditions")
    public String queryPageByConditions(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
        // return ${(table.serviceName?substring(1))?uncap_first}.queryPageByConditions();
        return null;
    }


    /**
    * 根据id查询
    * @author ${author}
    * @since ${date}
    */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById")
    public String getById(@RequestParam("pkid") String pkid){
    return null;
    }

    /**
    * 新增
    * @author ${author}
    * @since ${date}
    */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody ${entity} ${entity?uncap_first}){
    return null;
    }

    /**
    * 删除
    * @author ${author}
    * @since ${date}
    */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del")
    public String delete(@RequestParam("ids") List<String> ids){
    return null;
    }

    /**
    * 修改
    * @author ${author}
    * @since ${date}
    */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody ${entity} ${entity?uncap_first}){
    return null;
    }

    }
</#if>