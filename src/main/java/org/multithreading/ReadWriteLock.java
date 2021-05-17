package org.multithreading;

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
