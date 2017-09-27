package com.kbm.java.practise.concurrency;
/**
 * Filename : MyLockTest.java
 * Class : MyLockTest
 * Author : keyur.mahajan
 * Date : Sep 21, 2017
 *
 */

public class MyLockTest {

	public static void main(String[] args) {
		Runnable arg0 = new Runnable() {

			MyLock lock = new MyLock();

			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("I am going to take Lock " + Thread.currentThread().getName());
					lock.unlock();
					System.out.println("I have relased the Lock " + Thread.currentThread().getName());
					System.out.println("-------------");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		Thread th1 = new Thread(arg0);
		Thread th2 = new Thread(arg0);
		Thread th3 = new Thread(arg0);

		th1.start();
		th2.start();
		th3.start();
	}

}
