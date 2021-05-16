package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSemaphoreTest {

    @Test
    void testConcurrentAccess() throws InterruptedException {
        final CountingSemaphore cs = new CountingSemaphore(2);
        Thread thread1 = new Thread(() -> {
            cs.acquire();
            for (int i = 0; i < 5; i++){
                try {
                    Thread.sleep(100l);
                } catch (InterruptedException e) {
                }
            }
            cs.release();
        });
        Thread thread2 = new Thread(thread1);
        Thread thread3 = new Thread(thread1);
        Thread thread4 = new Thread(thread1);
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        long end = System.currentTimeMillis();
        assertTrue(end - start > 1000);
        assertTrue(end - start < 1200);
    }

    @Test
    void testProducerConsumerSignals() throws InterruptedException {
        final CountingSemaphore cs = new CountingSemaphore(1);
        Thread consumer = new Thread(() -> {
            cs.release();
            cs.acquire();
        });
        Thread producer = new Thread(() -> {
            cs.acquire();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            cs.release();
        });
        long start = System.currentTimeMillis();
        consumer.start();
        Thread.sleep(1000);
        producer.start();
        consumer.join();
        long end = System.currentTimeMillis();
        producer.join();
        assertTrue(end - start > 1000);
        assertTrue(end - start < 1200);
    }
}