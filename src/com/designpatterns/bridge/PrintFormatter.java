package com.designpatterns.bridge;

import java.util.List;

public class PrintFormatter implements ItemFormatter {
    @Override
    public String format(List<Detail> details, String header) {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append("\n");
        for (Detail d : details) {
            sb.append(d.getLabel());
            sb.append(":");
            sb.append(d.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
