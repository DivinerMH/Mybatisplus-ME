package java.com.menghuan.menghuan.initialization;

/**
 * @Author: menghuan
 * @Date: 2021/1/27 14:39
 */
public class StaticCodeTest {

    // 静态代码块
    static {
        System.out.print(" 静态代码块！ -->");
    }

    /**
     *  区别两次 new 静态与非静态代码块执行情况
     */
    public static void  main(String[] args) {
        System.out.println(" main 函数 ");
        System.out.println("================================================================================================");

        StaticCode c1 =  new  StaticCode();
        c1.test();

        System.out.println("================================================================================================");

        StaticCode c2 =  new  StaticCode();
        c2.test();

        System.out.println("=========================== static 静态代码块 随类加载而执行，且只执行一次 =========================");
    }

}
