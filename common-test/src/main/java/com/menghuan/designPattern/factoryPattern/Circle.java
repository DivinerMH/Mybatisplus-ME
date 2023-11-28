package com.menghuan.designPattern.factoryPattern;

/**
 * 园形实现类
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw a circle.");
    }

    @Override
    public void wipe() {
        System.out.println("Wipe a circle.");
    }

    @Override
    public void copy() {
        System.out.println("Copy a circle.");
    }

}
