package com.designpatterns.builder;

import java.util.ArrayList;

public class SpecialSalad {

    private String base;
    private ArrayList<String> dressings;
    private ArrayList<String> proteins;

    public SpecialSalad(SpecialSaladBuilder builder) {
        this.base = builder.getBase();
        this.proteins = builder.getProteins();
        this.dressings = builder.getDressings();
    }

    public void eat() {
        System.out.println("Salad is ready to eat. It has following contents");
        System.out.println("**** Contents ****");
        System.out.printf("Base : %s%n", this.base);
        System.out.printf("Proteins : %s%n", String.join(",", this.proteins));
        System.out.printf("Dressings : %s%n", String.join(",", this.dressings));
    }
}
