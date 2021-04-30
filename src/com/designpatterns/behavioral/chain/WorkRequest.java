package com.designpatterns.behavioral.chain;

public class WorkRequest {

    RequestType type;
    int expense;

    public WorkRequest(RequestType type, int expense) {
        this.expense = expense;
        this.type = type;
    }
}
