package com.designpatterns.singleton;

import static java.lang.Thread.sleep;

public class VolatileKeyword {

    /**
     * implementation from
     * https://dzone.com/articles/java-volatile-keyword-0
     * Each thread has its own stack, and so its own copy of variables it can access.
     * When the thread is created, it copies the value of all accessible variables in its own memory.
     * The volatile keyword is used to say to the jvm "Warning, this variable may be modified in an other Thread".
     * Without this keyword the JVM is free to make some optimizations,
     * like never refreshing those local copies in some threads.
     * The volatile force the thread to update the original variable for each variable.
     * The volatile keyword could be used on every kind of variable, either primitive or objects!
     */

    // private static int COUNTER = 0;
    private static volatile int COUNTER = 0;

    public static void main(String[] args) {
        new ChangeEmitter().start();

        new ChangeListener().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = COUNTER;
            System.out.println("Running ChangeListener");
            while ( local_value < 5){
                // in the condition below with volatile keyword
                // JVM will use the older version of COUNTER variable
                if( local_value != COUNTER){
                    System.out.printf("ChangeListener counter %s%n", COUNTER);
                    local_value = COUNTER;
                }
            }
        }
    }

    static class ChangeEmitter extends Thread {
        @Override
        public void run() {
            System.out.println("Running ChangeEmitter");
            int local_value = COUNTER;
            while ( COUNTER < 5){
                // increment counter by 1 at 2 sec interval
                COUNTER = ++local_value;
                System.out.printf("ChangeEmitter counter %s%n", COUNTER);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
