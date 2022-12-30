package com.designpatterns.builder;

public class SaladBuilderDemo {
    /**
     * Here we will use Builder Pattern. the builder gives similar effect
     * to telescoping constructors without the disadvantage of too many
     * constructors.
     */

    public static void main(String[] args) {

        /**
         * Observations
         * immutability
         * - once the salad is toss() we can only eat() salad, so we have fixed immutability.
         * you cannot modify the salad ingredients once it is toss()
         *
         * Telescoping constructor
         * - one builder constructor so more need for telescoping
         *
         * We can also safely enforce dependency
         * e.g. SpecialSaladBuilder takes in base as constructor argument.
         * So you cannot make SaladBuilder without a base, and thus you enforced
         * Salad object cannot be prepped without base.
         *
         * SpecialSalad constructor argument is actually a builder
         * you can optionally create a constructor with all arguments
         * this would keep a back door open on creating SpecialSalad object without the builder.
         *
         * the toss() method is unique. It returns the built object.
         * there can be only one such method in a builder pattern
         * if you have more than one method returning build object you are probably doing it wrong.
         * */
        SpecialSaladBuilder sb = new SpecialSaladBuilder();
        SpecialSalad salad = sb.base("Chickpeas").dressing("Ranch").base("Tomatoes").dressing("Yogurt")
                .protein("Ham").protein("Tofu").toss();
        salad.eat();
    }


}
