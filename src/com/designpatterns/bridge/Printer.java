package com.designpatterns.bridge;

import java.util.List;

public abstract class Printer {

    public String print(ItemFormatter formatter) {
        return formatter.format(getDetails(), getHeader());
    }

    abstract protected List<Detail> getDetails();

    abstract protected String getHeader();
}
