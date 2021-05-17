package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteLockTest {

    @Test
    void acquireReadLock() throws InterruptedException {
        final ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread writer1 = new Thread(() -> {
                try {
                    readWriteLock.acquireWriteLock();
                    Thread.sleep(500);
                    readWriteLock.releaseWriteLock();
                } catch (InterruptedException ie) {}
        });
        Thread writer2 = new Thread(writer1);

        Thread reader1 = new Thread(()->{
                try {
                    readWriteLock.acquireReadLock();
                    Thread.sleep(500);
                    readWriteLock.releaseReadLock();
                } catch (InterruptedException ie) {}
        });

        Thread reader2 = new Thread(reader1);

        long start = System.currentTimeMillis();
        reader1.start();
        Thread.sleep(10);
        writer1.start();
        writer2.start();
        reader2.start();
        reader1.join();
        reader2.join();
        writer1.join();
        writer2.join();
        long end = System.currentTimeMillis();
        assertTrue(end - start > 1500); //two reader simultaneously, two writers by one
        assertTrue(end - start < 1600);
    }
}