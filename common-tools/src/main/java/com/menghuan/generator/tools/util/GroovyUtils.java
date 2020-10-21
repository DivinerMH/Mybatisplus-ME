package com.menghuan.generator.tools.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;


public class GroovyUtils {

    public static String runGroovyScript(String script, String funName, Object[] params) throws Exception{
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
        return jsonArray.size ()>0?jsonArray.get (0)+"":res;
    }


//    public static void main(String[] args) {
//        String groovyRegexScript =
//                "import java.util.regex.Matcher\n" +
//                        "import java.util.regex.Pattern\n" +
//                        "def validate(s1) {\n" +
//                        "    Pattern pattern = Pattern.compile(\"[0-9]*\")\n" +
//                        "    Matcher isNum = pattern.matcher(s1);\n" +
//                        "    def vvv = isNum.matches();\n" +
//                        "    return \"$vvv\"\n" +
//                        "}";
//        String hasParamshttpTest = "import com.alibaba.fastjson.JSON\n" +
//                        "def toPost(uuu,data){\n" +
//                        "        def url = new URL(uuu)\n" +
//                        "        def conn = url.openConnection()\n" +
//                        "        conn.setRequestMethod(\"POST\")\n" +
//                        "        conn.setRequestProperty(\"Content-Type\", \"application/json\")\n" +
//                        "        conn.doOutput = true\n" +
//                        "        def writer = new OutputStreamWriter(conn.outputStream)\n" +
//                        "        writer.write(data)\n" +
//                        "        writer.flush()\n" +
//                        "        writer.close()\n" +
//                        "        conn.connect()\n" +
//                        "        def code = conn.getResponseCode()\n" +
//                        "        def dd = conn.content.text\n" +
//                        "        return \"$dd\"\n" +
//                        "    }";
//
//        String notParamshttpTest = "import com.alibaba.fastjson.JSON\n" +
//                "def toDo(){\n" +
//                "        def url = new URL(\"http://192.168.1.174:999/protocol/dict/get/delFlag\")\n" +
//                "        def conn = url.openConnection()\n" +
//                "        conn.setRequestMethod(\"POST\")\n" +
//                "        conn.setRequestProperty(\"Content-Type\", \"application/json\")\n" +
//                "        conn.doOutput = true\n" +
//                "        def writer = new OutputStreamWriter(conn.outputStream)\n" +
//                "        writer.write(data)\n" +
//                "        writer.flush()\n" +
//                "        writer.close()\n" +
//                "        conn.connect()\n" +
//                "        def code = conn.getResponseCode()\n" +
//                "        def dd = conn.content.text\n" +
//                "        return \"$dd\"\n" +
//                "    }";
////        GroovyController groovy = new GroovyController ();
////        groovy.getScriptEngineFactoryList();
//        Map<String, Object> params = new HashMap<String, Object> ();
//        Object res1 = GroovyUtils.runGroovyScript(hasParamshttpTest, "toDo", new String[] { "http://192.168.1.174:999/protocol/dict/get/delFlag","{\"delFlag\":\"1\"}"});
//        System.out.println(res1);
////
////        Object res3 = groovy.runGroovyScriptByFile(null, "hello.groovy", "hello", new String[] { "param3", "param4" });
////        System.out.println(res3);
//
//    }
}
