package com.designpatterns.proxy;

public class ProxyDemo {

    public static void main(String[] args) {

        /*
        * proxy pattern is a structural pattern
        *
        * - used to intercept method calls to a class and perform some action
        * - think of it as middleware wrapped around a class
        * - typical use cases
        *   - security disallow certain method calls
        *   - auditing track method calls and their arguments
        * - built in support from java
        *
        * Pitfalls
        * - only one proxy per object no chaining i.e you can't have audit proxy, security proxy etc.
        * - another abstraction
        * - compile time exceptions
        * */


        // we pass the object we want to wrap to security proxy.
        // it returns a wrapped object, and we cast it TwitterService
        // this is better than doing new TwitterService then we would lose the proxy and directly use
        // the object. also note the cast only works for interfaces and not on concrete classes
        // if you replace ITwitterService with TwitterService it will break the casting.

        ITwitterService twitterService = (ITwitterService) SecurityProxy.newInstance(new TwitterService());

        System.out.println(twitterService.getTimeline("mkbhm23"));

        twitterService.postToTimeline("mkbhm23", "hello world");

    }

}
