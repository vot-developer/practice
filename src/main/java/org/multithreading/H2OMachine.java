package org.multithreading;

import java.util.concurrent.Semaphore;

public class H2OMachine {
    private final Semaphore semaphoreH;
    private final Semaphore semaphoreO;

    public H2OMachine() {
        this.semaphoreH = new Semaphore(2);
        this.semaphoreO = new Semaphore(0);
    }

    public void HydrogenAtom() throws InterruptedException {
        semaphoreH.acquire();
        System.out.println("H");
        semaphoreO.release();
    }

    public void OxygenAtom() throws InterruptedException {
        semaphoreO.acquire(2);
        System.out.println("O");
        semaphoreH.release(2);
    }
}
