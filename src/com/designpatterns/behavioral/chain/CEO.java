package com.designpatterns.behavioral.chain;

public class CEO extends RequestHandler {

    @Override
    public void handleRequest(WorkRequest request) {
        // do checking
        System.out.println("CEO will handle request");
    }
}
