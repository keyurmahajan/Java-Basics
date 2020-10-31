package com.kbm.java.practise.concurrency;

/**
 * Custom Semaphore implementation
 * <p>
 * Semaphore works as a limiter for access resource. It will restrict number of parallel thread to access a resource
 *
 * @author Keyur Mahajan
 */
public class CustomSemaphoreExample {

    private static class CustomSemaphore {

        private int permits;
        private int allowed;

        public CustomSemaphore(int permits) {
            this.permits = permits;
            this.allowed = 0;
        }

        // allowed permit if limit in permitted bound
        public synchronized void acquire() throws InterruptedException {
            while (allowed == permits) {
                System.out.println(Thread.currentThread().getName() + " Waiting..");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " Acquired <-");
            allowed++;
        }

        // release the permits
        public synchronized void release() {
            allowed--;
            System.out.println(Thread.currentThread().getName() + " Releasing ->");
            notify();
        }
    }

    public static void main(String[] args) {
        CustomSemaphore semaphore = new CustomSemaphore(2);

        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                System.out.println("  My Runnable working with " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();

        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
