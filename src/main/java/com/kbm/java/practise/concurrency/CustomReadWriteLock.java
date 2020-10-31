package com.kbm.java.practise.concurrency;

/**
 * Custom Read Write lock implementation
 * Read Access  : If no threads are writing, and no threads have requested write access.
 * Write Access : If no threads are reading or writing.
 * <p>
 * Here Write Request means thread has requested for lock but still in waiting stage
 *
 * @author Keyur Mahajan
 */
public class CustomReadWriteLock {

    public static class ReadWriteLock {

        private int readersCount = 0;
        private int writersCount = 0;
        private int writeRequestCount = 0;

        public synchronized void lockRead() throws InterruptedException {
            while (writersCount > 0 || writeRequestCount > 0) {
                wait();
            }
            readersCount++;
        }

        public synchronized void unlockRead() {
            readersCount--;
            notifyAll();
        }

        public synchronized void lockWrite() throws InterruptedException {
            writeRequestCount++;

            while (readersCount > 0 || writersCount > 0) {
                wait();
            }
            writeRequestCount--;
            writersCount++;
        }

        public synchronized void unlockWrite() throws InterruptedException {
            writersCount--;
            notifyAll();
        }
    }
}
