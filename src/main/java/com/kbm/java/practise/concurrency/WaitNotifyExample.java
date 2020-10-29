package com.kbm.java.practise.concurrency;

/**
 * Example for Wait Notify flow for inter Thread Signal
 *
 * @author Keyur Mahajan
 */
public class WaitNotifyExample {

    public static class WaitNotifyExampleClass {

        private final Object monitor;
        private boolean enableFlag = false;

        public WaitNotifyExampleClass(Object monitor) {
            this.monitor = monitor;
        }

        public void doWait() {
            synchronized (monitor) {
                while (!enableFlag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":Waiting...");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ":Waiting over");
                enableFlag = false;

            }

        }

        public void doNotify() {
            synchronized (monitor) {
                System.out.println(Thread.currentThread().getName() + ":Notification received");
                enableFlag = true;
                monitor.notify();
            }
        }
    }

    public static void main(String[] args) {
        Object monitor = new Object();
        WaitNotifyExampleClass obj = new WaitNotifyExampleClass(monitor);

        Thread t1 = new Thread(obj::doWait, "Thread-1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj.doNotify();
        }, "Thread-2");

        t1.start();
        t2.start();

    }
}
