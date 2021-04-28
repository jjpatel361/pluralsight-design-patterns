package com.designpatterns.decorator;

public abstract class ShapeDecorator implements Shape {
    public Shape decoratedShape;

    public ShapeDecorator(Shape shape) {
        super();
        this.decoratedShape = shape;
    }
}
