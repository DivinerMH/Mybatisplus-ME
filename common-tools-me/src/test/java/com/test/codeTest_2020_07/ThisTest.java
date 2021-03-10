package com.test.codeTest_2020_07;

/**
 * @Author:menghuan
 * @Date:2020/7/6 9:49
 * 本示例为了说明this的三种用法！
 */
public class ThisTest {

    private int i = 0;

    //第一个构造器：有一个int型形参
    ThisTest(int i) {

        int i1 = this.i;

        this.i = i + 1; //此时this表示引用成员变量ｉ，而非函数参数ｉ

        System.out.println("Int constructor i >> this.i ====>  " + i + ">>" + this.i);

        System.out.println("(i-1):" + (i - 1) + " <====> (this.i+1):" + (this.i + 1));

        //从两个输出结果充分证明了i和this.i是不一样的！

    }


    //  第二个构造器：有一个String型形参
    ThisTest(String s) {

        System.out.println("String constructor:  " + s);

    }


    //  第三个构造器：有一个int型形参和一个String型形参
    ThisTest(int i, String s) {

        this(s);//this调用第二个构造器

        //this(i);

        /**
         此处不能用，因为其他任何方法都不能调用构造器，只有构造方法能调用他。

                 但是必须注意：就算是构造方法调用构造器，也必须为于其第一行，构造方法也只能调

                 用一个且仅一次构造器！*/

        this.i = i++;   //this以引用该类的成员变量

        System.out.println("Int constructor:  " + i + "/n" + "String constructor:  " + s);

    }

    public static void main(String[] args) {

        ThisTest tt0 = new ThisTest(10);

        ThisTest tt1 = new ThisTest("hello world");

        ThisTest tt2 = new ThisTest(20, "ok again!");


        System.out.println(tt0.increment().increment().increment().i);

        // tt0.increment()返回一个在tt0基础上ｉ++的ThisTest对象，

        // 接着又返回在上面返回的对象基础上i++的ThisTest对象！

    }

    public ThisTest increment() {

        this.i++;

        return this;    //返回的是当前的对象，该对象属于（ThisTest）

    }


}
