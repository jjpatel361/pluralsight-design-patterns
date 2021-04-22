package com.designpatterns.singleton;

public class SingletonResource {

    // e.g. of premature initialization
    // private static SingletonResource instance = new SingletonResource();

    // e.g of lazily loading the resource.
    // you set it null and the object is created in memory only when
    // you actually call getInstance. This is particularly helpful for
    // cases like DB connections / websockets etc.
    private static SingletonResource instance = null;

    private SingletonResource() {

    }

    public static SingletonResource getInstance() {
        if(instance == null) {
            System.out.println("Creating new resource");
            instance = new SingletonResource();
        } else {
            System.out.println("Not creating resource");
        }
        return instance;
    }
}
