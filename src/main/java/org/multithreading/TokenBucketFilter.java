package org.multithreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketFilter {
    private final int maxTokens;
    private final ReentrantLock lock;
    private final Condition full;
    private final Condition empty;
    private final AtomicBoolean isRunning;
    private int firstToken;
    private int lastToken;
    private int currentSize;

    public TokenBucketFilter(int maxTokens) {
        this.maxTokens = maxTokens;
        this.lock = new ReentrantLock();
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
        this.isRunning = new AtomicBoolean(true);
        this.firstToken = 1;
        this.lastToken = 0;
        this.currentSize = 0;
    }

    void initialize() {
        Thread counter = new Thread(() -> {
            while (isRunning.get()) {
                lock.lock();
                try {
                    while (currentSize == maxTokens)
                        full.await();
                    lastToken++;
                    currentSize++;
                    empty.signal();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
        });
        counter.start();
    }

    public void stop() {
        boolean success;
        do {
            success = isRunning.compareAndSet(true, false);
        } while (!success);
    }

    public int getToken() {
        lock.lock();
        int result = 0;
        try {
            while (currentSize == 0)
                empty.await();
            result = firstToken++;
            currentSize--;
            full.signal();
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
        return result;
    }

}

class TokenBucketFilterFactory {
    public static TokenBucketFilter createFilter(int maxTokens) {
        TokenBucketFilter filter = new TokenBucketFilter(maxTokens);
        filter.initialize();
        return filter;
    }
}
