package com.designpatterns.factory;

import java.util.ArrayList;

public class DieselCar extends Car {

    @Override
    public void createParts() {
        this.carParts.add("Diesel Engine");
        this.carParts.add("Headlights");
        this.carParts.add("Tires");
        this.carParts.add("Exhaust");
        this.carParts.add("Fuel Tank");
    }

    @Override
    public ArrayList<String> getParts() {
        return this.carParts;
    }
}
