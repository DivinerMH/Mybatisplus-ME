package com.menghuan.designPattern.factoryPattern;

import lombok.Builder;

/**
 * 圆形 - 工厂
 */
@Builder
public class CircleFactory implements ShapeFactory {

    @Override
    public Shape createShape() {
        return new Circle();
    }

}