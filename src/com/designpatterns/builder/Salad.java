package com.designpatterns.builder;

import java.util.ArrayList;

public class Salad {

    private String base;
    private ArrayList<String> proteins;
    private ArrayList<String> dressings;

    public Salad() {
        this.dressings = new ArrayList<>();
        this.proteins = new ArrayList<>();
        this.base = null;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void addProtein(String protein) {
        this.proteins.add(protein);
    }

    public void addDressing(String dressing) {
        this.dressings.add(dressing);
    }

    public void toss() {
        System.out.println("Salad is prepped and now you can't do anything");
    }
}
