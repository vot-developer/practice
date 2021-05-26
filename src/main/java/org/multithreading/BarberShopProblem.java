package org.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
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
    private final ReentrantLock lock;
    private final Condition sleep;
    private final Semaphore barberDoingJob;
    private int waitingCustomers;
    private int hairCut;


    public BarberShopProblem(int chairs) {
        this.isRunning = new AtomicBoolean(true);
        this.chairs = chairs;
        this.lock = new ReentrantLock();
        this.sleep = lock.newCondition();
        this.barberDoingJob = new Semaphore(1);
    }

    public void customerWalksIn() throws InterruptedException {
        lock.lock();
        if (waitingCustomers == chairs){
            lock.unlock();
            System.out.println("Customer has NOT cut");
            return;
        }

        if (waitingCustomers == 0)
            sleep.signal();

        waitingCustomers++;
        lock.unlock();

        barberDoingJob.acquire();
        System.out.println("Customer has cut");
    }

    public void barber() throws InterruptedException {
        while (isRunning.get()) {
            lock.lock();
            while (waitingCustomers == 0 && isRunning.get()) {
                sleep.await();
            }
            if (waitingCustomers > 0){
                waitingCustomers--;
                hairCut++;
                lock.unlock();

                try {
                    Thread.sleep(100l);
                } catch (InterruptedException e) {
                }
                System.out.println("Hair cut " + hairCut);
                barberDoingJob.release();
            } else
                lock.unlock();
        }
    }

    public int getHairCut(){
        int result;
        lock.lock();
        result = hairCut;
        lock.unlock();
        return result;
    }

    public void stop(){
        isRunning.set(false);
        lock.lock();
        sleep.signal();
        lock.unlock();
    }
}

