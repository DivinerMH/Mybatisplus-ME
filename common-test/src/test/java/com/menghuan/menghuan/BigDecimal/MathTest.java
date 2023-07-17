package java.com.menghuan.menghuan.BigDecimal;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2021/12/27 15:18
 */
public class MathTest {

    @Test
    public void xxx(){

        double[] array = new double[10];

        for (int i = 0; i < 10; i++) {
            array[i] = Math.random();
        }

        System.out.println(array.toString());


    }

    @Test
    public void mathTest(){

        int max = Math.max(2, 12);

        System.out.println("max:" + max);

        System.out.println("Math.random()*100 随机数 ：" + (int) (Math.random()*100));

    }
}
