package com.designpatterns.factory;

import static java.lang.System.*;

public class FactoryDemo {

    public static void main(String[] args) {

        /*
        * factory simplifies object creation
        * if you want to get different types of object
        * depending on some condition factory is best suited for this
        *
        * important to understand the object creation still lies inside
        * the main object. factory just takes the argument
        * and calls the object depending on value. the object takes care
        * of setup.
        * in this case createParts method in each class takes care of object
        * initialization
        *
        * for factories to work you'll always see interfaces/abstract classes
        * and optionally enums. Using enum is preferred.
        *
        * summary
        * - parameter driven
        * - complex creation
        * - returns multiple instances of object
        *
        * */
        Car electricCar = CarFactory.getCar(CarType.ELECTRIC);
        Car dieselCar = CarFactory.getCar(CarType.DIESEL);

        out.println(electricCar);
        out.println(electricCar.getParts());
        out.println(dieselCar);
        out.println(dieselCar.getParts());

    }

}

