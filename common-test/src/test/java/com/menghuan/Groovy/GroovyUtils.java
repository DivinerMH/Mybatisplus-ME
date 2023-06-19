package com.menghuan.Groovy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GroovyUtils {

    public static String runGroovyScript(String script, String funName, Object[] params) throws Exception{
        if (script == null || "".equals(script)){
            throw new RuntimeException("方法runGroovyScript无法执行，传入的脚本为空");
        }
        Object object = new Object ();
        // Java 和 Js 之间的调用时,基于ScriptEngineManager类
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        // log.info("script:" + script);
        // 执行这段script脚本（提示：这块未引入依赖包的情况下，会报空指针异常）
        engine.eval(script);
        // javax.script.Invocable 是一个可选的接口
        // 检查你的 script engine 接口是否已实现!
        // 注意：JavaScript engine实现了Invocable接口
        Invocable inv = (Invocable) engine;
        // 执行obj对象的【名为：funName ,参数为：params】的方法
        object =  inv.invokeFunction(funName, params);

        Map map = JSONObject.parseObject (JSONObject.toJSONString (object),HashMap.class);
        String res =String.valueOf (map.get ("values"));
        JSONArray jsonArray = JSONObject.parseArray (String.valueOf (map.get ("values")));
        return jsonArray.size () > 0 ? jsonArray.get (0) + "" : res;
    }

    public static String runGroovyScriptJson(String script, String funName, Object[] params) throws Exception{
        if (script == null || "".equals(script)){
            throw new RuntimeException("方法runGroovyScript无法执行，传入的脚本为空");
        }
        Object object = new Object ();
        // Java和Js之间的调用时基于ScriptEngineManager类
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        log.info("script:" + script);
        //执行这段script脚本（提示：这块未引入依赖包的情况下，会报空指针异常）
        engine.eval(script);
        // javax.script.Invocable 是一个可选的接口
        // 检查你的 script engine 接口是否已实现!
        // 注意：JavaScript engine实现了Invocable接口
        Invocable inv = (Invocable) engine;
        // 执行obj对象的【名为：funName ,参数为：params】的方法
        object =  inv.invokeFunction(funName, params);

        Map map = JSONObject.parseObject (JSONObject.toJSONString (object),HashMap.class);
        String res =String.valueOf (map.get ("values"));
        JSONArray jsonArray = JSONObject.parseArray (String.valueOf (map.get ("values")));
        return jsonArray.size () > 0 ? jsonArray.get (0) + "" : res;
    }


    public static Object runGroovyScriptObject(String script, String funName, Object[] params) throws Exception{
        if (script == null || "".equals(script)){
            throw new RuntimeException("方法runGroovyScript无法执行，传入的脚本为空");
        }
        Object object = new Object ();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        engine.eval(script);
        Invocable inv = (Invocable) engine;
        object =  inv.invokeFunction(funName, params);
        Map map = JSONObject.parseObject (JSONObject.toJSONString (object),HashMap.class);
        String res =String.valueOf (map.get ("values"));
        JSONArray jsonArray = JSONObject.parseArray (String.valueOf (map.get ("values")));
        return jsonArray.size () > 0 ? jsonArray.get(0) : res;
    }

}
