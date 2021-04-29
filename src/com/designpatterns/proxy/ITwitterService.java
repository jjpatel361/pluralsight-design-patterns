package com.designpatterns.proxy;

public interface ITwitterService {
    String getTimeline(String screenName);
    void postToTimeline(String screenName, String message);
}
