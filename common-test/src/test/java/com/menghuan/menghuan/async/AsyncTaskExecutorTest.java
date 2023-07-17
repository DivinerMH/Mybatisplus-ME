package java.com.menghuan.menghuan.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: menghuan
 * @Date: 2021/11/18 14:53
 */
public class AsyncTaskExecutorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigurationStart.class);
        AsyncMethod asyncMethod = ac.getBean(AsyncMethod.class);
        System.out.println(asyncMethod.getClass());
        System.out.println("--------" + Thread.currentThread().getName() + "--------");
        asyncMethod.log();
        asyncMethod.log2();
        // asyncMethod.log3();
    }

}

