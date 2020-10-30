package com.kbm.java.practise.concurrency;

/**
 * Custom Lock implementation with out fairness
 *
 * @author Keyur Mahajan
 */

public class CustomLockExample {

	private boolean isLocked = false;
	private Thread currentThread;

	public void lock() throws InterruptedException {
		while (isLocked) {
			synchronized (this) {
				this.wait();
			}
		}
		isLocked = true;
		currentThread = Thread.currentThread();
	}

	public void unlock() {
		if (Thread.currentThread() == currentThread && isLocked) {
			synchronized (this) {
				this.notify();
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
					System.out.println("Taking Lock " + Thread.currentThread().getName());
					lock.lock();
					System.out.println("Taken Lock " + Thread.currentThread().getName());
					Thread.sleep(5000);
					System.out.println("Releasing Lock " + Thread.currentThread().getName());
					lock.unlock();
					System.out.println("Lock Released " + Thread.currentThread().getName());
					System.out.println("-------------");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		Thread th1 = new Thread(arg0);
		Thread th2 = new Thread(arg0);
		Thread th3 = new Thread(arg0);
		Thread th4 = new Thread(arg0);
		Thread th5 = new Thread(arg0);
		Thread th6 = new Thread(arg0);

		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
	}

}
