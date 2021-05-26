package org.multithreading;

import org.junit.jupiter.api.Test;

class DiningPhilosophersTest {

    @Test
    void lifecycleOfPhilosopher() throws InterruptedException {
        final DiningPhilosophers dp = new DiningPhilosophers();

        Thread p1 = new Thread(() -> {
            startPhilosoper(dp, 0);
        });

        Thread p2 = new Thread(() -> {
            startPhilosoper(dp, 1);
        });

        Thread p3 = new Thread(() -> {
            startPhilosoper(dp, 2);
        });

        Thread p4 = new Thread(() -> {
            startPhilosoper(dp, 3);
        });

        Thread p5 = new Thread(() -> {
            startPhilosoper(dp, 4);
        });

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
    }

    private void startPhilosoper(DiningPhilosophers dp, int id) {
        try {
            dp.lifecycleOfPhilosopher(id);
        } catch (InterruptedException ie) {
        }
    }
}