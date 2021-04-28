package com.designpatterns.decorator;

public class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public void resize() {
        System.out.println("Resizing Circle");
    }

    @Override
    public String description() {
        return "Circle Object";
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
