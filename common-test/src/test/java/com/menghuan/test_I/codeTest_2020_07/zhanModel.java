package java.com.menghuan.test_I.codeTest_2020_07;

import java.util.LinkedList;

/**
 * Author：Liu Zhiyong
 * Version：Version_1
 * Date：2016年7月15日15:49:42
 * Desc：
 * 1.栈：主要是用于实现堆栈数据结构的存储方式。
 * 先进后出
 * push()
 * pop()
 * 2.队列：主要是为了让你们可以使用LinkedList模拟队列数据结构的存储方式。
 * 先进先出
 * offerA()
 * poll()
 * <p>
 * 需求：使用LinkedList实现堆栈数据结构的存储方式与队列的数据结构存储方式。
 */
//使用LinkedList模拟堆栈的数据结构存储方式
class StackList {
    LinkedList list;

    public StackList() {
        list = new LinkedList();
    }

    //进栈
    public void add(Object o) {
        list.push(o);
    }

    //出栈（弹栈），把元素删除并返回
    public Object pop() {
        return list.pop();
    }

    //获取元素个数
    public int size() {
        return list.size();
    }
}

//使用LinkedList模拟队列的数据结构存储方式
class TeamList {
    LinkedList list;

    public TeamList() {
        list = new LinkedList();
    }

    public void add(Object o) {
        list.offer(o);
    }

    public Object remove() {
        return list.poll();
    }

    public int size() {
        return list.size();
    }
}

public class zhanModel {
    public static void main(String[] args) {
        TeamList list = new TeamList();
        list.add("李嘉诚");
        list.add("马云");
        list.add("王健林");
        for (int i = 0; i < list.size(); i++) {//注意这里的list.size()大小在变化。。
            System.out.println(list.remove());
        }

        while (list.size() > 0) {
            System.out.println(list.remove());
        }

//		System.out.println(list.pop());
//		System.out.println(list.pop());
//		System.out.println(list.pop());
//		System.out.println(list.pop());
    }

}
