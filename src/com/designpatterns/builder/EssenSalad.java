package com.designpatterns.builder;

import java.util.ArrayList;

public class EssenSalad {

    // we will use telescoping constructors here to
    // make get immutability.
    // create constructors for all possible inputs
    // and make them call each other.
    private String base;
    private ArrayList<String> proteins;
    private ArrayList<String> dressings;

    public EssenSalad(String base) {
        this.base = base;
        this.proteins = new ArrayList<>();
    }

    // build all constructors that we need
    // constructor with base and proteins and no dressing
    public EssenSalad(String base, ArrayList<String> proteins) {
        this(base);
        this.proteins = proteins;
    }

    //  a constructor with base, proteins and dressings.
    public EssenSalad(String base, ArrayList<String> proteins, ArrayList<String> dressings) {
        this(base);
        this.dressings = dressings;
    }

    public void toss() {
        System.out.println("Salad is prepped. You cannot undo this");
    }

}
