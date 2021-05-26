package org.multithreading;

/*
A barrier can be thought of as a point in the program code, which all or some of the threads need to reach at before
any one of them is allowed to proceed further.
 */
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
