package com.designpatterns.behavioral.command;

public class SwitchBoard {

    public void execute(Command command) {
        command.execute();

    }
}
