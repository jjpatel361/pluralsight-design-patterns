package com.archdesignpatterns.circuitbreaker;

import java.util.List;

public class DevEcommerceShop2 {

    public static void main(String[] args) throws InterruptedException {


        List<Order> orders = DevEcommerceShop.getOrderStream(35);

        CircuitBreaker cb = new CircuitBreaker();
        cb.setRequestFailThreshold(5);
        cb.setMillisToWaitInOpen(4000);

        PromoService promoService = new PromoService();

        for (Order order : orders) {

            // Build Request
            PromoServiceRequest request = new PromoServiceRequestBuilder()
                    .withPromoCode(order.promoCode)
                    .withAmount(order.amount)
                    .withPromoService(promoService)
                    .build();

            // Execute via Circuit Breaker
            try {
                double result = cb.execute(request);
                System.out.printf("orderId %s SUCCESS afterDiscount %s%n", order.id, result);
            } catch (Exception e) {
                System.err.printf("orderId %s FAILED Exception: %s%n", order.id, e.getMessage());
            }


            // Let's not iterate too fast else we won't give breaker to recover
            Thread.sleep(1000);
        }

    }
}
