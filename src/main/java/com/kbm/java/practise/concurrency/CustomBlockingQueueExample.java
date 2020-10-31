package com.kbm.java.practise.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Blocking Queue implementation
 *
 * @author Keyur Mahajan
 */
public class CustomBlockingQueueExample {

    private static class BlockingQueueExample {

        private int limit;
        private List<Object> queue = new ArrayList<>();

        public BlockingQueueExample(int limit) {
            this.limit = limit;
        }


        public synchronized void put(Object obj) throws InterruptedException {
            // block if limit reached
            while (queue.size() == limit) {
                System.out.println(Thread.currentThread().getName() + " waiting on put...");
                wait();
            }

            // add to queue and notify waiting threads to consume
            System.out.println(Thread.currentThread().getName() + ": " + obj + " is added to queue");
            queue.add(obj);
            notifyAll();
        }

        public synchronized Object take() throws InterruptedException {
            // block call if queue is empty
            while (queue.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting in take...");
                wait();
            }

            // remove fom queue and return the object
            Object removedObj = queue.remove(0);
            System.out.println(Thread.currentThread().getName() + ": " + removedObj + " is removed from queue");
            notifyAll();
            return removedObj;

        }

    }

    public static void main(String[] args) {
        BlockingQueueExample blockingQueue = new BlockingQueueExample(1);

        Runnable producer1 = () -> {
            try {
                blockingQueue.put("Hi");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable producer2 = () -> {
            try {
                blockingQueue.put("Hi");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable producer3 = () -> {
            try {
                blockingQueue.put("Hi");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true){
                    System.out.println("Received:" + blockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        new Thread(producer1, "Producer-1").start();
        new Thread(producer2, "Producer-2").start();
        new Thread(producer3, "Producer-3").start();
        new Thread(consumer, "Consumer-1").start();
    }
}
