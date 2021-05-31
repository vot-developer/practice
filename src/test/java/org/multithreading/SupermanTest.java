package org.multithreading;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermanTest {

    @Test
    void getInstance() throws InterruptedException {
        Queue<Superman> q = new ArrayBlockingQueue<>(3);
        CyclicBarrier barrier = new CyclicBarrier(3);
        Thread t1 = new Thread(() -> {
            try {
                barrier.await();
            } catch (Exception e) {
            }
            Superman superman = Superman.getInstance();
            q.offer(superman);
        });
        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(t1);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        Superman s1 = q.poll();
        assertTrue(s1 == q.poll());
        assertTrue(s1 == q.poll());
    }
}