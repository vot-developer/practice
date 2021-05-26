package org.multithreading;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarberShopProblemTest {

    @Test
    void customerWalksIn() throws InterruptedException {
        Set<Thread> set = new HashSet<>();
        final BarberShopProblem barberShopProblem = new BarberShopProblem(10);

        Thread barberThread = new Thread(() -> {
            try {
                barberShopProblem.barber();
            } catch (InterruptedException e) {
            }
        });
        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException e) {
                }
            });
            set.add(t);
        }

        for (Thread t : set)
            t.start();
        for (Thread t : set)
            t.join();
        set.clear();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException e) {
                }
            });
            set.add(t);
        }
        for (Thread t : set)
            t.start();
        for (Thread t : set)
            t.join();
        barberShopProblem.stop();
        barberThread.join();
        assertEquals(15, barberShopProblem.getHairCut());
    }
}