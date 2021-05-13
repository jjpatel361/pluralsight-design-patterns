package com.designpatterns.behavioral.mediator;

import com.designpatterns.behavioral.command.Light;

import java.util.ArrayList;

public class LightBoard {

    private ArrayList<Light> lights;

    public LightBoard() {
        lights = new ArrayList<Light>();
    }


    public void register(Light light) {
        lights.add(light);
    }

    /**
     * Turns off all lights in room except bedlight
     */
    public void sleep() {
        lights.forEach(light -> {
            if(!"bedlight".equals(light.getName())) {
                light.turnOff();
            }
        });
    }
}
