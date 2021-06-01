package org.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AsynchronousSynchronousProblem {
    private final Executor executor;
    private final AtomicInteger runningTasks;
    public AsynchronousSynchronousProblem(int timeout) {
        this.executor = new Executor(timeout);
        this.runningTasks = new AtomicInteger();
    }

    public void synchronousExecution(Callback callback) throws Exception {
        final boolean[] isDone = new boolean[1];

        Callback wrapper = () -> {
            callback.done();
            synchronized (isDone) {
                isDone[0] = true;
                isDone.notify();
            }
        };
        executor.asynchronousExecution(wrapper);
        synchronized (isDone) {
            while (!isDone[0])
                isDone.wait();
        }
    }

    public void asynchronousExecution(Callback callback) throws Exception {
        runningTasks.incrementAndGet();

        Callback wrapper = () -> {
            callback.done();
            runningTasks.decrementAndGet();
            synchronized (runningTasks) {
                if (runningTasks.get() == 0)
                    runningTasks.notify();
            }
        };
        executor.asynchronousExecution(wrapper);
    }

    public void await() throws InterruptedException {
        synchronized (runningTasks) {
            while (runningTasks.get() != 0)
                runningTasks.wait();
        }
    }
}

//can't change
interface Callback {
    void done();
}

//can't change
class Executor {
    private final int timeout;

    public Executor(int timeout) {
        this.timeout = timeout;
    }

    public void asynchronousExecution(Callback callback) throws Exception {
        Thread t = new Thread(() -> {
            // Do some useful work
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException ie) {
            }
            callback.done();
        });
        t.start();
    }
}
