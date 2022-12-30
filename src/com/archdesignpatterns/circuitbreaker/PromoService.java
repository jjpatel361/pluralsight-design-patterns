package com.archdesignpatterns.circuitbreaker;


import java.util.Date;

public class PromoService {

    public static int requestProcessed = 0;

    public static int milliSecondsToUnhealthyState = 5000;

    public static int milliSecondsToHealthyState = 35000;
    private final long serviceDegradationThreshold;
    private final long serviceRecoveryThreshold;


    PromoService() {
        this.serviceDegradationThreshold = new Date(System.currentTimeMillis() + milliSecondsToUnhealthyState).getTime();
        this.serviceRecoveryThreshold = new Date(System.currentTimeMillis() + milliSecondsToHealthyState).getTime();
    }

    public double apply(String promoCode, Double amount) throws Exception {

//        Long timeToSleep = Long.valueOf(requestProcessed * 100);
        Long timeToSleep = 1000L;
        requestProcessed++;
        /**
         * Apply method might do multiple things
         * - promo availability - if promo is still available
         * - promo validity - issued by us and still valid
         * - promo issuance - if a user was issued this exact promo code.
         */
        Thread.sleep(timeToSleep);

        /**
         * Throw an error only if current time falls in unhealthy window
         */
        if(isServiceUnhealthy()) {
            throw new Exception("Promo code service unavailable");
        }

        // For simplicity, we will apply 20% discount on each
        return amount - (amount * 0.20/100);
    }

    private boolean isServiceUnhealthy() {
        long currentTime = new Date().getTime();

        if(currentTime >= serviceDegradationThreshold
                && currentTime < serviceRecoveryThreshold) {
            return true;
        }

        return false;
    }

}
