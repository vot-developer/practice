package org.multithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

/*
This is a classical synchronization problem proposed by Dijkstra.

Imagine you have five philosopher's sitting on a roundtable. The philosopher's do only two kinds of activities. One they contemplate, and two they eat. However, they have only five forks between themselves to eat their food with. Each philosopher requires both the fork to his left and the fork to his right to eat his food.

The arrangement of the philosophers and the forks are shown in the diagram.

Design a solution where each philosopher gets a chance to eat his food without causing a deadlock
 */
public class DiningPhilosophers {
    private final Random random = new Random(System.currentTimeMillis());
    private final Semaphore[] forks = new Semaphore[5];

    // Initializing the semaphores with a permit of 1
    public DiningPhilosophers() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    // Represents how a philosopher lives his life
    public void lifecycleOfPhilosopher(int id) throws InterruptedException {
        int k = 10;
        while (k-- > 0) {
            contemplate();
            eat(id);
        }
    }

    // We can sleep the thread when the philosopher is thinking
    private void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(200));
    }

    // This method will have the meat of the solution, where the
    // philosopher is trying to eat.
    private void eat(int id) throws InterruptedException {
        if (id == 0){ //one does left first
            forks[(id + 4) % 5].acquire();
            forks[id].acquire();
        } else { //another does right first
            forks[id].acquire();
            forks[(id + 4) % 5].acquire();
        }
        System.out.println(id + " is eating");
        forks[id].release();
        forks[(id + 4) % 5].release();
    }
}
