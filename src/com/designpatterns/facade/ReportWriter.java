package com.designpatterns.facade;

public class ReportWriter {
    public void writeHtmlReport(Report report, String location) {
        System.out.println("HTML Report written");
    }

    public void writePdfReport(Report report, String location) {
        System.out.println("PDF Report written");
    }
}
