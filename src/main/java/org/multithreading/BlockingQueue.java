package org.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to
add the new item being enqueued. Similarly, the queue blocks the dequeue caller if there are no items in the queue.
Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked dequeuing thread when
an item becomes available in the queue.
 */
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
            if (head == arr.length)
                head = 0;

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
            if (tail == arr.length)
                tail = 0;

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
