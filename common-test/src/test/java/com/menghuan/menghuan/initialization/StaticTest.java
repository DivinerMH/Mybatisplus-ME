package java.com.menghuan.menghuan.initialization;

/**
 * @Author: menghuan
 * @Date: 2021/2/2 9:35
 */
public class StaticTest {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        /*
         * 静态代码块【常用】
         * 1.在类中方法外出现，并加上static修饰；
         * 2.用于给类进行初始化，在加载的时候就执行，并且只执行一次。
         * 3.一般用于加载驱动
         */
        Student stu1 = new Student("jsh", "java班");
        Student stu2 = new Student("dff", "javabean");

    }

}

class Student {
    String name;
    String classname;

    //静态
    static String country;

    /*
     * 静态代码块作用
     * 1.用于给类进行初始化，初始化就是给属性赋值
     * 2.一般用于加载mysql驱动
     * 3.如果有一段代码从始至终，只运行一次，可以写到静态代码块
     */
    //静态代码块
    static {
        //静态只能访问静态
        country = "中国";
        System.out.println("静态代码块");
    }

    public Student(String name, String classname) {
        System.out.println("构造方法..." + name);
        this.name = name;
        this.classname = classname;
    }


}

