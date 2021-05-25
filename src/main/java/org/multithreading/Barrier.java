package org.multithreading;

public class Barrier {
    private final int finalCount;
    private int currentCount;
    private int releaseCount;

    public Barrier(int capacity) {
        this.finalCount = capacity;
    }

    public synchronized void await() throws InterruptedException {
        while (currentCount == finalCount) //wait other threads before current releasing
            wait();

        currentCount++;

        if (currentCount == finalCount){
            notifyAll();
        } else {
            while (currentCount < finalCount)
                wait();
        }

        releaseCount++;
        if (releaseCount == finalCount){
            currentCount = 0;
            notifyAll();
        }
    }
}
