package org.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnisexBathroomTest {

    @Test
    void maleUseBathroom() throws InterruptedException {
        final UnisexBathroom bathroom = new UnisexBathroom(3, 1000);
        Thread woman1 = new Thread(() -> {
            try {
                bathroom.femaleUseBathroom(Thread.currentThread().getName());
            } catch (InterruptedException e) {}
        });
        Thread woman2 = new Thread(woman1);
        Thread woman3 = new Thread(woman1);
        Thread woman4 = new Thread(woman1);
        Thread man1 = new Thread(() -> {
            try {
                bathroom.maleUseBathroom(Thread.currentThread().getName());
            } catch (InterruptedException e) {}
        });
        Thread man2 = new Thread(man1);
        long start = System.currentTimeMillis();
        man1.start();
        woman1.start();
        woman2.start();
        woman3.start();
        woman4.start();
        man2.start();
        man1.join();
        man2.join();
        woman1.join();
        woman2.join();
        woman3.join();
        woman4.join();
        long end = System.currentTimeMillis();
        assertTrue(end - start > 3000);
        assertTrue(end - start < 3200);
    }
}