package org.multithreading;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockingQueueTest {
    private final BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(5);
    private final ConcurrentHashMap<Integer, Object> checkSet = new ConcurrentHashMap<>();
    private Runnable enqueue;
    private Runnable dequeue;

    @BeforeEach
    void setUp(){
        enqueue = () -> {
            try {
                for (int i = 0; i < 50; i++) {
                    blockingQueue.enqueue(i);
                    checkSet.put(i, new Object());
                }
            } catch (InterruptedException ie) {
            }
        };

        dequeue = () -> {
            try {
                for (int i = 0; i < 25; i++) {
                    checkSet.remove(blockingQueue.dequeue());
                }
            } catch (InterruptedException ie) {
            }
        };
    }

    @Test
    void test() throws InterruptedException {
        Thread t1 = new Thread(enqueue);
        Thread t2 = new Thread(dequeue);
        Thread t3 = new Thread(dequeue);

        t1.start();
        t2.start();
        t2.join();

        Thread.sleep(100);

        assertEquals(5, checkSet.size());

        t3.start();
        t1.join();
        t3.join();

        assertEquals(0, checkSet.size());
    }
}