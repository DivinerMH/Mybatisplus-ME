package java.com.menghuan.menghuan.stringJSON;

import org.junit.Test;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @Author: menghuan
 * @Date: 2021/8/13 17:40
 */
public class StringJoinerTest {

    /**
     * 原有的stringbuilder太死板，不支持分割，如果想让最终的字符串以逗号隔开，需要这样写
     */
    @Test
    public void xxxOne(){
        StringBuilder sb = new StringBuilder();
        IntStream.range(1,10).forEach(i->{
            sb.append(i+"");
            if( i < 10){
                sb.append(",");
            }
        });
        System.out.println(sb);
    }

    /**
     * StringJoiner
     */
    @Test
    public void xxxTwo(){
        StringJoiner sj = new StringJoiner(",");
        IntStream.range(1,10).forEach(i->sj.add(i+""));
        System.out.println(sj);
    }

    /**
     * StringJoiner 拼接
     */
    @Test
    public void xxxThree(){
        String str = "1234567890";
        // StringJoiner sj = new StringJoiner(",");
        StringJoiner sj = new StringJoiner("-");
        sj.add(str);
        sj.add("KK");
        sj.add("2021.08.13");
        System.out.println(sj);
    }

    /**
     * StringJoiner 拼接
     */
    @Test
    public void xxxFour(){
        String str = "1234567890";
        StringJoiner sj = new StringJoiner(",","hello world-","-end...");
        sj.add(str);
        sj.add("KK");
        sj.add("2021.08.13");
        System.out.println(sj);
    }
}
