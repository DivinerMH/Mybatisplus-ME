    package com.menghuan.codeTest_2020_07;

    import org.junit.jupiter.api.Test;

    import java.text.SimpleDateFormat;
    import java.util.Date;

    /**
    * @Author: menghuan
    * @Date: 2020/8/13 21:34
    */
    public class ITest {

    static Integer i = 2;

    public static long fromDateStringToLong(String inVal) {
        Date date = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        try {
            date = inputFormat.parse(inVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    @Test
    public void gugu(){
        if(1 == i){
            System.out.println("大佬咕咕，天下无敌");
        }else{
            System.out.println("咕咕：“我要戒糖，明天起戒糖、锻炼”");
            for (int i1 = 0; i1 < 1000000; i1++) {
                System.out.println("华灯第" + i1 + "次说：“不，你要多吃，长肉肉...”");
                if(1222222 == i1){
                    System.out.println("华灯第" + i1 + "次说：“好吧，大佬咕咕，天下无敌”");
                    break;
                }

            }
        }
    }

    @Test
    public void xiannv(){
        //获取当前时间为开始时间，转换为long型
        long startTime =fromDateStringToLong(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date()));

        if(1 == i){
            System.out.println("大佬咕咕，天下无敌");
        }else{
            for (int i1 = 0; i1 < 1000000; i1++) {
                System.out.println("华灯第" + i1 + "次说：“群里的小姐姐，都是仙女哎”");
                if(1222222 == i1){
                    System.out.println("华灯第" + i1 + "次说：“好吧，大佬咕咕，天下无敌”");
                    break;
                }
            }
        }
        //获取当前时间为截止时间，转换为long型
        long stopTime = fromDateStringToLong(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(new Date()));

        //计算时间差,单位毫秒
        long timeSpan = stopTime - startTime;
        System.out.println("颤抖吧，用时" + timeSpan/1000 + "s");
    }


    }
