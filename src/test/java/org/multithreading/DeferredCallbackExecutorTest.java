package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeferredCallbackExecutorTest {
    private final DeferredCallbackExecutor executor = new DeferredCallbackExecutor();

    @Test
    void start() throws InterruptedException {
        executor.start();
        long time1 = 2100;
        long time2 = 2300;
        long time3 = 3000;
        long time4 = 2500;
        Thread thread1 = new Thread(() -> {
            executor.registerCallback(new DeferredCallbackExecutor.CallBack(time1, "time1"));
            executor.registerCallback(new DeferredCallbackExecutor.CallBack(time2, "time2"));
        });
        Thread thread2 = new Thread(() -> {
            executor.registerCallback(new DeferredCallbackExecutor.CallBack(time3, "time3"));
            executor.registerCallback(new DeferredCallbackExecutor.CallBack(time4, "time4"));
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertEquals(0, executor.getResult().size());
        Thread.sleep(3100);
        assertEquals(4, executor.getResult().size());
    }
}