package com.designpatterns.flyweight;

public class FlyweightDemo2 {

    public static void main(String[] args) {

        /*
        * Observations
        *
        * - StockCompany object has to be immutable and needs to be passed around
        * - we just created 3 new objects since company is immutable and quantity is variable
        * we can  the immutable part and re use it.
        *
        * without flyweight
        * - we would end up creating 6 stock company objects that store the same value.
        * and they since they are not being modified after creation we can use flyweight
        *
        * */
        InventorySystem inventorySystem = new InventorySystem();

        inventorySystem.takeOrder("Samsung", 224);
        inventorySystem.takeOrder("Apple", 40);
        inventorySystem.takeOrder("Samsung", 224);
        inventorySystem.takeOrder("Apple", 2);
        inventorySystem.takeOrder("Apple", 3);
        inventorySystem.takeOrder("Nokia", 25);

        System.out.println(inventorySystem.totalCompaniesCreated());




    }
}
