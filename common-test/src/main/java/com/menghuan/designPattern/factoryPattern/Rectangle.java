package com.menghuan.designPattern.factoryPattern;

/**
 * 矩形实现类
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw a rectangle.");
    }

    @Override
    public void wipe() {
        System.out.println("Wipe a rectangle.");
    }

    @Override
    public void copy() {
        System.out.println("Copy a rectangle.");
    }

}
