package com.designpatterns.factory;

public class CarFactory {

    public static Car getCar(CarType carType) {
        return switch (carType) {
            case ELECTRIC -> new ElectricCar();
            case DIESEL -> new DieselCar();
            default -> null;
        };
    };
}
