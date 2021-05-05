package org.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz {
    private final int n;
    private final ReentrantLock lock;
    private final Condition flag;
    private final StringBuilder result;
    private volatile int current;

    public FizzBuzz(int n, StringBuilder result) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.flag = lock.newCondition();
        this.result = result;
        current = 1;
    }

    public void fizz() throws InterruptedException {
        lock.lock();
        while (current <= n){
            if (current % 3 == 0 && current % 5 != 0){
                result.append("fizz ");
                current++;
                flag.signalAll();
            } else
                flag.await();
        }
        lock.unlock();
    }

    public void buzz() throws InterruptedException {
        lock.lock();
        while (current <= n){
            if (current % 3 != 0 && current % 5 == 0){
                result.append("buzz ");
                current++;
                flag.signalAll();
            } else
                flag.await();
        }
        lock.unlock();
    }

    public void fizzbuzz() throws InterruptedException {
        lock.lock();
        while (current <= n){
            if (current % 3 == 0 && current % 5 == 0){
                result.append("fizzbuzz ");
                current++;
                flag.signalAll();
            } else
                flag.await();
        }
        lock.unlock();
    }

    public void number() throws InterruptedException {
        lock.lock();
        while (current <= n){
            if (current % 3 != 0 && current % 5 != 0){
                result.append(current++).append(' ');
                flag.signalAll();
            } else
                flag.await();
        }
        lock.unlock();
    }

    public String getResult(){
        return result.toString();
    }
}
