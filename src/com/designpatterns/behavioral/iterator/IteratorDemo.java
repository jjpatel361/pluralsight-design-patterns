package com.designpatterns.behavioral.iterator;

import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args) {

        /*
        * iterator pattern falls under behavioral pattern
        *
        * - useful when underlying sequence isn't straightforward index increment
        * - think of 2 object arrays that need to be iterated in alternately
        * - iterator is helpful in that case it hides the complexity of switching
        * arrays and for client it is easy to use a simple for like loop
        * - iterators are also helpful for lazy loading look ahead like features
        * think of db records where you don't fetch the entire db objects just the ids 
        * and then use iterator to iterate over these objects.
        *
        * Example
        * java.util.Iterator
        * java.util.Enumeration
        *
        * Object interface returns iterator e.g. Container returns iterator that you can use to traverse
        *
        * 
        * */
        BikeRepository bikeRepo = new BikeRepository();
        bikeRepo.add("Fuji");
        bikeRepo.add("Scott");
        bikeRepo.add("Cervelo");

        for (String s : bikeRepo) {
            System.out.println(s);
        }
    }
}
