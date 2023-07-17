package java.com.menghuan.menghuan.lazy;

import org.springframework.stereotype.Component;

/**
 * @Author: menghuan
 * @Date: 2021/1/29 17:45
 */
@Component
public class MyLazy {

    public MyLazy() {

        System.out.println("i am construct method of MyLazy");
    }

    public void sayHello() {

        System.out.println("hello, i am MyLazy");
    }

}
