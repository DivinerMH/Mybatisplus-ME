package com.menghuan.designPattern.factoryPattern;

import lombok.Builder;

/**
 * 矩形 - 工厂
 */
@Builder
public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
