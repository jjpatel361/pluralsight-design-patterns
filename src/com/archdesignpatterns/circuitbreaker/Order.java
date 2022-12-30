package com.archdesignpatterns.circuitbreaker;

import java.util.UUID;

public class Order {
    public String id;

    public String promoCode;

    public Double amount;

    public String orderName;

    public Order(String promoCode, double amount) {
        this.promoCode = promoCode;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    public Order(String promoCode, double amount, String orderId) {
        this.promoCode = promoCode;
        this.amount = amount;
        this.id = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", promoCode='" + promoCode + '\'' +
                ", amount=" + amount +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
