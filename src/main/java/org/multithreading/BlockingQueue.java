package org.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private T[] arr;
    private int size;
    private int head;
    private int tail;
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.arr = (T[]) new Object[capacity];
    }

    public void enqueue(T element) throws InterruptedException {
        lock.lock();
        try {
            while (size == arr.length)
                full.await();

            if (head == arr.length - 1) {
                arr[head] = element;
                head = 0;
            } else
                arr[head++] = element;

            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0)
                empty.await();

            T result;
            if (tail == arr.length - 1){
                result = arr[tail];
                tail = 0;
            } else
                result = arr[tail++];

            size--;
            full.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }
}
