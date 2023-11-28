package com.menghuan.designPattern.factoryPattern;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * 工厂模式 - 测试
 */
public class testContorller {

    public static void main(String[] args) {
        RectangleFactory factory = RectangleFactory.builder().build();
        Shape shape = factory.createShape();
        assertNotNull(shape);
        shape.wipe();
    }

    @Test
    public void testOne(){
        CircleFactory factory = CircleFactory.builder().build();
        Shape shape = factory.createShape();
        assertNotNull(shape);
        shape.wipe();
    }

}
