package com.designpatterns.proxy;

public class TwitterService implements ITwitterService {

    @Override
    public String getTimeline(String screenName) {
        return String.format("this is timeline for screen name %s", screenName);
    }

    @Override
    public void postToTimeline(String screenName, String message) {
        System.out.printf("posting to screen name %s message %s", screenName, message);
    }
}
