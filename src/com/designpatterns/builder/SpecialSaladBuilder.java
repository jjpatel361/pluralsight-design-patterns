package com.designpatterns.builder;

import java.util.ArrayList;

public class SpecialSaladBuilder {

    // private vars will be equal to more than
    // the built object.
    private final ArrayList<String> dressings;
    private final ArrayList<String> proteins;
    private String base;

    /**
     * we can also create a strong dependency of SaladBuilder.
     * Say we want to enforce you cannot create salad object
     * without a base. so SaladBuilder constructor can take base as parameter
     * thereby enforcing the above condition. :)
     */
    public SpecialSaladBuilder() {
        this.dressings = new ArrayList<>();
        this.proteins = new ArrayList<>();
    }

    public SpecialSaladBuilder base(String saladBase) {
        this.base = saladBase;
        // the line above is very important thing about builders
        // they return a self object till the point where you can make changes
        // after the build method the return object is not the builder but the
        // built object itself
        return this;
    }

    public SpecialSaladBuilder dressing(String dressing) {
        this.dressings.add(dressing);
        return this;
    }

    public SpecialSaladBuilder protein(String protein) {
        this.proteins.add(protein);
        return this;
    }

    public SpecialSalad toss() {
        return new SpecialSalad(this);
    }

    public String getBase() {
        return base;
    }

    public ArrayList<String> getDressings() {
        return dressings;
    }

    public ArrayList<String> getProteins() {
        return proteins;
    }
}

