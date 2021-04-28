package com.designpatterns.facade;

public class ReportGeneratorFacade {
    public void generateReport(ReportType type, Object dataSource, String location) {

        if(type == null || dataSource == null)
        {
            //throw some exception
        }
        //Create report
        Report report = new Report();

        report.setHeader(new ReportHeader());
        report.setFooter(new ReportFooter());

        //Get data from dataSource and set to ReportData object
        report.setData(new ReportData());

        //Write report
        ReportWriter writer = new ReportWriter();
        switch(type)
        {
            case HTML:
                writer.writeHtmlReport(report, location);
                break;

            case PDF:
                writer.writePdfReport(report, location);
                break;
        }

    }
}
