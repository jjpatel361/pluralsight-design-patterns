package com.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class StockCatalog {
    private Map<String, StockCompany> nasdaq = new HashMap<String, StockCompany>();

    public StockCompany lookup(String companyName) {
        if(!nasdaq.containsKey(companyName)) {
            nasdaq.put(companyName, new StockCompany(companyName));
        }
        return nasdaq.getOrDefault(companyName, null);
    }

    public int catalogSize() {
        return this.nasdaq.size();
    }
}
