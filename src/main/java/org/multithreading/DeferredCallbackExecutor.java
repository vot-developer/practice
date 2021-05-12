package org.multithreading;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallbackExecutor {
    private final PriorityQueue<CallBack> pq;
    private final AtomicBoolean isRunning;
    private final ReentrantLock lock;
    private final Condition wait;
    private final ConcurrentHashMap<String, Long> map;

    public DeferredCallbackExecutor() {
        this.pq = new PriorityQueue<>(Comparator.comparingLong(i -> i.executeAt));
        this.isRunning = new AtomicBoolean(false);
        this.lock = new ReentrantLock();
        this.wait = lock.newCondition();
        this.map = new ConcurrentHashMap<>();
    }

    public void start() throws InterruptedException {
        if (!isRunning.compareAndSet(false, true))
            throw new RuntimeException("Problem with running");
        Thread thread = new Thread (()-> {
            while(isRunning.get()) {
                lock.lock();
                try {
                    while (pq.isEmpty())
                        wait.await();
                    while (pq.peek().executeAt > System.currentTimeMillis())
                        wait.await(pq.peek().executeAt - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
                    System.out.println("execute : " + pq.peek().message + " : " + LocalTime.now());
                    map.put(pq.poll().message, System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread.start();
    }

    public void stop(){
        lock.lock();
        try {
            if (!isRunning.compareAndSet(true, false))
                throw new RuntimeException("Problem with stopping");
            wait.signal();
        } finally {
            lock.unlock();
        }
    }

    public void registerCallback(CallBack callBack) {
        lock.lock();
        try {
            pq.offer(callBack);
            System.out.println("register : " + callBack.message);
            wait.signal();
        } finally {
            lock.unlock();
        }
    }

    public ConcurrentHashMap<String, Long> getResult(){
        return map;
    }

    static class CallBack {
        long executeAt;
        String message;

        public CallBack(long executeAfter, String message) {
            this.executeAt = System.currentTimeMillis() + executeAfter;
            this.message = message;
        }
    }
}
