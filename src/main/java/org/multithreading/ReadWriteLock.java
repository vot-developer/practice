package org.multithreading;

/*
Imagine you have an application where you have multiple readers and multiple writers. You are asked to design
a lock which lets multiple readers read at the same time, but only one writer write at a time.
 */
public class ReadWriteLock {
    private int readerCount;
    private boolean isNeedWrite;

    public synchronized void acquireReadLock() throws InterruptedException {
        while (isNeedWrite)
            wait();
        readerCount++;
    }

    public synchronized void releaseReadLock() {
        readerCount--;
        notifyAll();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (isNeedWrite || readerCount != 0)
            wait();
        isNeedWrite = true;
    }

    public synchronized void releaseWriteLock() {
        isNeedWrite = false;
        notifyAll();
    }
}
