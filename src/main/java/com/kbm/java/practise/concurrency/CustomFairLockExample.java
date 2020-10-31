package com.kbm.java.practise.concurrency;

import java.util.LinkedList;
import java.util.List;

/**
 * Custom Implementation of Fairness lock. This still not perfect, need to make it work in all edge cases.
 *
 * @author Keyur Mahajan
 */
public class CustomFairLockExample {

    private static class FairLock {

        private final Object monitor = new Object();
        private List<Thread> waitingThreads = new LinkedList<>();
        private Thread lockedThread = null;
        private volatile boolean locked = false;

        public void lock() {
            synchronized (monitor) {
                waitingThreads.add(Thread.currentThread());
                while (locked) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Waiting");
                        monitor.wait();
                        System.out.println(Thread.currentThread().getName() + " woke up");
                        // if latest thread then proceed or else again wait
                        if (Thread.currentThread() == waitingThreads.get(0) && lockedThread == null) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("-> " + Thread.currentThread().getName() + " got the lock");
                locked = true;
                lockedThread = Thread.currentThread();
                waitingThreads.remove(Thread.currentThread());
                waitingThreads.stream().forEach(i -> System.out.print(i.getName() + ","));
                System.out.println();
            }

        }

        public void unlock() {
            synchronized (monitor) {
                if (locked && lockedThread == Thread.currentThread()) {
                    System.out.println(Thread.currentThread().getName() + " : Unlocked");
                    locked = false;
                    lockedThread = null;
                    monitor.notifyAll();
                } else {
                    System.out.println("Can not unlock " + Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLock lock = new FairLock();

        Runnable runnable = () -> {
            lock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        };

        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");
        Thread t3 = new Thread(runnable, "Thread-3");
        Thread t4 = new Thread(runnable, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
