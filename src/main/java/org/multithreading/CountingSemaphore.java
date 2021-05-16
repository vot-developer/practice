package org.multithreading;

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
