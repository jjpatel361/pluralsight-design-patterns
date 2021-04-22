package com.designpatterns.prototype;

public class PrototypeDemo {

    public static void main(String[] args) {
        /*
         * prototype pattern is used to
         * create unique instances / clones of objects without going through heavy construction
         * idea is to create clones for existing objects and returning them
         * two types of clone / copy
         *  - Shallow - returns new object keeping the references of inner objects
         *  - Deep - entirely recreating objects
         *  e.g. Movies object has List<Actors>
         *      - shallow copy of movies object will return the reference to List
         *      - deep copy of movies will create a new array list and copy all items from movies
         * */

        Registry registry = new Registry();

        /*
        * observations
        *
        * imagine Movie and Book object creation is a heavy process
        * you don't want to go through constructor calls each time
        * if only small thing is changing then maybe we can clone and change that item.
         * e.g.
        * a Statement object that just changes parameters you don't have to
        * create a new Statement object entirely. you can clone the existing statement
        * and change parameters. just like we cloned a movie object and changed the title
        * the price and other parameters are unchanged.
        * */

        /*
        * summary
        * - guarantee fresh instance every time
        * - can help with performance improvement
        * - refactored in later not when writing first time.
        * - Don't think of factory vs prototype both are solving different problems.
        *
        * prototype - hey this object instantiation is very memory intensive can I reuse this ?
        * factory - hey object creation is tedious let factory create the object and give it to me
        *
        * */

        Movie m = (Movie) registry.createItem("movie");
        m.setTitle("Planet of the Apes");
        System.out.println(m);

        Movie m2 = (Movie) registry.createItem("movie");
        System.out.println(m2.hashCode());
        System.out.println(m.hashCode());

        Book b = (Book) registry.createItem("book");
        b.setTitle("Sex at Dawn");

        System.out.println(b);

        /*
        * how is this different then factory pattern ?
        * the method signature of a factory is pretty similar.
        * where you have a registry and pass in a key that returns the specific object.
        *
        * Factory returns a concrete class where as prototype returns a clone.
        * Factory always creates a fresh instance and prototype basically copies (either shallow or deep)
        * Factory deals with multiple constructors, Prototype is lightweight construction since you only do it once
        * latter parts is just cloning. .
        *
        *
        * */

    }
}
