package com.kbm.java.practise.concurrency;
/**
 * Filename : ThreadPoolTest.java
 * Class : ThreadPoolTest
 * Author : keyur.mahajan
 * Date : Sep 11, 2017
 *
 */

public class ThreadPoolTest {

	public static void main(String[] args) {
		MyThreadPool pool = new MyThreadPool(10);

		Runnable run = new Runnable() {

			public void run() {
				System.out.println("I am Running from " + Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		};

		for (int i = 0; i < 50; i++) {
			pool.execute(run);
		}

		pool.shutDown();

	}

}
