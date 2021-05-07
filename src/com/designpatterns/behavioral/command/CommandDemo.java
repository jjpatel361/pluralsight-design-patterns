package com.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandDemo {

    public static void main(String[] args) {

        /*
         * Command pattern is a behavioral pattern
         * there are 3 participants
         * Invoker - the client
         * Receiver - these can be >= 1
         * Command Handler - the object that receives request and handles all the receiver states
         *
         * Think of the example of smart switch board
         * a collection of light bulbs are handled by command
         * and switch board uses commands to change the state of the lights
         * and not directly maintains it.
         * Each command is a unique class that knows how to change the underlying lights
         * TurnOffAllLights, BedTimeCommand etc. this gives nicely decoupling
         * of invoker and sinks (Lights)
         *
         *
         * How to make Command Pattern ?
         * - Command interface and each command is a concrete class
         * - Each command handles state of the underlying objects
         * - the command is given to the invoker / client and invoker has no idea about sinks (lights)
         *
         * Pitfalls
         * - dependence on other patterns
         * - we need prototype to create copies of command ?
         *
         * */

        Light kitchenLight = new Light("kitchen");
        Light bedLight = new Light("bed");
        Light bathroom = new Light("bathroom");

        // think of VoiceSwitchBoard, you issue a command "SHUT" and it does some business logic and issues
        // correct commands to underlying network of IoT devices
        SwitchBoard board = new SwitchBoard();
        List<Light> allRoomLights = Arrays.asList(kitchenLight, bedLight, bathroom);

        Command bedTimeCommand = new BedTimeCommand(allRoomLights);
        Command turnOffAll = new TurnOffAllCommand(allRoomLights);

        // board.execute(bedTimeCommand);
        board.execute(turnOffAll);

    }
}
