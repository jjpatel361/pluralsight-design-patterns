package com.designpatterns.facade;

public class FacadeDemo {

    public static void main(String[] args) {
        /*
         * facade pattern - structural pattern
         * refactoring pattern not used while initial designing
         *
         * design
         * - uses composition if you are using interfaces then you are probably doing it wrong
         * - typically used to prettify an ugly API
         * - hence best suited for refactoring needs / clean up code
         * - flat problem / structure
         *
         * facade vs adapter
         * - facade doesn't add any behavior this is purely splitting behavior into smaller blocks
         * - adapter is responsible for mapping  / modifying the behavior of source to match sink
         * - facade is done with an intention for cleaner API
         * - adapter is done to match two objects source & sink
         * */
        ReportGeneratorFacade reportGeneratorFacade = new ReportGeneratorFacade();

        // see how facade basically hides all the complexity of
        // building a report object, setting headers, setting footers, setting data and printing html format
        // use facade only to refactor old systems ugly complexity into a slightly better API
        reportGeneratorFacade.generateReport(ReportType.HTML, null, null);

        reportGeneratorFacade.generateReport(ReportType.PDF, null, null);

    }
}
