package com.kbm.java.practise.concurrency;

/**
 * Filename : MyLock.java
 * Class : MyLock
 * Author : keyur.mahajan
 * Date : Sep 21,2017
 *
 */

public class CustomLockExample {

	private boolean isLocked = false;
	private Thread currentThread;

	public void lock() throws InterruptedException {
		while (isLocked) {
			synchronized (this) {
				wait();
			}
		}
		isLocked = true;
		currentThread = Thread.currentThread();

	}

	public void unlock() {
		if (Thread.currentThread() == currentThread && isLocked) {
			synchronized (this) {
				notify();
			}
			isLocked = false;
			currentThread = null;
		}

	}

	public static void main(String[] args) {
		Runnable arg0 = new Runnable() {

			CustomLockExample lock = new CustomLockExample();

			@Override
			public void run() {
				try {
					lock.lock();
					System.out.println("I am going to take Lock " + Thread.currentThread().getName());
					lock.unlock();
					System.out.println("I have released the Lock " + Thread.currentThread().getName());
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
