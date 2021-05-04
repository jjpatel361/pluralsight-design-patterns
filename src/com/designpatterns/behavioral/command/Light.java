package com.designpatterns.behavioral.command;

public class Light {
    private String lightLocation;
    private boolean isOn;

    public Light(String lightLocation) {
        this.lightLocation = lightLocation;
        this.isOn = false; // default state is false;
    }

    public boolean turnOn() {
        System.out.printf("Turning [ON] light %s \n", this.lightLocation);
        this.isOn = true;
        return true;
    }

    public String getName() {
        return lightLocation;
    }

    public boolean turnOff() {
        System.out.printf("Turning [OFF] light %s \n", this.lightLocation);
        this.isOn = false;
        return false;
    }

}
