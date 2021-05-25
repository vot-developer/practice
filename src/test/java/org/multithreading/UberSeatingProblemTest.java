package org.multithreading;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UberSeatingProblemTest {

    @Test
    void drive() throws InterruptedException {
        final UberSeatingProblem uberSeatingProblem = new UberSeatingProblem();
        Set<Thread> allThreads = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    uberSeatingProblem.seatDemocrat();
                } catch (InterruptedException ie) {
                    System.out.println("We have a problem");

                } catch (BrokenBarrierException bbe) {
                    System.out.println("We have a problem");
                }
            });
            thread.setName("Democrat_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(50);
        }

        for (int i = 0; i < 14; i++) {
            Thread thread = new Thread(() -> {
                try {
                    uberSeatingProblem.seatRepublican();
                } catch (InterruptedException ie) {
                    System.out.println("We have a problem");
                } catch (BrokenBarrierException bbe) {
                    System.out.println("We have a problem");
                }
            });
            thread.setName("Republican_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(30);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
        List<Integer> log = uberSeatingProblem.getLog();
        assertEquals(6, log.size()); //6 cars
        for (int i : log){
            if (i != 4 && i != 0 && i != -4) //possible cases - all democrats (4), all republicans (-4) or 2 and 2 (0)
                assertTrue(false);
        }
    }
}