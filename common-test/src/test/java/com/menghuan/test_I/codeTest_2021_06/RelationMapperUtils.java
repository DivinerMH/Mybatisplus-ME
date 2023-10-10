package com.menghuan.test_I.codeTest_2021_06;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Java反射+注解实现Entity类与Dto类相互转换
 *      情景：在项目中从Dao层到Service层数据传递中通过大量的get(),set()方法去一个一个的去拿值去赋值，导致代码篇幅过长，并且严重消耗开发时间；
 *      尝试：现在大部分都是Entity类和Dto类的属性名相同的前提下，利用反射实现，太局限了，如果要改成同名，按目前项目的程度去整改工作量太大，不现实；
 *      解决：看了Spring注解的实现，然后结合找到反射实现资料，突想奇发尝试着用自定义注解+反射方式的去实现，事实证明这方法是可行的。
 * @Author: menghuan
 * @Date: 2021/6/28 14:41
 */
public class RelationMapperUtils {

    public static Object entryAndDtoMapper(Object entity, Object dto) throws Exception{
        return EnAndDtoMapper(entity, dto,true);
    }

    public static Object entryAndDtoMapper(Object entity, Object dto,boolean enToDto) throws Exception{
        return EnAndDtoMapper(entity, dto,false);
    }
    /**
     * Entity and Dto Mapper
     * @param entry
     * @param dto
     * @param enToDto
     *             ture  : Entity To Dto (defult)
     *             false : Dto To Entry
     *     Rule:
     *         实现相互转换前提: Dto field name(dto和entry的field name相同并且 类上有@RelMapper) 或 field的@RelMapper(value="Entity field name") 满足其一即可转换
     * @return
     * @throws Exception
     */
    // last version
    public static Object EnAndDtoMapper(Object entry, Object dto,boolean enToDto) throws Exception{
        if(enToDto == true ? entry == null : dto == null){ return null;}
        Class<? extends Object> entryclazz = entry.getClass();    //获取entity类
        Class<? extends Object> dtoclazz = dto.getClass();    //获取dto类
        boolean dtoExistAnno = dtoclazz.isAnnotationPresent(RelMapper.class);    //判断类上面是否有自定义注解
        Field[] dtofds = dtoclazz.getDeclaredFields();    //dto fields
        Field [] entryfds = entryclazz.getDeclaredFields();    //entity fields
        Method entrys[] = entryclazz.getDeclaredMethods();    //entity methods
        Method dtos[] = dtoclazz.getDeclaredMethods();    //dto methods
        String mName,fieldName,dtoFieldType=null,entFieldType=null,dtoMapName = null,dtoFieldName =null;Object value = null;
        for(Method m : (enToDto ? dtos : entrys)) {    //当 enToDto=true 此时是Entity转为Dto，遍历dto的属性
            if((mName=m.getName()).startsWith("set")) {    //只进set方法
                fieldName = mName.toLowerCase().charAt(3) + mName.substring(4,mName.length());  //通过set方法获得dto的属性名
                tohere:
                for(Field fd: dtofds) {
                    fd.setAccessible(true);    //setAccessible是启用和禁用访问安全检查的开关
                    if(fd.isAnnotationPresent(RelMapper.class)||dtoExistAnno){    //判断field上注解或类上面注解是否存在
                        //获取与Entity属性相匹配的映射值(两种情况：1.该field上注解的value值(Entity的field name 和Dto 的field name 不同)  2.该field本身(本身则是Entity的field name 和Dto 的field name 相同))
                        dtoMapName = fd.isAnnotationPresent(RelMapper.class) ? (fd.getAnnotation(RelMapper.class).value().toString().equals("")?fd.getName().toString():fd.getAnnotation(RelMapper.class).value().toString()):fd.getName().toString();
                        if(((enToDto ? fd.getName() : dtoMapName)).toString().equals(fieldName)) {
                            dtoFieldType = fd.getGenericType().toString().substring(fd.getGenericType().toString().lastIndexOf(".") + 1); // 获取dto属性的类型(如 private String field 结果 = String)
                            for(Field fe : entryfds) {
                                fe.setAccessible(true);
                                if(fe.getName().toString().equals(enToDto ? dtoMapName : fieldName) ) {//遍历Entity类的属性与dto属性注解中的value值匹配
                                    entFieldType = fe.getGenericType().toString().substring(fe.getGenericType().toString().lastIndexOf(".") + 1); //获取Entity类属性类型
                                    dtoFieldName = enToDto ? dtoMapName : fd.getName().toString();
                                    break tohere;
                                }
                            }
                        }
                    }
                }
                if(dtoFieldName!= null && !dtoFieldName.equals("null")) {
                    for(Method md : (enToDto ? entrys : dtos)) {
                        if(md.getName().toUpperCase().equals("GET"+dtoFieldName.toUpperCase())){
                            dtoFieldName = null;
                            if(md.invoke(enToDto ? entry : dto) == null) { break;} //去空操作
                            //Entity类field 与Dto类field类型不一致通过TypeProcessor处理转换
                            value = (entFieldType.equals(dtoFieldType))? md.invoke(enToDto ? entry : dto) :TypeProcessor(entFieldType, dtoFieldType,md.invoke(enToDto ? entry : dto),enToDto ? true : false);
                            m.invoke(enToDto ? dto : entry, value); //得到field的值 通过invoke()赋值给要转换类的对应属性
                            value = null;
                            break;
                        }
                    }
                }
            }
        }
        return enToDto ? dto : entry;
    }

    // 类型转换处理
    public static Object TypeProcessor(String entFieldType,String dtoFieldType, Object obj,boolean enToDto) {
        if(entFieldType.equals(dtoFieldType)) return obj;

        if(!entFieldType.equals(dtoFieldType)) {
            switch(entFieldType) {
                case "Date":
                    return (enToDto)?TypeConverter.dateToString((Date) obj):TypeConverter.stringToDate(obj.toString());
                case "Timestamp":
                    return TypeConverter.timestampToTimestampString((Timestamp)obj);
                case "Integer":
                    return (enToDto) ? obj.toString() : Integer.parseInt((String)obj) ;
            }
        }
        return obj;
    }


}
