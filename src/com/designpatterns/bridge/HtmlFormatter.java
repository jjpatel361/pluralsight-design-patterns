package com.designpatterns.bridge;

import java.util.List;

public class HtmlFormatter implements ItemFormatter {

    public HtmlFormatter() {

    }

    @Override
    public String format(List<Detail> details, String header) {
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        sb.append("\n");
        for (Detail d :
                details) {
            sb.append("<li>");
            sb.append(d.getLabel());
            sb.append(" - ");
            sb.append(d.getValue());
            sb.append("</li>");
            sb.append("\n");
        }
        sb.append("</ul>");

        return sb.toString();
    }
}
