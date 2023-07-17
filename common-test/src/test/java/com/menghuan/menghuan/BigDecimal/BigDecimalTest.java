package java.com.menghuan.menghuan.BigDecimal;

import org.junit.Test;
import java.math.BigDecimal;

/**
 * 参考：
 *      https://blog.csdn.net/wjw_de_java/article/details/110096491
 * @Author: menghuan
 * @Date: 2021/12/27 15:17
 */
public class BigDecimalTest {

    @Test
    public void maxSubtractMin(){

        BigDecimal num1 = new BigDecimal("22");
        BigDecimal num2 = new BigDecimal("17");
        BigDecimal num3 = new BigDecimal("51");
        // BigDecimal[] array = {num1,num2,num3};
        BigDecimal[] array = new BigDecimal[3];
        array[0] = num1;
        array[1] = num2;
        array[2] = num3;

        BigDecimal max = array[0],min = array[0];

        // 获取最大值
        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(max) > 0){
                max=array[i];
            }
        }
        System.out.println("max:" + max);

        // 获取最小值
        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(min) < 0){
                min=array[i];
            }
        }
        System.out.println("min:" + min);

        // (max/min)-1 是否大于百分之二十
        if((max.divide(min)).subtract(new BigDecimal(1)).compareTo(new BigDecimal(0.2)) == 1){
            System.out.println("(max/min)-1 是否大于百分之二十 : true");

        }else {
            System.out.println("(max/min)-1 是否大于百分之二十 : false");
        }
    }



}
