package com.designpatterns.behavioral.chain;

public class CompanyDirector extends RequestHandler {

    @Override
    public void handleRequest(WorkRequest request) {
        // if work type is conference or team lunch or equipment
        // director can approve only till 5000
        if(request.expense < 5000 || request.type.equals(RequestType.TEAM_LUNCH)) {
            System.out.println("Director will handle request");
            return;
        }

        // else forward the request down the chain
        this.successor.handleRequest(request);
    }
}
