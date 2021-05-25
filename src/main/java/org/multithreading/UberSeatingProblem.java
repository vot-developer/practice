package org.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {
    private final Semaphore demsWaiting;
    private final Semaphore repubsWaiting;
    private final CyclicBarrier barrier;
    private final ReentrantLock lock;
    private final List<Integer> log;
    private int republicans;
    private int democrats;
    private int logSum;
    private int logCount;
    private final ReentrantLock lockLog;

    public UberSeatingProblem() {
        this.demsWaiting = new Semaphore(0);
        this.repubsWaiting = new Semaphore(0);
        this.barrier = new CyclicBarrier(4);
        this.lock = new ReentrantLock();
        this.log = new LinkedList<>();
        this.lockLog = new ReentrantLock();
    }

    void drive() {
        System.out.println("Uber Ride on Its wayyyy... with ride leader " + Thread.currentThread().getName());
        System.out.flush();
    }

    void seatDemocrat() throws InterruptedException, BrokenBarrierException {
        lock.lock();
        boolean isLeader = false;
        if (democrats == 3) {
            isLeader = true;
            demsWaiting.release(3);
            democrats = 0;
        } else if (democrats >= 1 && republicans >= 2) {
            isLeader = true;
            demsWaiting.release(1);
            repubsWaiting.release(2);
            democrats -= 1;
            republicans -= 2;
        } else {
            democrats++;
            lock.unlock();
            demsWaiting.acquire();
        }

        barrier.await();
        seated(1);
        if (isLeader){
            drive();
            lock.unlock();
        }
    }

    void seated(int i) {
        lockLog.lock();
        logSum += i;
        logCount++;
        if (logCount == 4){
            logCount = 0;
            log.add(logSum);
        }
        lockLog.unlock();
        System.out.println(Thread.currentThread().getName() + "  seated");
        System.out.flush();
    }

    void seatRepublican() throws InterruptedException, BrokenBarrierException {
        lock.lock();
        boolean isLeader = false;
        if (republicans == 3) {
            isLeader = true;
            repubsWaiting.release(3);
            republicans = 0;
        } else if (republicans >= 1 && democrats >= 2) {
            isLeader = true;
            repubsWaiting.release(1);
            demsWaiting.release(2);
            republicans -= 1;
            democrats -= 2;
        } else {
            republicans++;
            lock.unlock();
            repubsWaiting.acquire();
        }

        barrier.await();
        seated(-1);
        if (isLeader){
            drive();
            lock.unlock();
        }
    }

    public List<Integer> getLog() {
        List<Integer> result;
        lockLog.lock();
        result = new ArrayList<>(log);
        lockLog.unlock();
        return result;
    }
}
