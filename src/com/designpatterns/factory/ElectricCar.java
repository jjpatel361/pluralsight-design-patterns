package com.designpatterns.factory;

import java.util.ArrayList;

public class ElectricCar extends Car {

    @Override
    public void createParts() {
        this.carParts.add("Electric Engine");
        this.carParts.add("Headlights");
        this.carParts.add("Tires");
        this.carParts.add("Battery");
    }

    @Override
    public ArrayList<String> getParts() {
        return this.carParts;
    }
}
