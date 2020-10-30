package com.kbm.java.practise.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Filename : MyThreadPool.java
 * Class : MyThreadPool
 * Author : keyur.mahajan
 * Date : Sep 11, 2017
 *
 */

public class CustomThreadPool {


	private BlockingQueue<Runnable> queue;
	private List<MyThread> threads;

	public CustomThreadPool(int size) {
		this.queue = new ArrayBlockingQueue<Runnable>(50);
		threads = new ArrayList<CustomThreadPool.MyThread>();
		for (int i = 0; i < size; i++) {
			MyThread thread = new MyThread(queue);
			threads.add(thread);
			thread.start();
		}
	}

	public void execute(Runnable runnable) {
		queue.offer(runnable);
	}

	public void shutDown() {
		for (MyThread thread : threads) {
			thread.kill();
		}

	}

	public class MyThread extends Thread {

		private BlockingQueue<Runnable> threadQueue;
		private boolean isStopped;

		public MyThread(BlockingQueue queue) {
			threadQueue = queue;
		}

		@Override
		public void run() {
			while (!isStopped()) {
				try {
					Runnable runnable = threadQueue.take();
					if (runnable != null) {
						runnable.run();
					}
				} catch (InterruptedException e) {
					System.err.println("No more threads to run");
				}

			}
		}

		public boolean isStopped() {
			return isStopped;
		}

		public void kill() {
			isStopped = true;
			interrupt();
		}
	}

}
