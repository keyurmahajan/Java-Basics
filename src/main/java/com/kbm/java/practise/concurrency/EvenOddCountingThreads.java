package com.kbm.java.practise.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Multithreading implementation to increment number by 1 in two separate thread and print even and odd no
 *
 * @author Keyur Mahajan
 */
public class EvenOddCountingThreads {

    private static volatile AtomicInteger i = new AtomicInteger(1);

    public static class EvenRunnable implements Runnable {

        private AtomicInteger counter;

        public EvenRunnable(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.get() < 10) {
                if (counter.get() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " : counter++ = " + counter.get());
                    counter.getAndAdd(1);
                }
            }
        }
    }

    public static class OddRunnable implements Runnable {

        private AtomicInteger counter;

        public OddRunnable(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter.get() < 10) {
                if (counter.get() % 2 != 0) {
                    System.out.println("=>" + Thread.currentThread().getName() + " : counter++ = " + counter.get());
                    counter.getAndAdd(1);
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread evenThread = new Thread(new EvenRunnable(i), "EvenThread");
        Thread oddThread = new Thread(new OddRunnable(i), "OddThread");

        evenThread.start();
        oddThread.start();

    }


}
