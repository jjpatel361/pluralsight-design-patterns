package com.designpatterns.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventorySystem {

    private final StockCatalog catalog = new StockCatalog();
    private final List<StockOrder> orders = new CopyOnWriteArrayList<StockOrder>();

    public void takeOrder(String companyName, int quantity) {

        StockCompany companyInfo = catalog.lookup(companyName);

        StockOrder order = new StockOrder(quantity, companyInfo);
        orders.add(order);
    }

    public int totalCompaniesCreated() {
        return this.catalog.catalogSize();
    }
}
