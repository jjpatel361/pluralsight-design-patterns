package com.designpatterns.flyweight;

public class FlyWeightDemo {

    public static void main(String[] args) {

        /*
        * primarily used for memory efficiency.
        * say you are using an object and doing new () / creating a new instance
        * across your code path. we cna be smart about the creation and cache
        * the old values and see if we can reuse them.
        *
        * caveats
        * - premature optimization ? maybe
        * - pattern inside a pattern uses factory pattern as sub part
        * - all good examples are `valueOf` method
        * */

        Integer intA = Integer.valueOf(25);
        Integer intB = Integer.valueOf(25);
        Integer intC = Integer.valueOf(26);

        // the hash codes of A and B are same! we re used the integer instance.
        // this is different than singleton where we don't really cache all objects created
        // for intC the integer.valueOf actually created a new integer as cache miss
        System.out.printf("Integer A hashCode %s \n", System.identityHashCode(intA));
        System.out.printf("Integer B hashCode %s \n", System.identityHashCode(intB));
        System.out.printf("Integer C hashCode %s \n", System.identityHashCode(intC));



    }
}
