package com.kbm.java.practise.concurrency;


/**
 * Example of race condition.
 * Both thread trying to increment same int value but it wont get flush to main memory
 * also while reading it wont read latest value from main memory this may lead to race condition
 * this will result in inappropriate final count printed at the end of both thread.
 * Ideally final count of any 1 thread should be 2_00_000, but due to race condition this wont happen.
 *
 * @author Keyur Mahajan
 */
public class RaceConditionExample {

    private static class MyRunnable implements Runnable{

        private int counter;

        MyRunnable(int i){
            this.counter = i;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_00_000; i++) {
                counter++;
            }
            System.out.println("counter = " + counter);

        }
    }

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable(0);

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

}
