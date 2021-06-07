package org.multithreading;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class H2OMachineTest {

    @Test
    void hydrogenAtom() throws InterruptedException {
        H2OMachine molecule = new H2OMachine();

        String input = "OOHHOHHHH";
        Set<Thread> threads = new HashSet<>(input.length());
        for (char c : input.toCharArray()){
            Thread t = new Thread(() -> {
                if (c == 'O'){
                    try {
                        molecule.OxygenAtom();
                    } catch (InterruptedException e) {
                    }
                } else {
                    try {
                        molecule.HydrogenAtom();
                    } catch (InterruptedException e) {
                    }
                }
            });
            threads.add(t);
            t.start();
        }

        for (Thread t : threads)
            t.join();
    }
}