package com.designpatterns.behavioral.command;

import java.util.List;

public class BedTimeCommand implements Command {

    List<Light> allLights;

    public BedTimeCommand(List<Light> allRoomLights) {
        this.allLights = allRoomLights;
    }

    @Override
    public void execute() {
        // turn off all lights and except bed
        allLights.stream()
                .filter(light -> !"bed".equalsIgnoreCase(light.getName()))
                .forEach(light -> light.turnOff());

        allLights.stream()
                .filter(light -> "bed".equalsIgnoreCase(light.getName()))
                .findFirst().ifPresent(light -> light.turnOn());

    }
}
