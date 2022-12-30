package com.archdesignpatterns.circuitbreaker;

import java.util.Date;

import static com.archdesignpatterns.circuitbreaker.CircuitBreakerState.*;


enum CircuitBreakerState {
    OPEN,
    CLOSE,
    HALF_OPEN
}

public class CircuitBreaker {

    private int milliSecondsToWaitInOpen;
    private int numberOfRequestFailsThreshold;

    private long lastOpenStateTimeInMilli;

    private CircuitBreakerState circuitBreakerState = CircuitBreakerState.CLOSE;

    private int numberOfRequestFailed = 0;

    CircuitBreaker() {
        // default cb is in close state
        this.circuitBreakerState = CircuitBreakerState.CLOSE;
        this.numberOfRequestFailed = 0;
    }


    /**
     *
     * @param numberOfRequestFailsThreshold count of request fails allowed before
     *                                      declaring open state
     */
    public void setRequestFailThreshold(int numberOfRequestFailsThreshold) {
        this.numberOfRequestFailsThreshold = numberOfRequestFailsThreshold;
    }

    /**
     * Milliseconds to wait before retrying when in Open State
     * @param millisToWaitInOpen
     */
    public void setMillisToWaitInOpen(int millisToWaitInOpen) {
        this.milliSecondsToWaitInOpen = millisToWaitInOpen;
    }


    public double execute(PromoServiceRequest request) throws Exception {

        long currentTimeInMilli = new Date().getTime();

        if(circuitBreakerState == OPEN) {
            boolean openStateTimerExpired = lastOpenStateTimeInMilli + milliSecondsToWaitInOpen <= currentTimeInMilli;

            if(!openStateTimerExpired) {
                throw new Exception("CircuitBreakerOpenStateException: Circuit breaker in OPEN state waiting for timer to expire.");
            }

            try {
                System.out.println("CircuitBreaker: Retrying in HALF_OPEN state.");
                circuitBreakerState = HALF_OPEN;
                request.execute();
                // if request passes then let's change state to close
                System.out.println("CircuitBreaker: State changed to CLOSE");
                circuitBreakerState = CLOSE;
                numberOfRequestFailed = 0;
            } catch(Exception e) {
                // Move back to old state and reset the timer
                circuitBreakerState = OPEN;
                lastOpenStateTimeInMilli = new Date().getTime();
                throw new Exception("CircuitBreakerOpenStateException: Circuit breaker in OPEN state. After retry");
            }
        }

        if(circuitBreakerState == CLOSE) {
            try {
                return request.execute();
            } catch (Exception e) {
                numberOfRequestFailed++;
                if (numberOfRequestFailed >= numberOfRequestFailsThreshold) {
                    // move the circuit breaker to open state
                    System.err.println("CircuitBreaker: open threshold reached. Circuit Breaker in open state.");
                    circuitBreakerState = OPEN;
                    lastOpenStateTimeInMilli = new Date().getTime();
                }

                // we let the upstream client know it is in Open state
                if(circuitBreakerState == OPEN) {
                    throw new Exception("CircuitBreakerOpenStateException", e);
                }
                throw e;
            }
        }
        return 0;
    }
}
