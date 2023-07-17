package java.com.menghuan.test_I.codeTest_2021_06;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * TypeConverter 转换工具类
 *      1、String Date Timestamp 三种日期格式的转换 https://blog.csdn.net/u010124396/article/details/8920930
 * @Author: menghuan
 * @Date: 2021/6/30 11:13
 */
public class TypeConverter {

    private static Pattern linePattern = Pattern.compile("_([a-z])");

    private static Pattern humpPattern = Pattern.compile("\\B(\\p{Upper})(\\p{Lower}*)");

    /**
     * 将Date转换为String类型
     * 提示：Object类中为我们提供了toString方法，然而该方法对Date类进行转换时，往往达不到我们想要的效果
     * @param var 入参
     * @return
     */
    public static String dateToString(Date var){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(var);
    }

    /**
     * 将String转换为Date类型
     * @param var 时间字符串
     * @return
     */
    public static Date stringToDate(String var){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //使用SimpleDateFormat的parse()方法生成Date
            Date date = sf.parse(var);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将Timestamp转换为指定格式的String
     * @param var 时间戳
     * @return
     */
    public static String timestampToTimestampString(Timestamp var){
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//定义日期显示格式
        return df.format(var);
    }

    /**
     * 将String转换为指定格式的Timestamp
     * @param var 字符串，格式必须为："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static Timestamp timestampStringToTimestamp(String var){
        Timestamp t_time = Timestamp.valueOf(var);
        // String-->Timestamp:2010-08-08 06:06:06.0
        // System.out.println("String-->Timestamp:"+t_time);
        return t_time;
    }

    /**
     * 实体对象转成Map
     *
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        @SuppressWarnings("rawtypes")
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Map转成实体对象
     *
     * @param map   map实体对象包含属性
     * @param clazz 实体对象类型
     * @return
     */
    public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    /**
     * 驼峰转下划线(Map)
     *
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        Map<String, Object> map = JSONObject.parseObject(str);
        Map<String, Object> newMap = Maps.newHashMap();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            StringBuffer sb = new StringBuffer();
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            Matcher matcher = humpPattern.matcher(key);
            while (matcher.find()) {
                matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            }
            matcher.appendTail(sb);
            newMap.put(sb.toString(), entry.getValue());
        }
        return JSON.toJSONString(newMap);

    }

    /**
     * 驼峰转下划线(List)
     *
     * @param str
     * @return
     */
    @SuppressWarnings("all")
    public static String humpToLineList(String str) {
        List<Map> list = JSONObject.parseArray(str, Map.class);
        List<Map<String, Object>> res = new ArrayList<>();
        list.stream().forEach(p -> {
            Map<String, Object> newMap = Maps.newHashMap();
            Iterator<Map.Entry<String, Object>> it = p.entrySet().iterator();
            while (it.hasNext()) {
                StringBuffer sb = new StringBuffer();
                Map.Entry<String, Object> entry = it.next();
                String key = entry.getKey();
                Matcher matcher = humpPattern.matcher(key);
                while (matcher.find()) {
                    matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
                }
                matcher.appendTail(sb);
                newMap.put(sb.toString(), entry.getValue());
            }
            res.add(newMap);
        });
        return JSON.toJSONString(res);
    }

}
