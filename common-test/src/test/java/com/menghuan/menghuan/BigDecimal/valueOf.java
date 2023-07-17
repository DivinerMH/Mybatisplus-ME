package java.com.menghuan.menghuan.BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;

public class valueOf {

    @Test
    public void xxx(){

        BigDecimal bigDecimal = new BigDecimal(10000);

        System.out.println(bigDecimal);

        BigDecimal bigDecimal1 = BigDecimal.valueOf(20000);

        System.out.println(bigDecimal1);
    }
}
