package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarrierTest {

    @Test
    void await() throws InterruptedException {
        final Barrier barrier = new Barrier(3);
        Thread t1 = new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException e) {
            }
        });
        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(t1);
        t1.start();
        t2.start();
        Thread.sleep(100);
        assertTrue(t1.isAlive());
        assertTrue(t2.isAlive());
        long start = System.currentTimeMillis();
        t3.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        assertTrue(end - start < 100);
        t3.join();
    }
}