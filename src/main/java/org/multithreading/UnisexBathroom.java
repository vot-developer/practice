package org.multithreading;

public class UnisexBathroom {
    private final int capacity;
    private final long duration;
    private volatile int maleCount;
    private volatile int femaleCount;

    public UnisexBathroom(int capacity, long duration) {
        this.capacity = capacity;
        this.duration = duration;
    }

    void maleUseBathroom(String name) throws InterruptedException {
        synchronized (this) {
            while (maleCount > 0 || femaleCount == 3)
                wait();
            femaleCount++;
        }
        useBathroom(name);
        synchronized (this) {
            femaleCount--;
            notifyAll();
        }
    }

    void femaleUseBathroom(String name) throws InterruptedException {
        synchronized (this) {
            while (maleCount == 3 || femaleCount > 0)
                wait();
            maleCount++;
        }
        useBathroom(name);
        synchronized (this) {
            maleCount--;
            notifyAll();
        }
    }

    private void useBathroom(String name) throws InterruptedException {
        System.out.println(name + " using bathroom. Current employees in bathroom = " + (maleCount != 0 ? maleCount : femaleCount));
        Thread.sleep(duration);
        System.out.println(name + " done using bathroom");
    }
}
