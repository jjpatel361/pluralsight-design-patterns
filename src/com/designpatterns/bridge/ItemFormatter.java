package com.designpatterns.bridge;

import java.util.List;

public interface ItemFormatter {
    String format(List<Detail> details, String header);
}
