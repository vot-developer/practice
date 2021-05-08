package org.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private final int n;
    private final ReentrantLock lock;
    private final Condition flag;
    private boolean isBar;

    public FooBar(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.flag = lock.newCondition();
        this.isBar = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                while (isBar)
                    flag.await();
                printFoo.run();
                isBar = true;
                flag.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                while (!isBar)
                    flag.await();
                printBar.run();
                isBar = false;
                flag.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
