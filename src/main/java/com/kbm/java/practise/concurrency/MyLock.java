package com.kbm.java.practise.concurrency;

/**
 * Filename : MyLock.java
 * Class : MyLock
 * Author : keyur.mahajan
 * Date : Sep 21,2017
 *
 */

public class MyLock {

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

}
