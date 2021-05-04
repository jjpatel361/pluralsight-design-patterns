package com.designpatterns.behavioral.command;

import java.util.List;

public class TurnOffAllCommand implements Command {

    List<Light> allLights;

    public TurnOffAllCommand(List<Light> allRoomLights) {
        this.allLights = allRoomLights;
    }


    @Override
    public void execute() {
        this.allLights.stream().forEach(light -> light.turnOff());
    }
}
