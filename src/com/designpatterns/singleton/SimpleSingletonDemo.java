package com.designpatterns.singleton;

public class SimpleSingletonDemo {
    /**
     * singleton are objects that are static in nature - not to confused with static keyword in java
     * - Have no input parameters in constructor
     * - Private constructor and private instance.
     * - you usually do it via a method .getInstance()
     * - If you are holding state then make sure it is threadsafe
     *    - e.g. say a counter of records processed you want the singleton to hold the correct count for all threads
     *    - all threads can safely update the counter value
     *
     * Disadvantages
     * - over used
     * - slows down application if too many singletons floating around
     * - difficult to unit test
     * - thread safety is overlooked
     * - if you need arguments in singleton you are doing it wrong
     * */

    public static void main(String[] args) {


        SingletonResource resource1 = SingletonResource.getInstance();
        SingletonResource resource2 = SingletonResource.getInstance();

        System.out.println(resource1 == resource2);

    }
}
