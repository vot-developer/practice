package org.multithreading;

/*
a semaphore is a construct that allows some threads to access a fixed set of resources in parallel.
Always think of a semaphore as having a fixed number of permits to give out. Once all the permits are given out,
requesting threads, need to wait for a permit to be returned before proceeding forward.

Your task is to implement a semaphore which takes in its constructor the maximum number of permits allowed
and is also initialized with the same number of permits.
 */
public class CountingSemaphore {
    private final int maxCount;
    private int usedPermits = 0;

    public CountingSemaphore(int count) {
        this.maxCount = count;
    }

    public synchronized void acquire() {
        while(maxCount == usedPermits){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        usedPermits++;
        notify();
    }

    public synchronized void release()  {
        while(usedPermits == 0){
            try {
                wait();  //for signals (call 'release' before 'acquire')
            } catch (InterruptedException e) {
            }
        }
        usedPermits--;
        notify();
    }
}
