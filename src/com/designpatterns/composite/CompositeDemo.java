package com.designpatterns.composite;

public class CompositeDemo {

    public static void main(String[] args) {

        /*
        * composite pattern is a structural pattern
        * not to be confused with composition
        *
        * - good for designing hierarchy systems
        * - see how Menu and MenuItem both are extending single abstract class and still hierarchy
        * - print core functionality is still under parent MenuComponent
        * - while the menu and menu items are just overriding toString methods.
        *
        *
        * */
        Menu mainMenu = new Menu("Main", "/main");

        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");
        mainMenu.addComponent(safetyMenuItem);

        MenuItem claimsMenuItem = new MenuItem("Claims", "/claims");
        mainMenu.addComponent(claimsMenuItem);

        MenuItem personalClaimMenu = new MenuItem("Personal Claim", "/personalclaim");
        mainMenu.addComponent(personalClaimMenu);

        System.out.println(mainMenu.toString());

    }
}
