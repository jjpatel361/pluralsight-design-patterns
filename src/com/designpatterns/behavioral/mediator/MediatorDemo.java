package com.designpatterns.behavioral.mediator;

import com.designpatterns.behavioral.command.Light;

public class MediatorDemo {

    public static void main(String[] args) {

        /*
        * mediator is behavioral pattern
        * - decouple objects and use mediator object to modify state of the objects
        * - example. IoT light control of the house.
        *   - Light object states like ON or OFF are modified by a mediator
        *   - You can have a mediator for Bedroom, Bathroom
        *   - and let mediator modify the state of light / fan / locks for that room.
        *
        * Loose coupling
        * Goes nicely to be used with Command pattern
        * Simplified unidirectional pattern
        *
        * examples
        * - java util timer
        *
        * */
        System.out.println("Mediator Demo");

        LightBoard switchBoard = new LightBoard();
        Light bathroom = new Light("bathroom");
        Light bedlight = new Light("bedlight");
        Light bedWardrobeLight = new Light("wardrobe");

        switchBoard.register(bathroom);
        switchBoard.register(bedlight);
        switchBoard.register(bedWardrobeLight);

        switchBoard.sleep();


    }
}
