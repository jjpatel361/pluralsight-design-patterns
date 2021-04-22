package com.designpatterns.factory;

import java.util.ArrayList;

public abstract class Car {

    protected ArrayList<String> carParts = new ArrayList<>();

    public Car () {
        this.createParts();
    }
    public abstract void createParts();

    public abstract ArrayList<String> getParts();
}

