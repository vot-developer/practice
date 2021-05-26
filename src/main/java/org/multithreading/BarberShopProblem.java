package org.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/*
A barbershop consists of a waiting room with n chairs, and a barber chair for giving haircuts.
If there are no customers to be served, the barber goes to sleep.
If a customer enters the barbershop and all chairs are occupied, then the customer leaves the shop.
If the barber is busy, but chairs are available, then the customer sits in one of the free chairs.
If the barber is asleep, the customer wakes up the barber. Write a program to coordinate the interaction
between the barber and the customers.
 */
public class BarberShopProblem {
    private final AtomicBoolean isRunning;
    private final int chairs;
    private final Semaphore barberDoingJob;
    private final Semaphore waitCustomer;
    private final ReentrantLock lock;
    private volatile int hairCut;
    private int waitingCustomers;


    public BarberShopProblem(int chairs) {
        this.isRunning = new AtomicBoolean(true);
        this.chairs = chairs;
        this.barberDoingJob = new Semaphore(1);
        this.waitCustomer = new Semaphore(0);
        this.lock = new ReentrantLock();
    }

    public void customerWalksIn() throws InterruptedException {
        lock.lock();
        if (waitingCustomers == chairs){
            lock.unlock();
            return;
        }
        waitingCustomers++;
        lock.unlock();

        waitCustomer.release();
        barberDoingJob.acquire();

        lock.lock();
        waitingCustomers--;
        lock.unlock();
    }

    public void barber() throws InterruptedException {
        while (isRunning.get()) {
            waitCustomer.acquire();
            if (isRunning.get())
                hairCut++;

            Thread.sleep(100l);
            barberDoingJob.release();
        }
    }

    public int getHairCut(){
        return hairCut;
    }

    public void stop(){
        isRunning.set(false);
        waitCustomer.release();
    }
}

