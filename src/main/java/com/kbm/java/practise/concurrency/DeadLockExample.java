package com.kbm.java.practise.concurrency;

/**
 * Example for dead lock condition
 *
 * @author Keyur Mahajan
 */
public class DeadLockExample {

    private static class MyRunnable implements Runnable{

        private Object o1;
        private Object o2;

        public MyRunnable(Object o1, Object o2){
            this.o1 = o1;
            this.o2 = o2;
        }

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName()+":Trying to get lock "+o1);

                synchronized (this.o1){

                    System.out.println(Thread.currentThread().getName()+":Acquired lock "+o1);
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+":Trying to get lock "+o2);

                    synchronized (this.o2){

                        System.out.println(Thread.currentThread().getName()+":Acquired lock "+o2);
                        Thread.sleep(3000);
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(new MyRunnable(o1,o2),"Thread-1");
        Thread t2 = new Thread(new MyRunnable(o2,o1),"Thread-2");

        t1.start();
        t2.start();
    }
}
