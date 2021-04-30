package com.designpatterns.behavioral.chain;

public abstract class RequestHandler {

    protected RequestHandler successor;

    public void setSuccessor(RequestHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(WorkRequest handler);
}
