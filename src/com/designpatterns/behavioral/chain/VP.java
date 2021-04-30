package com.designpatterns.behavioral.chain;

public class VP extends RequestHandler {

    @Override
    public void handleRequest(WorkRequest workRequest) {

        if(workRequest.expense < 10000 || RequestType.CONFERENCE == workRequest.type) {
            System.out.println("VP will handle request");
            return;
        }

        this.successor.handleRequest(workRequest);

    }
}
