package com.designpatterns.decorator;

public class BorderColorDecorator extends ShapeDecorator {

    private LineStyle lineStyle;

    public BorderColorDecorator(Shape shape, LineStyle style) {
        super(shape);
        this.lineStyle = style;
    }


    @Override
    public void draw() {
        decoratedShape.draw();
    }

    @Override
    public void resize() {

    }

    @Override
    public String description() {
        return decoratedShape.description() + " border_color " + lineStyle;
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
