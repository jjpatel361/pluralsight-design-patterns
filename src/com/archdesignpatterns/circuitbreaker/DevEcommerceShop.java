package com.archdesignpatterns.circuitbreaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DevEcommerceShop {

    public static void main(String[] args) {
        /**
         * Application demonstrating no circuit breaker
         *
         */
        System.out.println("Application example with no circuit breaker");

        // Stream of Orders
        List<Order> orderStream = getOrderStream(60);

        // Order stream represents requests
        // Promo service represents another microservice
        // deployed to handle promo validation invalidation etc.
        PromoService ps = new PromoService();

        orderStream.forEach(order -> {
            try {
                double afterDiscountPrice = ps.apply(order.promoCode, order.amount);
                System.out.printf("Promo Applied orderId %s afterDiscount %s%n", order.id, afterDiscountPrice);
            } catch (Exception e) {
                System.out.printf("Exception: %s orderId %s%n", e.getMessage(), order.id);
            }
        });
    }

    public static List<Order> getOrderStream(int orderStreamSize) {

        List<Order> randomOrders = new ArrayList<>();

        IntStream.range(0, orderStreamSize).forEach(index -> {
            int randomInt = new Random().ints(100, 900).findAny().getAsInt();
            randomOrders.add(new Order("DISCOUNT20", randomInt, String.valueOf(index)));
        });

        return randomOrders;
    }
}

/**
 * Circuit Breaker Architecture
 * https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker
 *
 * can prevent an application from repeatedly trying to execute an operation
 * that's LIKELY TO FAIL. Allowing it to continue without waiting for the fault
 * to be fixed or wasting CPU cycles while it determines that the fault is LONG-LASTING.
 * The Circuit Breaker pattern ALSO enables an application to detect whether the fault has been resolved.
 * If the problem appears to have been fixed, the application can try to invoke the operation.
 *
 *
 * States
 * Open: The request from the application fails immediately and an exception is returned to the application.
 *
 * Closed: The request from the application is routed to the operation.
 * The proxy maintains a count of the number of recent failures, and if the call to the operation is unsuccessful
 * the proxy increments this count.
 * If the number of recent failures exceeds a specified threshold WITHIN A GIVEN TIME PERIOD, (rolling window)
 * the proxy is placed into the Open state.
 * At this point the proxy starts a timeout timer, and when this timer expires the proxy is placed into the Half-Open state.
 *
 * Half-Open:
 * A limited number of requests from the application are allowed to pass through and invoke the operation.
 * If these requests are successful, it's assumed that the fault that was previously causing the failure has been fixed
 * and the circuit breaker switches to the Closed state (the failure counter is reset).
 * If any request fails, the circuit breaker assumes that the fault is still present so it reverts back to the Open state
 * and restarts the timeout timer to give the system a further period of time to recover from the failure.
 *
 *
 * A circuit breaker pattern is helpful to contain
 * - stop propagation of unhealthy downstream service upwards
 * - Effective when time taken for downstream service to respond with error is large.
 *   E.g. if downstream service takes 300 ms to respond with error.
 *   Single Upstream client having 10 threads each waiting 300 ms before timing out.
 *   Upstream traffic is 20 req / sec. 300ms (error respond time) x 20 (client traffic) / 10 (# of threads)
 *   => 600ms / sec compute wasted. 60% of your compute and time is wasted in waiting for eventual failure.
 * - This also means upstream services like browsers might be in wait zone before eventual failure.
 *
 */
