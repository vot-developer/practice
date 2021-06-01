package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SynchronousExecutorTest {
    private final int timeout = 500;

    @Test
    void synchronousExecution() throws Exception {
        AsynchronousSynchronousProblem executor = new AsynchronousSynchronousProblem(timeout);
        long start = System.currentTimeMillis();
        executor.synchronousExecution(() -> {});
        executor.synchronousExecution(() -> {});
        executor.await();
        long end = System.currentTimeMillis();
        assertTrue(end - start > timeout + 100);
        assertTrue(end - start < 2 * timeout + 100);
    }

    @Test
    void asynchronousExecution() throws Exception {
        AsynchronousSynchronousProblem executor = new AsynchronousSynchronousProblem(timeout);
        long start = System.currentTimeMillis();
        executor.asynchronousExecution(() -> {});
        executor.asynchronousExecution(() -> {});
        executor.await();
        long end = System.currentTimeMillis();
        assertTrue(end - start > timeout - 1);
        assertTrue(end - start < timeout + 100);
    }
}