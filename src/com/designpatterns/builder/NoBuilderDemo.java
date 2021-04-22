package com.designpatterns.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NoBuilderDemo {

    /**
     * Builder Pattern
     *
     * - Handles complex constructors
     * - large number / variety of parameters
     * - immutability
     *      - you can also enforce immutability. After object building the caller can just use the object
     *        and not modify internal settings. Say CarBuilder returns a Car object and now you only have methods
     *        drive, park, etc. and cannot change license number etc.
     * e.g. StringBuilder, DocumentBuilder, LocalBuilder
     *
     */

    public static void main(String[] args) {

        // lets make a salad!
        Salad s = new Salad();
        s.setBase("Chickpeas");
        s.addProtein("Tofu");
        s.addDressing("Ranch");
        s.toss();

        /*
         observations
         this is called the bean model
         salad object is not immutable
         I can again call s.addProtein() after the salad is prepped.
         You can solve this problem using telescoping constructors
         */

        ArrayList<String> proteins = new ArrayList<>(Collections.singletonList("Tofu"));
        ArrayList<String> dressing = new ArrayList<>(Arrays.asList("Ranch", "Chipotle Sauce"));

        EssenSalad essenSalad1 = new EssenSalad("chickpeas", proteins);
        EssenSalad essenSalad2 = new EssenSalad("chickpeas", proteins, dressing);

        /*
         observations
         no more setters! so once the object is constructed you cannot add proteins, dressing, base etc.
         the constructors are telescopic. meaning they are composed on each other.
         we build all constructors that we need. and return the object with no setters.
         drawback being we end up with too many constructors depending on parameter combination.
        **/
        essenSalad1.toss();
        essenSalad2.toss();

    }
}
