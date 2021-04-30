package com.designpatterns.behavioral.chain;

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {


        /*
        * Chain of responsibility is a behavioral pattern
        *
        * - Decouple sender and receiver such that sender has no idea who the handler is
        * and receiver has no idea who the sender is.
        * - there can be multiple handlers in a chain
        * - each handler just keeps a reference of the next handler also called successor
        * - each handler implements an interface
        * - the request passes from sender to all receivers in chain
        *
        * */

        CompanyDirector director = new CompanyDirector();
        VP vicePresident = new VP();
        CEO president = new CEO();

        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(president);

        // current chain looks like director -> vice president  -> president

        WorkRequest conferenceRequest = new WorkRequest(RequestType.CONFERENCE, 2000);
        director.handleRequest(conferenceRequest);

        WorkRequest equipmentRequest = new WorkRequest(RequestType.EMPLOYEE_EQUIPMENT, 6000);
        director.handleRequest(equipmentRequest);

        // any request that is greater than 5000 will be moved to CEO unless its about conference
        WorkRequest equipmentRequest2 = new WorkRequest(RequestType.EMPLOYEE_EQUIPMENT, 60000);
        director.handleRequest(equipmentRequest2);

        WorkRequest conferenceRequest2 = new WorkRequest(RequestType.CONFERENCE, 60000);
        director.handleRequest(conferenceRequest2);

        return;
    }

}
